package com.qdb.app.postsandcomments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qdb.app.postsandcomments.model.CommentModel;
import com.qdb.app.postsandcomments.service.CommentsServiceInt;

@RestController
@RequestMapping("/api/v1.0")
public class CommentController {

	@Autowired
	private CommentsServiceInt commentsServiceInt;
	
	@GetMapping("/comments")
	public ResponseEntity<?> getAllComments(){
		List<CommentModel> comments = commentsServiceInt.getAllComments();
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(comments);
	}
	
	@GetMapping("/comments/{commentId}")
	public ResponseEntity<?> getCommentByCommentId(@PathVariable(name = "commentId")int commentId){
		CommentModel comment = commentsServiceInt.getCommentByCommentId(commentId);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(comment);
	}
	
	@PostMapping("/comments")
	public ResponseEntity<?> createComment(@RequestBody CommentModel createComment){
		CommentModel createdComment = commentsServiceInt.createComment(createComment);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(createdComment);
	}
}
