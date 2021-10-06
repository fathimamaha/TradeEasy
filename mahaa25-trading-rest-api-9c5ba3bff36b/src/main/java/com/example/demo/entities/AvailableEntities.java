package com.example.demo.entities;

public class AvailableEntities {
	private String stockTicker;
	private double price;

	public AvailableEntities() {
	}

	public AvailableEntities(String stockTicker, double price) {
		super();
		this.stockTicker = stockTicker;
		this.price = price;
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
}
