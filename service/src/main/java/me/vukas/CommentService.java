package me.vukas;

import org.springframework.stereotype.Service;

@Service
public class CommentService {

	private CommentRepository commentRepo;

	public CommentService(CommentRepository commentRepo){
		this.commentRepo = commentRepo;
	}

	public Comment getComment(Integer id){
		return commentRepo.findById(id).orElse(new Comment());
	}

}
