package org.sai.utsa.movienet.api.repository;

import org.sai.utsa.movienet.api.entity.User;

public interface UserRepository {

	public User find(String loginId);

	public User registerUser(User user);

	public User findByLoginPassword(String loginId);

}
