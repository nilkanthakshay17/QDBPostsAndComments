package com.qdb.app.postsandcomments.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qdb.app.postsandcomments.model.PostModel;

@Service
public class PostsServiceImpl implements PostsServiceInt{

	@Autowired
	private RestTemplate restTemplate;
	
	private static String BASE_URL ="https://jsonplaceholder.typicode.com";
	
	
	private HttpEntity<String> entity;
	private HttpHeaders headers;
	
	public PostsServiceImpl() {
		headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		entity = new HttpEntity<String>(headers);
	}
	
	@Override
	public List<PostModel> getAllPosts() {
		String getAllPostsURL = BASE_URL+"/posts";
		
		List<PostModel> posts = new ArrayList<>();
		
		ResponseEntity<PostModel[]> responseEntity = restTemplate.exchange(getAllPostsURL, HttpMethod.GET, entity, PostModel[].class);
		
		for(PostModel post:responseEntity.getBody())
			posts.add(post);
		
		return posts;
	}

	@Override
	public PostModel getPostByPostId(int postId) {
		String getPostByPostIdURL = BASE_URL+"/posts/"+postId;
	
		ResponseEntity<PostModel> responseEntity = restTemplate.exchange(getPostByPostIdURL, HttpMethod.GET, entity, PostModel.class);

		PostModel post = responseEntity.getBody();
	
		return post;
	}

	@Override
	public PostModel createPost(PostModel postModel) {
		String createPostURL = BASE_URL+"/posts";
		
		PostModel createdPost = restTemplate.postForObject(createPostURL, postModel, PostModel.class);
		
		return createdPost;
	}

}
