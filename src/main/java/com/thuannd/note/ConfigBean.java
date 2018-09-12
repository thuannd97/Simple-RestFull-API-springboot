package com.thuannd.note;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thuannd.note.service.PostService;
import com.thuannd.note.service.UserService;
import com.thuannd.service.impl.PostServiceImpl;
import com.thuannd.service.impl.UserServiceImpl;

@Configuration
public class ConfigBean {
	
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
	
	@Bean
	public PostService postService() {
		return new PostServiceImpl();
	}
}
