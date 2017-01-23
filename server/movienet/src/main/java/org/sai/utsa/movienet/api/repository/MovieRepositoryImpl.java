package org.sai.utsa.movienet.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.sai.utsa.movienet.api.entity.Movie;
import org.sai.utsa.movienet.api.helper.Catalog;
import org.springframework.stereotype.Repository;



@Repository
public class MovieRepositoryImpl implements MovieRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String movieId) {
		
		return em.find(Movie.class, movieId);
	}

	@Override
	public Movie update(Movie movie) {
		// 
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);

	}

	@Override
	public List<Catalog> findTopRatedMovies() {
		TypedQuery<Catalog> query = em.createNamedQuery("Movie.findTopRatedMovies", Catalog.class);
		return query.getResultList();
	}

	@Override
	public List<Catalog> findTopRatedTvSeries() {
		TypedQuery<Catalog> query = em.createNamedQuery("Movie.findTopRatedTvSeries", Catalog.class);
		return query.getResultList();
	}

	@Override
	public List<Catalog> sortByImdbRatings(String sortOrder) {
		TypedQuery<Catalog> query = null;
		if(sortOrder.equalsIgnoreCase("asc"))
		{
			query = em.createNamedQuery("Movie.sortByImdbRatingsAsc", Catalog.class);
		}
		else
		if(sortOrder.equalsIgnoreCase("desc"))
		{
			query = em.createNamedQuery("Movie.sortByImdbRatingsDesc", Catalog.class);
		}
		return query.getResultList();
	}

	@Override
	public List<Catalog> sortByYear(String sortOrder) {
		TypedQuery<Catalog> query = null;
		if(sortOrder.equalsIgnoreCase("asc"))
		{
			query = em.createNamedQuery("Movie.sortByYearAsc", Catalog.class);
			
		}
		else
		if(sortOrder.equalsIgnoreCase("desc"))
		{
			query = em.createNamedQuery("Movie.sortByYearDesc", Catalog.class);
		}
		return query.getResultList();
		
	
	}

	@Override
	public List<Catalog> sortByImdbVotes(String sortOrder) {
		TypedQuery<Catalog> query = null;
		if(sortOrder.equalsIgnoreCase("asc"))
		{
			query = em.createNamedQuery("Movie.sortByImdbVotesAsc", Catalog.class);
			
		}
		else
		if(sortOrder.equalsIgnoreCase("desc"))
		{
			query = em.createNamedQuery("Movie.sortByImdbVotesDesc", Catalog.class);
		}
		return query.getResultList();
	}

	@Override
	public Movie create(Movie movie) {
		
		em.persist(movie);
		return movie;
	}

	@Override
	public List<Catalog> getCatalog(String type) {
		TypedQuery<Catalog> query = em.createNamedQuery("Movie.getCatalog", Catalog.class);
		query.setParameter("pType", type);
		return query.getResultList();
		
	}

	@Override
	public List<Catalog> searchByYear(int searchField) {
		TypedQuery<Catalog> query = em.createNamedQuery("Movie.searchByYear", Catalog.class);
		query.setParameter("pSearchbyyear", searchField);
		return query.getResultList();
	}

	@Override
	public List<Catalog> searchByGenre(String searchField) {
		TypedQuery<Catalog> query = em.createNamedQuery("Movie.searchByGenre", Catalog.class);
		query.setParameter("pSearchbygenre", searchField);
		return query.getResultList();
	}

	

}
