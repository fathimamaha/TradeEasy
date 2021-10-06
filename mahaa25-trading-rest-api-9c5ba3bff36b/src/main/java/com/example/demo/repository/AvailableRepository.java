package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entities.AvailableEntities;

@Component
public interface AvailableRepository {
	public List<AvailableEntities> availableStocks();
}
