package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entities.TradingEntities;

@Component
public interface TradingRepository {
	public List<TradingEntities> getAllTrades();

}