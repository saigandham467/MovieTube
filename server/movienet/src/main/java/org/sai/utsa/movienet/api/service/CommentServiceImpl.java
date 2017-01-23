package org.sai.utsa.movienet.api.service;

import java.util.List;
import org.sai.utsa.movienet.api.entity.Comment;
import org.sai.utsa.movienet.api.entity.Movie;
import org.sai.utsa.movienet.api.exception.EntityNotFoundException;
import org.sai.utsa.movienet.api.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepository;
	@Override
	@Transactional
	public Comment addComment(Comment comment) {
		Movie existing = commentRepository.findMovie(comment.getMovieid());
		if(existing==null)
		{
			throw new EntityNotFoundException("movie not found");
		}
		return commentRepository.addComment(comment);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Comment> findComments(String movieId) {
		
		return commentRepository.findComments(movieId);
	}

}
