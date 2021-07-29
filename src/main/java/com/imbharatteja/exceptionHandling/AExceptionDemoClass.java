package com.imbharatteja.exceptionHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AExceptionDemoClass {
    // Throwable class [Generally all 'able' are Interfaces (Runnable, Callable etc.) But Throwable is a class]
    // Throwable is the Parent class for exceptions
    /* Throwable
        - Exception
            - Checked [IOException, SQLException, FileNotFound etc]
            - Unchecked [Runtime exception, Arithmetic Exception, Null pointer, Array Index out of bound, Concurrent Modification etc]
        - Error
     */
    // Throws will throws the exception from that class/method to the calling method.
    // Throws will suppress the error without handling it completely using Try/Catch
    // Throw explicitly want to throw an error
    public static void main(String[] args) {

        int i,j,f,k =0;
        i = 2;
        j = 0;
        int a[] = new int[4];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            // k = i/j; // Arithmetic exception

            /*for(int c =0; c<5 ; c++){
               // a[c] = c; // ArrayIndexOutOfBound
            }*/
            System.out.println("Enter a number:");
            f = Integer.parseInt(br.readLine()); // IOException
            int g = i*f;
            if (g < 10) {
                throw new ArithmeticException();
            }
            System.out.println("Output:" + g);

        } catch(ArithmeticException e) {
            //System.out.println("Divide by zero");
            System.out.println("Output less than 10: Arithmetic exception");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException ai) {
            System.out.println("Array index out of bound");
            ai.printStackTrace();
        } catch (IOException io) {
            System.out.println("IO Exception caught");
            io.printStackTrace();
        } catch (Exception e) { // Exception should be the last catch block
            System.out.println("Unknown exception");
        } finally {
            //br.close();
            System.out.println("Finally block - which gets executed irrespective of exception or not");
        }

    }

    public void note(){
        System.out.println("From AExceptionDemoClass");
    }

}
