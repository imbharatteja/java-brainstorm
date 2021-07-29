package com.imbharatteja.collectionDemo;

import java.util.Collections;
import java.util.Vector;

public class BVectorDemoClass {
    public static void main(String args[]) throws Exception{

        //Collection<Integer> values = new ArrayList();

        //Thread Safe
        //Increases capacity by 100%, where as ArrayList increases by 50%. So ArrayList saves the memory
        //ArrayList is faster than Vector

        Vector<Integer> values = new Vector<>();
        values.add(2);
        values.add(3);
        values.add(4);

        values.add(1,222);

        values.remove(2);
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

        System.out.println(values.size());
        System.out.println(values.capacity());
    }
}
