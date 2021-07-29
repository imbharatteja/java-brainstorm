package com.imbharatteja.java8;

import java.util.*;
import java.util.stream.Collectors;
/*
    Stream -

 */

public class BObjStreamsDemoClass {
    public static void main(String[] args) {
        // Logic to get the names of highest salaried 3 employee names, who are still active
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Bharat", 20000, true));
        employeeList.add(new Employee("Teja", 30000, false));
        employeeList.add(new Employee("Bhishoyie", 10000, true));
        employeeList.add(new Employee("Bhanu", 10000, true));
        employeeList.add(new Employee("Srik", 99000, false));
        employeeList.add(new Employee("Chandu", 5000, true));
        employeeList.add(new Employee("Sai", 90000, true));

        List<Employee> copyEmp = new ArrayList<>(employeeList);
        List<String> highSalEmpNames = new ArrayList<>();

        copyEmp.sort(((o1, o2) -> o2.getSalary() - o1.getSalary()));

        int counter = 0;
        for (Employee e : copyEmp) {
            if(e.active && counter<3){
                highSalEmpNames.add(e.getEmpName());
                counter++;
            }
        }

        System.out.println(highSalEmpNames);

        /*
        ------------------------------------------------- Impl using Obj Streams
         */
        List<String> streamEmpName =
        copyEmp.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .filter(employee -> employee.active)
                .limit(3)
                .map(Employee::getEmpName)
                .collect(Collectors.toList());

        System.out.println(streamEmpName);

        Map<String , Integer> nameSal =
                copyEmp.stream()
                        .filter(e -> e.getSalary()>=10000)
                        .collect(Collectors.toMap(e -> e.empName, e -> e.getSalary()));
        System.out.println(nameSal);

        Map<Boolean, Long> activeCount =
                copyEmp.stream()
                        .collect(Collectors.groupingBy(Employee::isActive, Collectors.counting()));
        System.out.println(activeCount);

        String namesWithB =
                copyEmp.stream()
                        .map(Employee::getEmpName) // Method Reference
                        .filter(emp -> emp.startsWith("B"))
                        .collect(Collectors.joining(", "));
        System.out.println(namesWithB);


        Map<String , Integer> nameSals =
                copyEmp.stream()
                        .parallel() // To parallely evaluate the stream objects. Only advisable when the num of elements are huge, i.e. more than 10000
                        .collect(Collectors.toMap(e -> e.empName, e -> e.getSalary()));
        System.out.println(nameSals);

        /*
        ------------------------------------------------- forEach for Streams
         */


        employeeList.stream().forEach(i -> System.out.println(i.empName)); //forEach - internal loop method



    }

}

class Employee {
    String empName;
    int salary;
    boolean active = false;

    public Employee(String empName, int salary, boolean active) {
        this.empName = empName;
        this.salary = salary;
        this.active = active;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
