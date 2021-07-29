package com.imbharatteja.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
    Stream -
        A sequence of elements supporting sequential and parallel aggregate operations
        A stream is like a river, if we use the value once we cannot get it back again - unlike a collection where we can use the values again and again

    IntStream is a primitive steam of primitive data type: Int
 */

public class AIntStreamsDemoClass {
    public static void main(String[] args) {

        int[] numbers = {10,22,3,3,54,36,10,99,0,75};

        // To get the sum of 3 smallest unique numbers

        Set<Integer> uniqSet = new TreeSet<>();

        for (Integer i: numbers) {
            uniqSet.add(i);
        }

        System.out.println(uniqSet);
        int count = 0;
        int counter = 0;
        for (Integer i: uniqSet) {
            if(counter < 3)
                count = count + i;
            else
                break;
            counter++;
        }

        System.out.println(count);

        /*
        -------------------------------------------------
         */

        // Instead of all above code, we can simply make use of Streams and achieve the output

        // We have 3 distinct parts of Stream: Create, Process, Consume

        IntStream.of(numbers)       //--> Creating a Stream
                    .distinct()     //
                    .sorted()       //--> Process
                    .limit(3)       //
                    .forEach(System.out::println); //--> Consume

        System.out.println( "Streams Count: " +
                IntStream.of(numbers)
                .distinct()
                .sorted()
                .limit(3)
                .sum())
                ;

        Stream<int[]> stream1 = Arrays.asList(numbers).stream();
        stream1.forEach(ints -> System.out.println(ints)); // will give output

        // If we want to print again, as the stream is already used, we will get exception - uncomment the below line to test
        // stream1.forEach(ints -> System.out.println(ints));

        /*
        Examples of creating Streams for Primitive Type: Int
            IntStream.of(numbers);
            IntStream.range(1, 100);
            IntStream.generate(supplier());

        Examples of Processing the streams
            IntStream.of(numbers).distinct();
            IntStream.of(numbers).sum();
            IntStream.range(1, 100).filter(n -> n%2==0);
            IntStream.range(1, 100).map(n -> n*2);
            IntStream.range(1, 100).boxed(); //convert each num to Integer Object

        Examples of consuming the Streams
            IntStream.of(numbers).distinct().max();
            IntStream.of(numbers).average();
            IntStream.range(1, 100).map(n -> n*2).count();
            IntStream.range(1, 100).forEach(System.out::println);
            IntStream.range(1, 100).boxed().collect(Collectors.toList()); // As int is converted to object, we can covert that to List
         */
    }

}
