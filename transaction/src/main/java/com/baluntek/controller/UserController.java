package com.baluntek.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baluntek.damain.User;
import com.baluntek.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	private static final Logger log = Logger.getLogger(UserController.class);

	@RequestMapping("/save")
	@Transactional
	public String sava() {
		try {
			this.saveUser();
		} catch (Exception e) {
			throw new RuntimeException("对不起出丑了");
		}
		
		
		return "hello world";
	}
	
	
	public void saveUser() {
		User user = new User("zhangsan");
		this.userService.save(user);
		int i = 1/0;
		log.info(i);
		User user2 = new User("zhangsan");
		this.userService.save(user2);
	}
}
