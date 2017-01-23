package org.sai.utsa.movienet.api.controller;

import java.util.List;
import org.sai.utsa.movienet.api.entity.Movie;
import org.sai.utsa.movienet.api.helper.Catalog;
import org.sai.utsa.movienet.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "movies")
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findAll() {
		return movieService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Movie findOne(@PathVariable("id") String movieId) {
		return movieService.findOne(movieId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Movie create(@RequestBody Movie movie) {
		return movieService.create(movie);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Movie update(@PathVariable("id") String id, @RequestBody Movie movie) {
		return movieService.update(id, movie);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		movieService.delete(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/topmovies")
	public List<Catalog> findTopRatedMovies()
	{
		return movieService.findTopRatedMovies();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/toptvseries")
	public List<Catalog> findTopRatedTvSeries()
	{
		return movieService.findTopRatedTvSeries();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/sort/imdbrating/{order}")
	public List<Catalog> sortByImdbRatings(@PathVariable("order") String sortOrder)
	{
		return movieService.sortByImdbRatings(sortOrder);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/sort/year/{order}")
	public List<Catalog> sortByYear(@PathVariable("order") String sortOrder)
	{
		return movieService.sortByYear(sortOrder);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/sort/imdbvotes/{order}")
	public List<Catalog> sortByImdbVotes(@PathVariable("order") String sortOrder)
	{
		return movieService.sortByImdbVotes(sortOrder);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/catalog/{category}")
	public List<Catalog> getCatalog(@PathVariable("category") String type )
	{
		return movieService.getCatalog(type);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/catalog/year/{field}")
	public List<Catalog> searchByYear(@PathVariable("field") int searchfield)
	{
		return movieService.searchByYear(searchfield);
	}
	@RequestMapping(method=RequestMethod.GET,value="/catalog/genre/{field}")
	public List<Catalog> searchByGenre(@PathVariable("field") String searchfield)
	{
		return movieService.searchByGenre(searchfield);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="imdblink/{id}")
	public String getImdbLink(@PathVariable("id") String title)
	{
		return movieService.getImdbLink(title);
	}

}

