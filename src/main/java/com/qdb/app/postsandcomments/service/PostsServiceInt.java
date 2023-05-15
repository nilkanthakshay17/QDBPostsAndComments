package com.qdb.app.postsandcomments.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qdb.app.postsandcomments.model.PostModel;

@Service
public interface PostsServiceInt {
	
	public List<PostModel> getAllPosts();
	public PostModel getPostByPostId(int postId);
	public PostModel createPost(PostModel postModel);
}
