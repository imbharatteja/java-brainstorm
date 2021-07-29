package com.imbharatteja.exceptionHandling;

import java.io.FileNotFoundException;

/*
    The exception will propagate through the call stack and will be caught or handled where a try catch block is present
    If try catch block is not available any where, the exception will be handled by the JVM's default handler

    We need to explicitly throws checked exceptions out of the method if not handled
 */
public class EExceptionPropagationDemoClass {
    public static void main(String[] args) {
        EExceptionPropagationDemoClass demo = new EExceptionPropagationDemoClass();
        demo.method1(); // Un-checked exception
        demo.checkedMethod1(); // checked exception
        System.out.println("After exception handling");
    }

    // Un Checked exception - ArithmeticException
    public void method1(){
        System.out.println("In method1");
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Catch block... " + e.getMessage());
        }
    }

    public void method2(){
        System.out.println("In method2");
        method3();
    }

    public void method3(){
        System.out.println("In method3");
        int j = 10/0;
    }

    // Checked Exception
    public void checkedMethod1(){
        System.out.println("In checkedMethod method1");
        try {
            checkedMethod2();
        } catch (FileNotFoundException e) {
            System.out.println("Catch block... " + e.getMessage());
        }
    }

    public void checkedMethod2() throws FileNotFoundException{
        System.out.println("In checkedMethod method2");
        checkedMethod3();
    }

    public void checkedMethod3() throws FileNotFoundException{
        System.out.println("In checkedMethod method3");
        throw new FileNotFoundException("File is not available..");
    }

}
