package com.imbharatteja.exceptionHandling;

/*
ClassNotFoundException-
    It is a checked exception, found at compile time itself
    It occurs when JVM tries to load a class which is not present in classpath/not available at all
NoClassDefFoundError-
    It is an error(linkage error)
    It occurs when the class is available in the class path during the compile time but not present at the run time
 */

public class DClsNtFoundExcepNoClsDefFoundErr {
    public static void main(String[] args) {

        try{
            Class.forName("com.imbharatteja.exceptionHandling.AExceptionDemoClass"); // If the class itself is not present
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //NoClassDefFoundError
        AExceptionDemoClass exe = new AExceptionDemoClass();
        exe.note();
        // If we delete AExceptionDemoClass.class file, we will get this error
    }
}
