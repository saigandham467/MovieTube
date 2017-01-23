package org.sai.utsa.movienet.api.controller;

import org.sai.utsa.movienet.api.service.UserService;
import org.sai.utsa.movienet.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "loginpage")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST,value="/signup")
	public User registerUser(@RequestBody User user){
		
		return userService.registerUser(user);
		
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/signin")
	public boolean signinUser(@RequestBody User user)
	{
		return userService.signinUser(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/signout")
	public void signOutUser()
	{
		userService.signOutUser();
	}

}