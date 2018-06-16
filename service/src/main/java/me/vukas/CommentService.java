package me.vukas;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CommentService {

	private CommentRepository commentRepo;

	public CommentService(CommentRepository commentRepo){
		this.commentRepo = commentRepo;
	}

	@HystrixCommand
	public Comment getComment(Integer id){
		randomLong();
		return commentRepo.findById(id).orElse(new Comment());
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
