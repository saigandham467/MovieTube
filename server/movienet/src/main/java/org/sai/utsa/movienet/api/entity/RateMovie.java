package org.sai.utsa.movienet.api.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
@Entity
@NamedQueries({
	@NamedQuery(name="RateMovie.getAvgRating",query="SELECT AVG(r.rate) FROM RateMovie r WHERE r.movieId=:pMovieid")
})
public class RateMovie {
	@Id
	private String rateId;
	private String movieId;
	private String userName;
	@DecimalMax("5.0")
	@DecimalMin("0.0")
	private Double rate;
	public RateMovie()
	{
		rateId=UUID.randomUUID().toString();
	}
	public String getRateId() {
		return rateId;
	}
	public void setRateId(String rateId) {
		this.rateId = rateId;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userId) {
		this.userName = userId;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}

}
