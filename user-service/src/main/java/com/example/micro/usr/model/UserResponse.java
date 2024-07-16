package com.example.micro.usr.model;

import java.util.ArrayList;
import java.util.List;

public class UserResponse {
	
	private String id;	
	private String name;
	private String email;
	private String about;
	private List<RatingResponse> ratings = new ArrayList<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public List<RatingResponse> getRatings() {
		return ratings;
	}
	public void setRatings(List<RatingResponse> ratings) {
		this.ratings = ratings;
	}
	
}
