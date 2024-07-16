package com.example.micro.rtg.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.micro.rtg.dao.entity.Rating;
import com.example.micro.rtg.dao.repo.RatingRepository;
import com.example.micro.rtg.model.RatingResponse;

@Service
public class RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public RatingResponse createRating(RatingResponse ratingResponse) {
		Rating rating = modelMapper.map(ratingResponse, Rating.class);
		rating = ratingRepository.save(rating);
		ratingResponse.setRatingId(rating.getRatingId());
		return ratingResponse;
	}
	
	public List<RatingResponse> getAllRatings(){		
		List<RatingResponse> ratingResponseList = null;
		List<Rating> ratingList = ratingRepository.findAll();
		if(ratingList!=null && !ratingList.isEmpty()) {
			ratingResponseList = new ArrayList<>();
			for (Rating rating : ratingList) {
				RatingResponse  resp = modelMapper.map(rating, RatingResponse.class);
				ratingResponseList.add(resp);
			}
		}
		return ratingResponseList;
	}
	
	public List<RatingResponse>  getAllRatingsByUserId(String userId){
		List<RatingResponse> ratingResponseList = null;
		List<Rating> ratingList = ratingRepository.findByUserId(userId);
		if(ratingList!=null && !ratingList.isEmpty()) {
			ratingResponseList = new ArrayList<>();
			for (Rating rating : ratingList) {
				RatingResponse  resp = modelMapper.map(rating, RatingResponse.class);
				ratingResponseList.add(resp);
			}
		}		
		return ratingResponseList;
	}
	
	public List<RatingResponse>  getAllRatingsByHotelId(String hotelId){
		List<RatingResponse> ratingResponseList = null;
		List<Rating> ratingList = ratingRepository.findByHotelId(hotelId);
		if(ratingList!=null && !ratingList.isEmpty()) {
			ratingResponseList = new ArrayList<>();
			for (Rating rating : ratingList) {
				RatingResponse  resp = modelMapper.map(rating, RatingResponse.class);
				ratingResponseList.add(resp);
			}
		}		
		return ratingResponseList;
	}
}
