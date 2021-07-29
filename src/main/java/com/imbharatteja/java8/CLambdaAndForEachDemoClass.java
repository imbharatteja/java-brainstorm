package com.imbharatteja.java8;
/*
    Lambdas -
        Short hand representations for Special types of Anonymous Inner classes
            - Single Abstract Method
            - Single Method Interfaces
            - Functional Interfaces
        Lambda exp reduces the creation of unnecessary inner classes and memory for inner classes
        Lambda also reduces boiler plate code (unnecessary/repeated code)

 https://www.youtube.com/watch?v=yb46iD5dJYY

    ForEach -
        forEach is an internal loop for collections introduced in Java 8
        the other loop[s, like for, enhanced for and iterator are external loops
        forEach being an internal loop, this is faster and memory efficient

        forEach takes Consumer Interface as input, which has accept method and is a Functional Interface.
        Hence we can make use of lambdas in forEach loop
 */

import java.util.ArrayList;
import java.util.List;

interface A {
    void show();
}

class Abc implements A{
    @Override
    public void show() {
        System.out.println("Hello");
    }
}
public class CLambdaAndForEachDemoClass {
    public static void main(String[] args) {

        // General implementation
        A obj1 = new Abc();
        obj1.show();

        // As Abc has only one menthod and it is being used only once, we can use Anonymous inner class instead of creating Abc

        A obj2 = new A() {
            public void show() {
                System.out.println("Hello from Anonymous inner class");
            }
        };
        obj2.show();

        // We can reduce the creation of anonymous inner class by replacing with Lambda expression

        A obj3 = () -> System.out.println("Hello from Lamda exp");
        obj3.show();


        /*
        ---------------------------------------------------------- forEach - internal loop
         */

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Bharat", 20000, true));
        employeeList.add(new Employee("Teja", 30000, false));
        employeeList.add(new Employee("Bhishoyie", 10000, true));
        employeeList.add(new Employee("Bhanu", 10000, true));
        employeeList.add(new Employee("Srik", 99000, false));
        employeeList.add(new Employee("Chandu", 5000, true));
        employeeList.add(new Employee("Sai", 90000, true));

        employeeList.forEach(i -> System.out.println(i.empName)); //forEach -internal loop method
    }


}
