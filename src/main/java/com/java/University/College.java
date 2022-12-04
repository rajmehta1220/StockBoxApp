/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.University;

import java.util.ArrayList;

/**
 *
 * @author aakashbhatt
 */
public class College {

    String name;
    ArrayList<Department> departments;
    
    public ArrayList<Department> getDepartments() {
        return departments;
    }
    public College(String cname){
        name = cname;
        departments = new ArrayList();
    }
    
    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }
    
    public Department addDepartment(String dname){
        Department newDepartment = new Department(dname);
        this.getDepartments().add(newDepartment);
        return newDepartment;
    }
}
