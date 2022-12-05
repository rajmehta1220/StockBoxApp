/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Faker;

import com.java.University.College;
import com.java.University.Department;
import com.java.University.Professor;
import com.java.University.CourseDirectory;
import com.java.neustockgenerator.NeuStocks;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;   
import java.util.Set;

/**
 *
 * @author aakashbhatt
 */
public class FakerClass {
    College college;
    Department dept;
    CourseDirectory c1;
    Professor professor;


    Random random = new Random();   

    public FakerClass() throws ClassNotFoundException {

        college = new College("COE");
        dept = college.addDepartment("IS");

        for(int i=0; i< 30; i++){
            c1 = dept.addCourseDiectory(random.nextInt(), generateNames());
            for(int j=0; j<(random.nextInt(15-2)+2);j++){
                c1.addProfessor(random.nextInt(), generateNames());
            }
        }

        for(CourseDirectory c: dept.getCoursedir()){
            System.out.println("Couse Name: "+c.getCourse_name());
            System.out.println();
            for(Professor p: c.getProfessor()){
                System.out.println("Prof Name: "+p.getP_name());
            }
            System.out.println("////////////////////////////////");
        }
        NeuStocks obj = new NeuStocks();
        obj.generateNeuStocks(dept);
    }
    // price = random.nextDouble() * noOfProfs;

    public String generateNames(){
        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

        final java.util.Random rand = new java.util.Random();

        // consider using a Map<String,Boolean> to say whether the identifier is being used or not 
        final Set<String> identifiers = new HashSet<String>();

            StringBuilder builder = new StringBuilder();
            while(builder.toString().length() == 0) {
                int length = rand.nextInt(5)+5;
                for(int i = 0; i < length; i++) {
                    builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
                }
                if(identifiers.contains(builder.toString())) {
                    builder = new StringBuilder();
                }
            }
            return builder.toString();
        }
    }
