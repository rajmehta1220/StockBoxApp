/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.news;

/**
 *
 * @author rajmehta
 */
public class News {
    public String newCompanyIPONews(String companyname, double revenue, String region, String type, double listingprice,int qty){
        String newCompanyNews = region+" "+type+ " company, "+companyname+" with revenue "+revenue+ " has requested for IPO with quantity "+qty+" and initial release price for "+listingprice;
        return newCompanyNews;
    }
    
    public String approvedCompanyIPONews(String companyname, double revenue, String region, double listingprice,int qty){
        String approveIPOCompany = region+"   company, "+companyname+" with revenue "+revenue+ " is approved for IPO with quantity "+qty+" and initial release price for "+listingprice;
        return approveIPOCompany;
    }
}
