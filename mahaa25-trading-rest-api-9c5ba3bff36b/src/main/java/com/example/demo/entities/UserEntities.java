package com.example.demo.entities;

import java.sql.Timestamp;

public class UserEntities {
	private int id;
	private String stockTicker;
	private double price;
	private int volume;
	private Timestamp Date_Time;

	public UserEntities() {

	}

	public UserEntities( String stockTicker, double price, int volume, Timestamp date_Time) {
		super();
		this.id = id;
		this.stockTicker = stockTicker;
		this.price = price;
		this.volume = volume;
		Date_Time = date_Time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStockTicker() {
		return stockTicker;
	}

	public void setStockTicker(String stockTicker) {
		this.stockTicker = stockTicker;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Timestamp getDate_Time() {
		return Date_Time;
	}

	public void setDate_Time(Timestamp date_Time) {
		Date_Time = date_Time;
	}
}
