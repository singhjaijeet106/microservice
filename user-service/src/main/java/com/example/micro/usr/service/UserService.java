package com.example.micro.usr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.micro.usr.client.HotelServiceClient;
import com.example.micro.usr.client.RatingServiceClient;
import com.example.micro.usr.dao.entity.User;
import com.example.micro.usr.dao.repo.UserRepository;
import com.example.micro.usr.exception.ResourceNotFoundException;
import com.example.micro.usr.model.HotelResponse;
import com.example.micro.usr.model.RatingResponse;
import com.example.micro.usr.model.UserResponse;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RatingServiceClient ratingServiceClient;
	
	@Autowired
	private HotelServiceClient hotelServiceClient;

	public UserResponse saveUser(UserResponse user) {
		
		String userId= UUID.randomUUID().toString();
		User userdetail = modelMapper.map(user, User.class);
		userdetail.setId(userId);
		userdetail = userRepository.save(userdetail);
		user.setId(userdetail.getId());
		return user;
	}

	public List<UserResponse> getAllUsers() {
		List<UserResponse> userRespoList = new ArrayList<>();
		List<User> userList = userRepository.findAll();
		userRespoList = userList.stream().map(user->{
			UserResponse resp = modelMapper.map(user, UserResponse.class);
			List<RatingResponse> userRatings = ratingServiceClient.getRatingResponseByUserId(user.getId()).getBody();
			resp.setRatings(userRatings);
			return resp;	
		}).collect(Collectors.toList());
		return userRespoList;
	}

	public UserResponse getUserResponseByUserId(String id) {
		User user = userRepository.findById(id).orElseThrow( ()->new ResourceNotFoundException("user with given id is not found on server"+id) );
		UserResponse response = modelMapper.map(user, UserResponse.class);
		List<RatingResponse> userRatings = ratingServiceClient.getRatingResponseByUserId(response.getId()).getBody();
		response.setRatings(userRatings);		
		userRatings = userRatings.stream().map(rating -> {
			HotelResponse hotelResponse = hotelServiceClient.getHotelResponse(rating.getHotelId()).getBody();
			rating.setHotel(hotelResponse);
			return rating;
		}).collect(Collectors.toList());
		return response;
	}
}
