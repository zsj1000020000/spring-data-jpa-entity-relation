package com.baluntek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.baluntek.service.UserService;

@SpringBootApplication
public class Application  {

	@Autowired
	private UserService userService;
	
	
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
			
   
}
