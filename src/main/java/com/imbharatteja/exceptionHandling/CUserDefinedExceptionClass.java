package com.imbharatteja.exceptionHandling;

import java.io.IOException;

// user defined exceptions are checked exceptions
public class CUserDefinedExceptionClass {
    public static void main(String[] args) {
        int i=5;
        try{
           if(i<10) {
               // throw new IOException("Errorrrrr");
            }
            if(i<20) {
                try {
                    throw new MyException("My new exception"); // calling user defined exception
                } catch (MyException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e){
            System.out.println("Exception caught");
            e.printStackTrace();
        }
    }
}

class MyException extends Exception {
    public MyException(String msg) {
        super(msg); // should call the super class constructor
    }
}
