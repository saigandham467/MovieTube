package org.sai.utsa.movienet.api.repository;

import java.util.List;

import org.sai.utsa.movienet.api.entity.Comment;
import org.sai.utsa.movienet.api.entity.Movie;

public interface CommentRepository {

	public Comment addComment(Comment comment);

	public List<Comment> findComments(String movieId);

	public Movie findMovie(String movieid);

}
