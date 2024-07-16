package com.example.micro.rtg.dao.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.micro.rtg.dao.entity.Rating;

public interface RatingRepository extends MongoRepository<Rating, String>{
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);
}
