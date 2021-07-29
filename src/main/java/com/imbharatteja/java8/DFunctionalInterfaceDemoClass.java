package com.imbharatteja.java8;

/*
    Functional Interface -
        Interfaces which represent some functionality, not just some data. Which is meaningful
        FI helps functional programming, which concentrates on Functionality rather the objects or data
        Runnable represents a functionality, hence runnable interface is a functional interface
        Ex: Runnable, Callable, Comparator

        Functional interfaces have a single abstract method.

        They enable Lambdas in Java 8. Lambdas are short hand implementations of Functional Interfaces

        In addition to existing FIs., Java 8 introduced 4 new Functional interfaces
            - Predicate : users.removeIf(user -> !user.isActive()) |||| test(T t) returns boolean : accepts a type and returns boolean
                A collection(users) taking a FI (predicate)
            - Supplier  : users.stream().generate(() -> return generateRandomNum()) |||| T get() : accepts nothing and returns a type
            - Consumer  : users.stream().forEach(user -> calculate(user)) |||| accept(T t) returns nothing : accepts a single input argument and returns no result.
            - Function  : users.stream().map(user -> return getTax(user)) |||| apply(T t) returns R : accepts one argument and produces a result

            These functional interfaces are extensively used in Streams and collections

        https://www.youtube.com/watch?v=lX0PzE0Dho0&list=PLhfHPmPYPPRmwlUqOv4eDhMOF6IUXCWDJ&index=3
 */



public class DFunctionalInterfaceDemoClass {

}
