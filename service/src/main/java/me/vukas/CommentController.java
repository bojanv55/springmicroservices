package me.vukas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comments")
public class CommentController {

	@Autowired
	@Lazy
	private ServiceConfig config;

	private CommentService commentService;

	public CommentController(CommentService commentService){
		this.commentService = commentService;
	}

	@GetMapping("{id}")
	public Comment getString(@PathVariable Integer id){
		Comment result = commentService.getComment(id);
		result.setContent(result.getContent() + config.getSomeProp());	//concat prop to content
		return result;
	}

	@PostMapping("text")
	public String getText(){
		return "Text";
	}

}
