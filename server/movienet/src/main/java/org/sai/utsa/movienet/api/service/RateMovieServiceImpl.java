package org.sai.utsa.movienet.api.service;

import org.sai.utsa.movienet.api.entity.RateMovie;
import org.sai.utsa.movienet.api.exception.EntityNotFoundException;
import org.sai.utsa.movienet.api.repository.RateMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RateMovieServiceImpl implements RateMovieService {
	@Autowired
	private RateMovieRepository rateMovieRepository;

	@Override
	@Transactional
	public RateMovie addRating(RateMovie rateMovie) {
		boolean movieAndUserExisting  = rateMovieRepository.findMovieAndUser(rateMovie);
		
		if(!movieAndUserExisting)
		{
			throw new EntityNotFoundException("movie or user not found");
		}
		return rateMovieRepository.addRating(rateMovie);
	}

	@Override
	@Transactional(readOnly=true)
	public Double getAvgRating(String movieId) {
		// TODO Auto-generated method stub
		return rateMovieRepository.getAvgRating(movieId);
	}

}
