package org.sai.utsa.movienet.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Movie")
@NamedQueries({ 
	@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
	@NamedQuery(name = "Movie.findTopRatedMovies", query = "SELECT m.title, m.poster FROM Movie m WHERE m.imdbRating = (SELECT MAX(m.imdbRating) FROM Movie m WHERE m.type = \"movie\")"),
	@NamedQuery(name = "Movie.findTopRatedTvSeries", query = "SELECT m.title, m.poster FROM Movie m WHERE  m.imdbRating = (SELECT MAX(m.imdbRating) FROM Movie m WHERE m.type = \"series\")"),
	@NamedQuery(name = "Movie.sortByImdbRatingsAsc", query = "SELECT m.title, m.poster FROM Movie m ORDER BY m.imdbRating ASC"),
	@NamedQuery(name = "Movie.sortByImdbRatingsDesc", query = "SELECT m.title, m.poster FROM Movie m ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.sortByYearAsc", query = "SELECT m.title, m.poster FROM Movie m ORDER BY m.year ASC"),
	@NamedQuery(name = "Movie.sortByYearDesc", query = "SELECT m.title, m.poster FROM Movie m ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.sortByImdbVotesAsc", query = "SELECT m.title, m.poster FROM Movie m ORDER BY m.imdbVotes ASC"),
	@NamedQuery(name = "Movie.sortByImdbVotesDesc", query = "SELECT m.title, m.poster FROM Movie m ORDER BY m.imdbVotes DESC"),
	@NamedQuery(name = "Movie.getCatalog", query = "SELECT m.title, m.poster FROM Movie m WHERE m.type=:pType"),
	@NamedQuery(name = "Movie.searchByYear", query = "SELECT m.title, m.poster FROM Movie m WHERE m.year=:pSearchbyyear"),
	@NamedQuery(name = "Movie.searchByGenre", query = "SELECT m.title, m.poster FROM Movie m WHERE m.genre=:pSearchbygenre")
})
public class Movie {
	@Id
	private String imdbId;
	private String title;
	private int year;
	private String rated;
	private String released;
	private int runTime;
	private String genre;
	private String director;
	private String writer;
	private String actors;
	@Column(length=1000)
	private String plot;
	private String language;
	private String country;
	private String awards;
	private int metaScore;
	private double imdbRating;
	private int imdbVotes;
	private String poster;
	private String imdbMovieLink;
	private String type;
	
	
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public String getReleased() {
		return released;
	}
	public void setReleased(String released) {
		this.released = released;
	}
	public int getRunTime() {
		return runTime;
	}
	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public int getMetaScore() {
		return metaScore;
	}
	public void setMetaScore(int metaScore) {
		this.metaScore = metaScore;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public int getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getPoster() {
		return poster;
	}
	public void setPosterLink(String poster) {
		this.poster = poster;
	}
	public String getImdbMovieLink() {
		return imdbMovieLink;
	}
	public void setImdbMovieLink(String imdbMovieLink) {
		this.imdbMovieLink = imdbMovieLink;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}

