package com.imbharatteja.exceptionHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BTryWithResourcesDemoClass {
    public static void main(String[] args) throws IOException {
        int f, j = 8;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter Input:");
            f = Integer.parseInt(br.readLine());
            System.out.println(j/f);
        }
        // Try with resources is introduced in Java 1.7
        // We can use Try with resources when we are working with any Input related resources like Sockets, Files, DBs
        // Catch block is not required
        // The resources created will be automatically deallocated at the end of try block - garbage collection
    }
}
