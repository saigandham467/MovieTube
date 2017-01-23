package org.sai.utsa.movienet.api.repository;

import org.sai.utsa.movienet.api.entity.RateMovie;

public interface RateMovieRepository {

	public RateMovie addRating(RateMovie rateMovie);

	public Double getAvgRating(String movieId);

	public boolean findMovieAndUser(RateMovie ratemovie);

}
