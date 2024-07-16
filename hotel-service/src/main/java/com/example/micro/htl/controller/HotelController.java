package com.example.micro.htl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.micro.htl.model.HotelResponse;
import com.example.micro.htl.service.HotelService;

@RestController
public class HotelController {
	@Autowired
	private HotelService hotelService;

	@PostMapping("/hotel")
	public ResponseEntity<HotelResponse> createHotelResponse(@RequestBody HotelResponse hotel){
		HotelResponse response = hotelService.createHotelResponse(hotel);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/hotel/{id}")
	public ResponseEntity<HotelResponse> getHotelResponse(@PathVariable String id){
		HotelResponse response = hotelService.getHotelResponseById(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/hotels/all")
	public ResponseEntity<List<HotelResponse>> getAllHotelResponse(){
		List<HotelResponse> response = hotelService.getAllHotelResponses();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
