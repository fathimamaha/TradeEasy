package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AvailableEntities;
import com.example.demo.repository.AvailableRepository;

@Service
public class AvailableService {
	@Autowired
	private AvailableRepository repository;

	public List<AvailableEntities> availableStocks() {
		return repository.availableStocks();
	}

}
