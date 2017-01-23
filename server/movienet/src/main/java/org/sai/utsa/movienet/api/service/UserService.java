package org.sai.utsa.movienet.api.service;

import org.sai.utsa.movienet.api.entity.User;

public interface UserService {

	public User registerUser(User user);

	public boolean signinUser(User user);

	public void signOutUser();

}
