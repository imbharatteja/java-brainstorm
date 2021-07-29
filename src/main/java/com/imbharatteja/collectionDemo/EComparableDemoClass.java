package com.imbharatteja.collectionDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EComparableDemoClass {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student(1,45));
        students.add(new Student(2,75));
        students.add(new Student(3,15));
        students.add(new Student(4,95));
        students.add(new Student(5,55));

        //Collections.sort(students, ((o1, o2) -> { return o1.marks>o2.marks?1:-1;})); // comparator lambda exp

        Collections.sort(students);

        //If we can use a custom class which is always sorted, we can use comparable,
        //Else if the class is standard and we only want to compare once, we can use comparator

        for (Student stud: students) {
            System.out.println(stud);
        }
    }
}

class Student implements Comparable<Student>{

    int roll;
    int marks;

    public Student(int roll, int marks) {
        this.roll = roll;
        this.marks = marks;
    }

    @Override
    public String toString() { // inorder to print the Students objects
        return "Student{" +
                "roll=" + roll +
                ", marks=" + marks +
                '}';
    }

    @Override
    public int compareTo(Student o) { //comparable implementation
        return this.marks>o.marks?1:-1;
    }
}
