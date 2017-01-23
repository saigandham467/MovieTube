package org.sai.utsa.movienet.api.service;

import java.util.List;

import org.sai.utsa.movienet.api.entity.Movie;
import org.sai.utsa.movienet.api.exception.BadRequestException;
import org.sai.utsa.movienet.api.exception.EntityNotFoundException;
import org.sai.utsa.movienet.api.helper.Catalog;
import org.sai.utsa.movienet.api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepository;

	@Override
	@Transactional(readOnly=true)
	public List<Movie> findAll() {
		
		return movieRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Movie findOne(String movieId) {

		Movie movie=movieRepository.findOne(movieId);
		if(movie==null)
		{
			throw new EntityNotFoundException("movie not found");
		}
		return movie;
	}

	@Override
	@Transactional
	public Movie create(Movie movie) {
		
		Movie existing = movieRepository.findOne(movie.getImdbId());
		if(existing != null)
		{
			throw new BadRequestException("movie with this id already exists"); 
		}
		return movieRepository.create(movie);
	}

	@Override
	@Transactional
	public Movie update(String id, Movie movie) {
		
		Movie existing = movieRepository.findOne(id);
		if(existing==null)
		{
			throw new EntityNotFoundException("movie not found");
		}
		return movieRepository.update(movie);
	}

	@Override
	@Transactional
	public void delete(String id) {
		
		Movie existing = movieRepository.findOne(id);
		if(existing==null)
		{
			throw new EntityNotFoundException("movie not found");
		}
		movieRepository.delete(existing);

	}

	@Override
	@Transactional(readOnly=true)
	public List<Catalog> findTopRatedMovies() {
		
		return movieRepository.findTopRatedMovies();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Catalog> findTopRatedTvSeries() {
		
		return movieRepository.findTopRatedTvSeries();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Catalog> sortByImdbRatings(String sortOrder) {
	
		
		return movieRepository.sortByImdbRatings(sortOrder);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Catalog> sortByYear(String sortOrder) {
		
		return movieRepository.sortByYear(sortOrder);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Catalog> sortByImdbVotes(String sortOrder) {
		
		return movieRepository.sortByImdbVotes(sortOrder);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Catalog> getCatalog(String type) {
		return movieRepository.getCatalog(type);
	}

	

	@Override
	@Transactional(readOnly=true)
	public List<Catalog> searchByYear(int searchField) {
		return movieRepository.searchByYear(searchField);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Catalog> searchByGenre(String searchField) {
		return movieRepository.searchByGenre(searchField);
	}

	@Override
	@Transactional(readOnly=true)
	public String getImdbLink(String movieid) {
		Movie existing = movieRepository.findOne(movieid);
		if(existing==null)
		{
			throw new EntityNotFoundException("movie not found");
		}
		return "http://www.imdb.com/title/"+movieid;
	}

}

