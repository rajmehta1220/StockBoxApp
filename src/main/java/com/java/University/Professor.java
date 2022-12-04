/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.University;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aakashbhatt
 */
public class Professor {
    int p_id;
    String p_name;

    public Professor() {
    }
    
    
    public Professor(int id, String name){
        this.p_id = id;
        this.p_name = name;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }
    
    
    
}
