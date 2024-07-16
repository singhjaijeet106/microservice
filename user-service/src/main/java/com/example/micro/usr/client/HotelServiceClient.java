package com.example.micro.usr.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.micro.usr.model.HotelResponse;

@FeignClient(name = "HOTEL-SERVICE", path = "/hotel-app/api/")
public interface HotelServiceClient {

	@PostMapping("/hotel")
	public ResponseEntity<HotelResponse> createHotelResponse(@RequestBody HotelResponse hotel);

	@GetMapping("/hotel/{id}")
	public ResponseEntity<HotelResponse> getHotelResponse(@PathVariable String id);

	@GetMapping("/hotels/all")
	public ResponseEntity<List<HotelResponse>> getAllHotelResponse();

}
