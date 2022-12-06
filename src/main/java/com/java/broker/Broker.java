/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.broker;

/**
 *
 * @author rajmehta
 */
public class Broker {
    int brokerid;
    String name;
    String region;
    double commission;
    double commissionrate;
    String password;

    public Broker(String name, String region, double commission, double commissionrate, String password) {
        this.name = name;
        this.region = region;
        this.commission = commission;
        this.commissionrate = commissionrate;
        this.password = password;
    }
    
    public Broker(){}

    public int getBrokerid() {
        return brokerid;
    }

    public void setBrokerid(int brokerid) {
        this.brokerid = brokerid;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getCommissionrate() {
        return commissionrate;
    }

    public void setCommissionrate(double commissionrate) {
        this.commissionrate = commissionrate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
