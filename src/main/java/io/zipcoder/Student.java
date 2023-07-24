package io.zipcoder;

import java.util.ArrayList;

public class Student {
    String firstName;
    String lastName;
    ArrayList<Double> examScores = new ArrayList<>();

    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>();
        for(double x : examScores){
            this.examScores.add(x);
        }
    }
    public static void main(String[] args){

    }
    public String getExamScores(){
        StringBuilder sb = new StringBuilder();
        int examNum = 1;
        for(double x : examScores){
            sb.append(String.format("", examNum, x));
            examNum++;
        }
        return sb.toString();

    }

    public void addExamScore(double examScore){
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore){
        return;
    }

    public Double getAverageExamScore(){
        return null;
    }

    public String toString(){
        return new String();
    }


    // Getter and Setters for each instance variable.
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //public ArrayList<Double> getExamScores() {
        //return examScores;
    //}

    public void setExamScores(ArrayList<Double> examScores) {
        this.examScores = examScores;
    }

    public Student() {
        this.firstName = "John";
        this.lastName = "Doe";
        Double[] testScores = {};


        }


    public void add(Student students) {
    }

    public int size() {
    }
}



