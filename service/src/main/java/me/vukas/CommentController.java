package me.vukas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comments")
public class CommentController {

	private CommentService commentService;

	public CommentController(CommentService commentService){
		this.commentService = commentService;
	}

	@GetMapping("{id}")
	public Comment getString(@PathVariable Integer id){
		return this.commentService.getComment(id);
	}

}
