package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String registerUser(User user) {
		userRepository.save(user);
		return "User Register Success!!";
	}

	@Override
	public String loginUser(String userName, String userPassword) {
		Optional<User> byUserNameandpassword = userRepository.findByUserNameAndUserPassword(userName, userPassword);
		if(byUserNameandpassword.isPresent()) {
			return "Login Success!!!";
		}
		return "Login Failed";
		
	}
	
	

}
