package org.sai.utsa.movienet.api.service;

import java.util.List;

import org.sai.utsa.movienet.api.entity.Movie;
import org.sai.utsa.movienet.api.helper.Catalog;


public interface MovieService {

	public List<Movie> findAll();

	public Movie findOne(String movieId);

	public Movie create(Movie movie);

	public Movie update(String id, Movie movie);

	public void delete(String id);

	public List<Catalog> findTopRatedMovies();

	public List<Catalog> findTopRatedTvSeries();

	public List<Catalog> sortByImdbRatings(String sortOrder);

	public List<Catalog> sortByYear(String sortOrder);

	public List<Catalog> sortByImdbVotes(String sortOrder);

	public List<Catalog> getCatalog(String type);

	public List<Catalog> searchByYear(int searchfield);

	public List<Catalog> searchByGenre(String searchfield);

	public String getImdbLink(String title);

}
