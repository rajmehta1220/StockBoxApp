/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.University;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author aakashbhatt
 */
public class Department {
    String dname;
    ArrayList<CourseDirectory> coursedir;
    public Department(String name){
        dname = name;
        coursedir = new ArrayList();
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public ArrayList<CourseDirectory> getCoursedir() {
        return coursedir;
    }

    public void setCoursedir(ArrayList<CourseDirectory> coursedir) {
        this.coursedir = coursedir;
    }

    public CourseDirectory addCourseDiectory(double crn, String cname){
        CourseDirectory newCourse = new CourseDirectory(crn, cname);
        this.getCoursedir().add(newCourse);
        return newCourse;
    }
}
