package org.sai.utsa.movienet.api.service;


import java.util.List;

import org.sai.utsa.movienet.api.entity.Comment;

public interface CommentService {

	public Comment addComment(Comment comment);

	public List<Comment> findComments(String movieId);

}
