package com.example.micro.usr.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.micro.usr.dao.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
