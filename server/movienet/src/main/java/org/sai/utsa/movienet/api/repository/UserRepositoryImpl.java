package org.sai.utsa.movienet.api.repository;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sai.utsa.movienet.api.entity.User;
import org.springframework.stereotype.Repository;
@Repository
public class UserRepositoryImpl implements UserRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public User find(String loginId) {
		
		return em.find(User.class, loginId);
	}

	@Override
	public User registerUser(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User findByLoginPassword(String loginId) {
		// TODO Auto-generated method stub
		return em.find(User.class, loginId);
	}

}
