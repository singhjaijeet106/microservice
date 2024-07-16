package com.example.micro.rtg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.micro.rtg.model.RatingResponse;
import com.example.micro.rtg.service.RatingService;


@RestController
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PostMapping("/rating")
	public ResponseEntity<RatingResponse> createRatingResponse(@RequestBody RatingResponse rating){
		RatingResponse response = ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/rating/user/{userId}")
	public ResponseEntity<List<RatingResponse>> getRatingResponseByUserId(@PathVariable String userId){
		List<RatingResponse> response = ratingService.getAllRatingsByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/rating/hotel/{hotelId}")
	public ResponseEntity<List<RatingResponse>> getRatingResponseByHotelId(@PathVariable String hotelId){
		List<RatingResponse> response = ratingService.getAllRatingsByHotelId(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/rating/all")
	public ResponseEntity<List<RatingResponse>> getAllRatingResponse(){
		List<RatingResponse> response = ratingService.getAllRatings();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
