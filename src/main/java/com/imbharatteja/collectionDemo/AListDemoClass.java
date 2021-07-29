package com.imbharatteja.collectionDemo;

import java.util.*;

/*
    https://www.youtube.com/watch?v=G_F7B18aucs
 */

public class AListDemoClass {
    public static void main(String args[]) throws Exception{

        //Collection<Integer> values = new ArrayList();

        // Not Thread Safe
        //Increases capacity by 50%, So ArrayList saves the memory
        //ArrayList is faster than Vector
        //ArrayList if good for getting the elements rather than adding the elements

        List<Integer> values = new ArrayList();
        values.add(2);
        values.add(3);
        values.add(4);

        values.add(1,222);

        Collections.sort(values);
        /*Iterator itr = values.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }*/

        //enhanced for loop
        /*for (int i: values
             ) {
            System.out.println(i);
        }*/

        //Streams API
        values.forEach(System.out::println);

        // A diff way of instantiating List when we know the values
        List<Integer> ints = Arrays.asList(12, 32, 63, 41, 75);

        // Using anonymous inner class and instantiation initializers
        List<Integer> inner = new ArrayList<Integer>(){
            {
                add(200);
                add(201);
                add(202);
                add(203);
            }
        };
        for (int i: inner) {
            System.out.println((i));
        }
    }
}
