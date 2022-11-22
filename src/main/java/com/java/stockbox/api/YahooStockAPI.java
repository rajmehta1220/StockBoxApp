package com.java.stockbox.api;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;

public class YahooStockAPI {

	public StockDto getStock(String stockName) throws IOException{
		StockDto dto = null;
		Stock stock = YahooFinance.get(stockName);
		dto = new StockDto(stock.getName(), stock.getQuote().getPrice(), stock.getQuote().getChange(), stock.getCurrency(), stock.getQuote().getBid(), stock.getQuote().getDayHigh(), stock.getQuote().getDayLow());
		return dto;
	}
	
	public Map<String, Stock> getStock(String[] stockNames) throws IOException{
		Map<String, Stock> stock= YahooFinance.get(stockNames);
		return stock;
	}
	
	public void getHistory(String stockName) throws IOException{
		Stock stock = YahooFinance.get(stockName);
		List<HistoricalQuote> history = stock.getHistory();
		
		for(HistoricalQuote q: history) {
			System.out.println("symbol:" +q.getSymbol());
			System.out.println("date:" +q.getDate());
			System.out.println("high:" +q.getHigh());
			System.out.println("low:" +q.getLow());
			System.out.println("close:" +q.getClose());
		} 
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		YahooStockAPI obj = new YahooStockAPI();
		String[] stockNames = {"GOOG", "INTC", "BABA", "TSLA"};
		for(String a:stockNames){
                    StockDto stock = obj.getStock(a);
                    System.out.println("Name:"+stock.getName() +"     Price:"+ stock.getPrice() +"     Change:"+ stock.getChange() +"       Currency:" +stock.getCurrency() +"        Bid:"+ stock.getBid()+"        High:"+ stock.getDayHigh()+ "           Low:"+stock.getDayLow() );
                }
		
	}

}
