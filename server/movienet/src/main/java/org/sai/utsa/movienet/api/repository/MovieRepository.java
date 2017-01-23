package org.sai.utsa.movienet.api.repository;

import java.util.List;

import org.sai.utsa.movienet.api.entity.Movie;
import org.sai.utsa.movienet.api.helper.Catalog;


public interface MovieRepository {

	public List<Movie> findAll();

	public Movie findOne(String movieId);

	public Movie update(Movie movie);

	public void delete(Movie existing);

	public List<Catalog> findTopRatedMovies();

	public List<Catalog> findTopRatedTvSeries();

	public List<Catalog> sortByImdbRatings(String sortOrder);

	public List<Catalog> sortByYear(String sortOrder);

	public List<Catalog> sortByImdbVotes(String sortOrder);

	public Movie create(Movie movie);

	public List<Catalog> getCatalog(String type);

	public List<Catalog> searchByYear(int searchField);

	public List<Catalog> searchByGenre(String searchField);

}

