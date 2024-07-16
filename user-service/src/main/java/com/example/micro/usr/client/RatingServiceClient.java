package com.example.micro.usr.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.micro.usr.model.RatingResponse;



@FeignClient(name = "RATING-SERVICE", path = "/rating-app/api/")
public interface RatingServiceClient {
	@PostMapping("/rating")
	public ResponseEntity<RatingResponse> createRatingResponse(@RequestBody RatingResponse rating);

	@GetMapping("/rating/user/{userId}")
	public ResponseEntity<List<RatingResponse>> getRatingResponseByUserId(@PathVariable String userId);
	
	@GetMapping("/rating/hotel/{hotelId}")
	public ResponseEntity<List<RatingResponse>> getRatingResponseByHotelId(@PathVariable String hotelId);
	
	@GetMapping("/rating/all")
	public ResponseEntity<List<RatingResponse>> getAllRatingResponse();
}
