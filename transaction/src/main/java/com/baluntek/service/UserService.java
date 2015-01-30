package com.baluntek.service;



import org.springframework.transaction.annotation.Transactional;

import com.baluntek.damain.User;


public interface UserService {

	@Transactional
	public void save(User user);
}
