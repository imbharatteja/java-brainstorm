package com.imbharatteja.collectionDemo;

import java.util.*;

/*
1. for known Wrapper Classes(Integer class, Float class, Number class etc), the classes have already implemented Comparable, so you don't need to bother about it.
2. For your own Objects you need to implement Comparable to make the sort() work, which is basically mimicking the strategy for point 1.
3. If you want to change your sort logic implemented by your Comparable interface you need to use Comparator, for either known datatypes or your own classes.
4. You can make the sort() for your own classes work if you implement Comparator interface, whether you have implemented Comparable or not.
 */
public class DComparatorDemoClass {

    public static void main(String[] args) {

        //Collection<Integer> values = new ArrayList();

        // Not Thread Safe
        //Increases capacity by 50%, So ArrayList saves the memory
        //ArrayList is faster than Vector

        List<Integer> values = new ArrayList();
        values.add(289);
        values.add(912);
        values.add(856);
        values.add(751);
        values.add(457);
        values.add(103);

        //Comparator<Integer> comp = new CompInt(); - comparator class commented below

        /*Comparator<Integer> comp = new Comparator<Integer>() { //Anonymous class
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1%10>o2%10) // % is modulus which is used to get the last digit if %10 is used
                    return -1; //don't swap - reverse or descending order
                return 1;
            }
        };*/

        // lambda expression which replaces anonymous class
        Comparator<Integer> comp = (o1, o2) ->{ return o1%10>o2%10?-1:1; };

        Collections.sort(values, comp);

        //enhanced for loop
        for (int i: values) {
            System.out.println(i);
        }

        //Streams API
        //values.forEach(System.out::println);


    }
}

/*class CompInt implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1>o2)
            return -1;
        return 1;
    }
}*/
