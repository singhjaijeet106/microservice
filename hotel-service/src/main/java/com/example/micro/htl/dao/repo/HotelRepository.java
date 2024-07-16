package com.example.micro.htl.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.micro.htl.dao.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
