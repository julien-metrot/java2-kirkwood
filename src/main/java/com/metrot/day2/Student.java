package com.metrot.day2;

public class Student extends Person{
    private double gpa;

    public Student(String name, double gpa) {
        super(name);
        this.gpa = gpa;
    }
}
