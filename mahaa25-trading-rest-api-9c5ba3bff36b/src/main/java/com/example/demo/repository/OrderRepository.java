package com.example.demo.repository;

import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

@Component
public interface OrderRepository {
	public void setDataSource(DataSource ds);

	public String orderStock(String stockTicker, Double price, int volume, String buyOrSell,
			int statusCode, Timestamp Date_Time);

	public String BuyStock(int volume, String stockTicker);
	
}
