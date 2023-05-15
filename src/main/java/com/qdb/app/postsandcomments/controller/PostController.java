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

import com.qdb.app.postsandcomments.model.PostModel;
import com.qdb.app.postsandcomments.service.PostsServiceInt;

@RestController
@RequestMapping("/api/v1.0")
public class PostController {

	@Autowired
	private PostsServiceInt postsServiceInt;

	
	@GetMapping("/posts")
	public ResponseEntity<?> getAllPosts(){
		List<PostModel> posts = postsServiceInt.getAllPosts();
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(posts);
	}
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<?> getPostByPostId(@PathVariable(name = "postId")int postId){
		PostModel post = postsServiceInt.getPostByPostId(postId);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(post);
	}
	
	@PostMapping("/posts")
	public ResponseEntity<?> createPost(@RequestBody PostModel createPost){
		PostModel createdPost = postsServiceInt.createPost(createPost);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(createdPost);
	}
}
