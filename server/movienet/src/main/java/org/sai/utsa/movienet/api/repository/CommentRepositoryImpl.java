package org.sai.utsa.movienet.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.sai.utsa.movienet.api.entity.Comment;
import org.sai.utsa.movienet.api.entity.Movie;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepositoryImpl implements CommentRepository {
	@PersistenceContext
	private EntityManager em;
	@Override
	public Comment addComment(Comment comment) {
		em.persist(comment);
		return comment;
	}

	@Override
	public List<Comment> findComments(String movieId) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findComments", Comment.class);
		query.setParameter("pMovieid", movieId);
		return query.getResultList();
	}

	@Override
	public Movie findMovie(String movieId) {
		
		return em.find(Movie.class, movieId);
	}

}
