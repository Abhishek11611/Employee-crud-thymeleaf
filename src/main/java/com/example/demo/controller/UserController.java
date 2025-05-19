package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String>registerUser(@RequestBody User user){
		String registerUser = userService.registerUser(user);
		return new ResponseEntity<>(registerUser,HttpStatus.CREATED);
	}
	
	
	 @PostMapping("/login")
	    public ResponseEntity<String> loginUser(@RequestParam String userName, @RequestParam String userPassword) {
	       String loginUser = userService.loginUser(userName,userPassword);
	        return new ResponseEntity<String>(loginUser, HttpStatus.OK);
	    }
	 


}
