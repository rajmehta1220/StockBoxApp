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
public class CourseDirectory {   
    double crn;
    String course_name;
    ArrayList<Professor> professor;

    public CourseDirectory(double crn, String c_name){
        professor = new ArrayList();
        this.crn = crn;
        this.course_name = c_name;

    }

    public double getCrn() {
        return crn;
    }

    public void setCrn(double crn) {
        this.crn = crn;
    }

    public ArrayList<Professor> getProfessor() {
        return professor;
    }

    public void setProfessor(ArrayList<Professor> professor) {
        this.professor = professor;
    }


    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Professor addProfessor(int id, String p_name) {
        Professor newProfessor = new Professor(id, p_name);
        professor.add(newProfessor);
        return newProfessor;
    }


}