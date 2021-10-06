package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.TradingEntities;
import com.example.demo.repository.TradingRepository;

@Service
public class TradingService {
	@Autowired
	private TradingRepository repository;

	public List<TradingEntities> getAllTrades() {
		return repository.getAllTrades();
	}

}
