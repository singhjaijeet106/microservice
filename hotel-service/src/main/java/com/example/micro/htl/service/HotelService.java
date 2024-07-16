package com.example.micro.htl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.micro.htl.dao.entity.Hotel;
import com.example.micro.htl.dao.repo.HotelRepository;
import com.example.micro.htl.model.HotelResponse;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public HotelResponse createHotelResponse(HotelResponse hotelResponse) {
		String hotelId = UUID.randomUUID().toString();
		Hotel hotel = modelMapper.map(hotelResponse, Hotel.class);
		hotel.setId(hotelId);
		hotel = hotelRepository.save(hotel);
		hotelResponse.setId(hotel.getId());
		return hotelResponse;
	}
	
	public HotelResponse getHotelResponseById(String id) {
		Hotel hotel = hotelRepository.findById(id).get();
		HotelResponse hotelResponse  = modelMapper.map(hotel, HotelResponse.class);
		return hotelResponse;
	}
	
	public List<HotelResponse> getAllHotelResponses() {
		List<HotelResponse> hotelRespList = null;
		List<Hotel> hotelList = hotelRepository.findAll();
		if(hotelList!=null && !hotelList.isEmpty()) {
			hotelRespList = new ArrayList<>();
			for (Hotel hotel : hotelList) {
				HotelResponse resp = modelMapper.map(hotel, HotelResponse.class);
				hotelRespList.add(resp);
			}
		}
		return hotelRespList;
	}
}
