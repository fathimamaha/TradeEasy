package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AvailableEntities;
import com.example.demo.entities.TradingEntities;
import com.example.demo.entities.UserEntities;
import com.example.demo.service.AvailableService;
import com.example.demo.service.OrderService;
import com.example.demo.service.TradingService;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/trading")
public class TradingController {

	@Autowired
	TradingService service;

	@Autowired
	UserService userservice;

	@Autowired
	OrderService orderservice;

	@Autowired
	AvailableService availableservice;

	@GetMapping(value = "/History")
	public List<TradingEntities> getAllTraders() {
		return service.getAllTrades();
	}

	@GetMapping(value = "/User")
	public List<UserEntities> getUserProfile() {
		return userservice.getUserProfile();
	}

	@GetMapping(value = "/Available")
	public List<AvailableEntities> availableStocks() {
		return availableservice.availableStocks();
	}

	@CrossOrigin("*")
	@PostMapping(value = "/Order")
	public String orderStock(TradingEntities entities) {
//		int order_id = entities.getId();
		String stockTicker = entities.getStockTicker();
		double price = entities.getPrice();
		int volume = entities.getVolume();
		String buyOrSell = entities.getBuyOrSell();
		int statusCode = entities.getStatusCode();
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Timestamp Date_Time = entities.getDate_Time();
//		String stockTicker = "A";
//		double price = 80.00;
//		int volume = 2;
//		String buyOrSell = "buy";
		//System.out.println(stockTicker + price + volume + buyOrSell + statusCode + Date_Time);
		return orderservice.orderStock(stockTicker, price, volume, buyOrSell, statusCode, Date_Time);
	}

}