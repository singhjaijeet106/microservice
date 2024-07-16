package com.example.micro.usr.model;

public class RatingResponse {

	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	private HotelResponse hotel;
	
	
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	public HotelResponse getHotel() {
		return hotel;
	}
	public void setHotel(HotelResponse hotel) {
		this.hotel = hotel;
	}
	
	public RatingResponse(String ratingId, String userId, String hotelId, int rating, String feedback,
			HotelResponse hotel) {
		super();
		this.ratingId = ratingId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.feedback = feedback;
		this.hotel = hotel;
	}
	public RatingResponse() {
		super();
	}
	
	
}
