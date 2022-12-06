/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.profile;

/**
 *
 * @author rajmehta
 */
public class Profile {

    int id;
    String name;
    double funds;
    String region; 
    double balance;
    String type;
    String password;
    String fundstype;

    public Profile() {
    }

    public Profile(int id, String name, double funds, String region, double balance, String type, String password, String fundstype) {
        this.id = id;
        this.name = name;
        this.funds = funds;
        this.region = region;
        this.balance = balance;
        this.type = type;
        this.password = password;
        this.fundstype = fundstype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFundstype() {
        return fundstype;
    }

    public void setFundstype(String fundstype) {
        this.fundstype = fundstype;
    }
    
    
}
