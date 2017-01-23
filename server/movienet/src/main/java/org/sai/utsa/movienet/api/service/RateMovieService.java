package org.sai.utsa.movienet.api.service;

import org.sai.utsa.movienet.api.entity.RateMovie;

public interface RateMovieService {

	public RateMovie addRating(RateMovie rateMovie);

	public Double getAvgRating(String movieId);

}
