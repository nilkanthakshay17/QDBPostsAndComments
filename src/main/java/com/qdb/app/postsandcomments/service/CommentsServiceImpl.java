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

import com.qdb.app.postsandcomments.model.CommentModel;

@Service
public class CommentsServiceImpl implements CommentsServiceInt {

	@Autowired
	private RestTemplate restTemplate;

	private static String BASE_URL = "https://jsonplaceholder.typicode.com";

	private HttpEntity<String> entity;
	private HttpHeaders headers;

	public CommentsServiceImpl() {
		headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		entity = new HttpEntity<String>(headers);
	}

	@Override
	public List<CommentModel> getAllComments() {
		String getAllCommentsURL = BASE_URL + "/comments";

		List<CommentModel> comments = new ArrayList<>();

		ResponseEntity<CommentModel[]> responseEntity = restTemplate.exchange(getAllCommentsURL, HttpMethod.GET, entity,
				CommentModel[].class);

		for (CommentModel comment : responseEntity.getBody())
			comments.add(comment);

		return comments;
	}

	@Override
	public CommentModel getCommentByCommentId(int commentId) {
		String getCommentByCommentURL = BASE_URL + "/comments/" + commentId;

		ResponseEntity<CommentModel> responseEntity = restTemplate.exchange(getCommentByCommentURL, HttpMethod.GET,
				entity, CommentModel.class);

		CommentModel comment = responseEntity.getBody();

		return comment;
	}

	@Override
	public CommentModel createComment(CommentModel commentModel) {
		String createCommentURL = BASE_URL + "/comments";

		CommentModel createdComment = restTemplate.postForObject(createCommentURL, commentModel, CommentModel.class);

		return createdComment;
	}

}
