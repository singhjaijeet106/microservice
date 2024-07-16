package com.example.micro.usr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.micro.usr.model.UserResponse;
import com.example.micro.usr.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<UserResponse> createUserResponse(@RequestBody UserResponse user){
		UserResponse response = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserResponse> getUserResponse(@PathVariable String id){
		UserResponse response = userService.getUserResponseByUserId(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/users/all")
	public ResponseEntity<List<UserResponse>> getAllUserResponse(){
		List<UserResponse> response = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
}
