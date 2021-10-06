package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entities.UserEntities;

@Component
public interface UserRepository {

	public List<UserEntities> getUserProfile();

}