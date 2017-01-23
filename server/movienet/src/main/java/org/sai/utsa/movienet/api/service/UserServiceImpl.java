package org.sai.utsa.movienet.api.service;

import org.sai.utsa.movienet.api.entity.User;
import org.sai.utsa.movienet.api.exception.UnauthorizedException;
import org.sai.utsa.movienet.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public User registerUser(User user) {
		User existing=userRepository.find(user.getLoginId());
		if(existing!=null)
		{
			throw new org.sai.utsa.movienet.api.exception.BadRequestException("user with this id already exists");	
		}
		return userRepository.registerUser(user);
	}

	@Override
	@Transactional
	public boolean signinUser(User user) {
		// TODO Auto-generated method stub
		User existing = userRepository.findByLoginPassword(user.getLoginId());
	    if(existing==null || !existing.getPasswordHash().equals(user.getPasswordHash()))
	    {
	    	throw new UnauthorizedException("either loginid or password is incorrect");
	    }
		return true;
	}

	@Override
	@Transactional
	public void signOutUser() {
		// TODO Auto-generated method stub

	}

}
