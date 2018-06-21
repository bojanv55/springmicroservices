package me.vukas;

import brave.Span;
import brave.Tracer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CommentService {

	@Autowired
	private Tracer tracer;

	private CommentRepository commentRepo;

	public CommentService(CommentRepository commentRepo){
		this.commentRepo = commentRepo;
	}

	@HystrixCommand(commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
			value = "1000")
	},
	fallbackMethod = "dajCmt",
	threadPoolKey = "nazivTreda",
	threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "30"),
			@HystrixProperty(name = "maxQueueSize", value = "10")
	})
	public Comment getComment(Integer id){
		Span span = tracer.nextSpan().name("jdbcSpan");
		try (Tracer.SpanInScope ws = this.tracer.withSpanInScope(span.start())) {
			randomLong();
			Comment c = commentRepo.findById(id).orElse(new Comment());
			span.tag("some.srv", "jdbc");
			span.annotate("jdbcFinished");
			return c;
		}
		finally {
			span.finish();
		}
	}

	private Comment dajCmt(Integer id){
		return new Comment();
	}

	private void randomLong(){
		Random r = new Random();
		int rn = r.nextInt((3-1)+1)+1;
		if(rn==3) sleep();
	}

	private void sleep() {
		try {
			Thread.sleep(11000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
