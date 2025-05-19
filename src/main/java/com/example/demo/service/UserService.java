package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
	
	public String registerUser(User user);
	
	public String loginUser(String userName,String userPassword);

}
