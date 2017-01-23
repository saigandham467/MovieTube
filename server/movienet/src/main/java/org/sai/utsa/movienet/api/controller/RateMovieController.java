package org.sai.utsa.movienet.api.controller;

import org.sai.utsa.movienet.api.entity.RateMovie;
import org.sai.utsa.movienet.api.service.RateMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ratings")
public class RateMovieController {
	@Autowired
	private RateMovieService rateMovieService;
	
	@RequestMapping(method=RequestMethod.POST)
	public RateMovie addRating(@RequestBody RateMovie rateMovie)
	{
		return rateMovieService.addRating(rateMovie);
	}
	
	@RequestMapping(method=RequestMethod.GET,value = "{id}")
	public Double getAvgRating(@PathVariable("id") String movieId)
	{
		return rateMovieService.getAvgRating(movieId);
	}

}
