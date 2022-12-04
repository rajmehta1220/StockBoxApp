/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author aakashbhatt
 */
public class Parser {
public long convertToLong(String text) {
              
       return Long.parseLong( text );
        
    }
    
    public double convertToDouble(String text) {
              
       return Double.parseDouble( text );
        
    }
    
    public LocalDate convertToDate(String date) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        formatter = formatter.withLocale( Locale.US );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        
        LocalDate dt;
        //System.out.println(date);
        
        try{
            dt = LocalDate.parse(date, formatter);
        }catch(Exception e){
            dt = LocalDate.parse("1-Jan-1990", formatter);
        }
         
        return dt;
    }
    
    public String covertDateToString (LocalDate dob) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        String dt;
        
        try{
            dt = dob.format(formatter);
        }catch(Exception e){
            LocalDate ld = LocalDate.now();
            dt = ld.format(formatter);
        }
        return dt;
        
    }
    
    public int runValidation(String pattern,String matcher){
        
        //Used for defining the pattern
        Pattern ptn = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        
        //Used to search the pattern
        Matcher mchr = ptn.matcher(matcher);
        
        if (mchr.find()){
            return 0;
        }else return 1;

    }

    public String covertLongToString(long num) {
        
        return num+"";
        
    }
    
    public String covertDoubleToString(double num) {
        
        return num+"";
        
    }
    public boolean checkNull(String a){
         if(a == null){
             return true;
         }
         else{
             return false;
         }
     }
    public boolean isInteger(String a){
        try{
            Integer.parseInt(a);
            return true;
        }catch(Exception e){return false;}
    }
    
    public boolean isLong(String a){
        try{
            Long.parseLong(a);
            return true;
        }catch(Exception e){return false;}
    }
    
    public boolean isFloat(String a){
        try{
            Float.parseFloat(a);
            return true;
        }catch(Exception e){
            return false;
        }
    }    
}
