/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Company;

/**
 *
 * @author Hp
 */
public class Company {
    
     String companyname;
     double revenue;
     String region;
     String type;
     double listingprice;
     int qty;
     String password;

    public Company(String companyname, double revenue, String region, String type, double listingprice, int qty, String password) {
        this.companyname = companyname;
        this.revenue = revenue;
        this.region = region;
        this.type = type;
        this.listingprice = listingprice;
        this.qty = qty;
        this.password = password;
    }

    public Company() 
    {
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getListingprice() {
        return listingprice;
    }

    public void setListingprice(double listingprice) {
        this.listingprice = listingprice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}