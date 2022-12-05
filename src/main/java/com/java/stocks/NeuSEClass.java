/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.stocks;

/**
 *
 * @author aakashbhatt
 */
public class NeuSEClass {
    String stockname;
    String stocktag;
    String type;
    Double stockprice;
    Double changerate;
    String curency;
    Double bid;
    Double dayhigh;
    Double daylow;
    Double prevprice;
    String lastfetched;
    String date;

    public NeuSEClass() {
    }

    
    public NeuSEClass(String stockname, String stocktag, String type, Double stockprice, Double changerate, String curency, Double bid, Double dayhigh, Double daylow, Double prevprice, String lastfetched, String date) {
        this.stockname = stockname;
        this.stocktag = stocktag;
        this.type = type;
        this.stockprice = stockprice;
        this.changerate = changerate;
        this.curency = curency;
        this.bid = bid;
        this.dayhigh = dayhigh;
        this.daylow = daylow;
        this.prevprice = prevprice;
        this.lastfetched = lastfetched;
        this.date = date;
    }
    
    

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    public String getStocktag() {
        return stocktag;
    }

    public void setStocktag(String stocktag) {
        this.stocktag = stocktag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getStockprice() {
        return stockprice;
    }

    public void setStockprice(Double stockprice) {
        this.stockprice = stockprice;
    }

    public Double getChangerate() {
        return changerate;
    }

    public void setChangerate(Double changerate) {
        this.changerate = changerate;
    }

    public String getCurency() {
        return curency;
    }

    public void setCurency(String curency) {
        this.curency = curency;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getDayhigh() {
        return dayhigh;
    }

    public void setDayhigh(Double dayhigh) {
        this.dayhigh = dayhigh;
    }

    public Double getDaylow() {
        return daylow;
    }

    public void setDaylow(Double daylow) {
        this.daylow = daylow;
    }

    public Double getPrevprice() {
        return prevprice;
    }

    public void setPrevprice(Double prevprice) {
        this.prevprice = prevprice;
    }

    public String getLastfetched() {
        return lastfetched;
    }

    public void setLastfetched(String lastfetched) {
        this.lastfetched = lastfetched;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}