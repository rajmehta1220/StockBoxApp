package com.java.stockbox.api;

import java.math.BigDecimal;

public class StockDto {
	private String name;
	private BigDecimal price;
	private BigDecimal change;
	private String currency;
	private BigDecimal bid;
	private BigDecimal dayHigh;
	private BigDecimal dayLow;
	
	
	public StockDto(String name, BigDecimal price, BigDecimal change, String currency, BigDecimal bid, BigDecimal dayHigh, BigDecimal dayLow) {
		super();
		this.name = name;
		this.price = price;
		this.change = change;
		this.currency = currency;
		this.bid = bid;
		this.dayHigh = dayHigh;
		this.dayLow = dayLow;
	}


	public StockDto() {
		super();
	}

	

	public BigDecimal getDayHigh() {
		return dayHigh;
	}


	public void setDayHigh(BigDecimal dayHigh) {
		this.dayHigh = dayHigh;
	}


	public BigDecimal getDayLow() {
		return dayLow;
	}


	public void setDayLow(BigDecimal dayLow) {
		this.dayLow = dayLow;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public BigDecimal getChange() {
		return change;
	}


	public void setChange(BigDecimal change) {
		this.change = change;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public BigDecimal getBid() {
		return bid;
	}


	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}


	@Override
	public String toString() {
		return "StockDto [name=" + name + ", price=" + price + ", change=" + change + ", currency=" + currency
				+ ", bid=" + bid + "]";
	}
	
	

}
