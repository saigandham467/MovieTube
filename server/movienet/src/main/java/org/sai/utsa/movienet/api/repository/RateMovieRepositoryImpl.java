package org.sai.utsa.movienet.api.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sai.utsa.movienet.api.entity.Movie;
import org.sai.utsa.movienet.api.entity.RateMovie;
import org.sai.utsa.movienet.api.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class RateMovieRepositoryImpl implements RateMovieRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public RateMovie addRating(RateMovie rateMovie) {
		em.persist(rateMovie);
		return rateMovie;
	}

	@Override
	public Double getAvgRating(String movieId) {
		Query query = em.createNamedQuery("RateMovie.getAvgRating", RateMovie.class);
		query.setParameter("pMovieid", movieId);
		return (Double) query.getSingleResult();
	}

	@Override
	public boolean findMovieAndUser(RateMovie rateMovie) {
		Movie movie=em.find(Movie.class, rateMovie.getMovieId());
		User user=em.find(User.class, rateMovie.getUserName());
		if(movie==null || user == null)
		{
			return false;
		}
		return true;
	}

}
