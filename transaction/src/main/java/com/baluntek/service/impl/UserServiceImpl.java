package com.baluntek.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baluntek.damain.User;
import com.baluntek.repository.UserRepository;
import com.baluntek.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public void save(User user) {
		this.userRepository.save(user);
	}

}
