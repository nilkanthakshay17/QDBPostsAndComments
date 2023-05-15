package com.qdb.app.postsandcomments.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qdb.app.postsandcomments.model.CommentModel;

@Service
public interface CommentsServiceInt {

	public List<CommentModel> getAllComments();
	public CommentModel getCommentByCommentId(int commentId);
	public CommentModel createComment(CommentModel commentModel);
}
