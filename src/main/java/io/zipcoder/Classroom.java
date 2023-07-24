package io.zipcoder;

import java.lang.reflect.Array;
import java.util.*;

public class Classroom {

    private Student[] students;
    private int maxNumOfStudents;

    public Classroom(int maxNumberOfStudents) {
        this.maxNumOfStudents = maxNumberOfStudents;
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] studentArray) {
        this.maxNumOfStudents = studentArray.length;
        this.students = studentArray;
    }

    public Classroom() {
        this.maxNumOfStudents = 30;
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    public double getAverageExamScore() {
        double sumOfAverages = 0.0;
        int numOfStudents = 0;

        for (Student student : students) {
            if (student != null) {
                sumOfAverages += student.getAverageExamScore();
                numOfStudents++;
            }
        }
        if (numOfStudents > 0) {
            return sumOfAverages / numOfStudents;
        } else {
            return 0.0;
        }
    }

    public void addStudent(Student students){
        if (students.size() < maxNumOfStudents) {
            students.add(students);
        } else {
            System.out.println("The classroom is already at maximum capacity.");
        }
    }

    /*public void removeStudent(String firstName, String lastName){
        int indexToRemove = -1;
        for(int i = students.size() - 1; i>=0; i--){
            Student student = students.get(i);
            if(students.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                students.remove(i);
                students.add(null);
                break;
            }
        }
        if(indexToRemove != -1){
            students.remove(indexToRemove);
            students.add(null);
        }
            return;
    }*/

    public Map<Student, String> getGradeBook() {
        Map<Student, String> gradeBook = new TreeMap<>(Comparator.comparing(Student::getAverageExamScore).reversed());

        int totalStudents = students.size();
        int upper10thPercentile = (int) Math.ceil(totalStudents * 0.10);
        int upper11thPercentile = (int) Math.ceil(totalStudents * 0.11);
        int upper29thPercentile = (int) Math.ceil(totalStudents * 0.29);
        int upper30thPercentile = (int) Math.ceil(totalStudents * 0.30);
        int upper50thPercentile = (int) Math.ceil(totalStudents * 0.50);
        int lower51stPercentile = (int) Math.ceil(totalStudents * 0.51);
        int lower89thPercentile = (int) Math.ceil(totalStudents * 0.89);
        int lower11thPercentile = totalStudents - upper10thPercentile;

        List<Student> sortedStudents = new ArrayList<>(List.of(students));
        sortedStudents.sort(Comparator.comparing(Student::getAverageExamScore).reversed());

        for (int i = 0; i < totalStudents; i++) {
            Student student = sortedStudents.get(i);

            if (i < upper10thPercentile) {
                gradeBook.put(student, "A");
            } else if (i >= upper11thPercentile && i <= upper29thPercentile) {
                gradeBook.put(student, "B");
            } else if (i >= upper30thPercentile && i <= upper50thPercentile) {
                gradeBook.put(student, "C");
            } else if (i >= lower51stPercentile && i <= lower89thPercentile) {
                gradeBook.put(student, "D");
            } else {
                gradeBook.put(student, "F");
            }
        }

        return gradeBook;
    }
}

