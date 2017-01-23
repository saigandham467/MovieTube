package org.sai.utsa.movienet.api.controller;

import java.util.List;

import org.sai.utsa.movienet.api.entity.Comment;
import org.sai.utsa.movienet.api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comments")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(method=RequestMethod.POST)
	public Comment addComment(@RequestBody Comment comment)
	{
		return commentService.addComment(comment);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value="{id}")
	public List<Comment> findComments(@PathVariable("id") String movieId)
	{
		return commentService.findComments(movieId);
	}

}
