package com.example.demo.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderrepository;

	public String orderStock(String stockTicker, Double price, int volume, String buyOrSell,
			int statusCode, Timestamp Date_Time) {
		return orderrepository.orderStock(stockTicker, price, volume, buyOrSell, statusCode, Date_Time);
	}
}
