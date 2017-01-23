package org.sai.utsa.movienet.api.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Comment.findComments",query="SELECT c FROM Comment c WHERE c.movieId=:pMovieid")
})
public class Comment {
	@Id
	private String commentId;
	private String comment;
	private String userName;
	private String movieId;
	public Comment()
	{
		commentId=UUID.randomUUID().toString();
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMovieid() {
		return movieId;
	}
	public void setMovieid(String movieid) {
		this.movieId = movieid;
	}
	public String getCommentId() {
		return commentId;
	}

}
