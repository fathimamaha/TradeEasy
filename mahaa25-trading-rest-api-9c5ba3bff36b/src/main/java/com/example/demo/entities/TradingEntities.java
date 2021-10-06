package com.example.demo.entities;

import java.sql.Timestamp;

public class TradingEntities {

	//private int id;
	private String stockTicker;
	private double price;
	private int volume;
	private String buyOrSell;
	private int statusCode;
	private Timestamp Date_Time;

	public TradingEntities() {

	}

	public TradingEntities(String stockTicker, double price, int volume, String buyOrSell, int statusCode,
			Timestamp date_Time) {
		super();
		//this.id = id;
		this.stockTicker = stockTicker;
		this.price = price;
		this.volume = volume;
		this.buyOrSell = buyOrSell;
		this.statusCode = statusCode;
		this.Date_Time = date_Time;

	}
	/*
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	*/
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

	public String getBuyOrSell() {
		return buyOrSell;
	}

	public void setBuyOrSell(String buyOrSell) {
		this.buyOrSell = buyOrSell;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Timestamp getDate_Time() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Timestamp Date_Time = timestamp;
		return Date_Time;
	}

	public void setDate_Time(Timestamp date_Time) {
		Date_Time = date_Time;
	}

}
