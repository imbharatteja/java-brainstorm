package com.imbharatteja.java8;

/*
    Until Java 1.7 - Interfaces cannot define methods, they can just declare
    In Java 8 - we can declare methods using default and static keywords

    If a class is implementing 2 interfaces, then to resolve the multiple inheritance (where 2 interfaces has same method declaration),
    the class should also define the same method, if not we will get compiler error

    If a class is implementing one interface and extending another class which has same method name with diff definition,
    then the class's definition would be taking the priority over interface - This is called Third Rule

    This implementation is highly used in Streams - where Stream method has definition in Collection interface

 */
public class EDefaultStaticMethodsDemoClass {
    public static void main(String[] args) {
        DemoInt obj = new ClassImpl();
        obj.show();
        obj.printName(); // calling method definition of interface

        System.out.println(obj.showName()); // calling method of interface & class , but class takes priority
        System.out.println(DemoInt.showStaticName()); // calling static method of Interface
    }

}

class ClassImpl extends DemoClass implements DemoInt {

    @Override
    public void show() {
        System.out.println("Show from class impl");
    }
}


interface DemoInt {

    void show();

    default String showName(){
        return "DemoInt";
    }

    default void printName(){
        System.out.println("Name is DemoInt");
    }

    static String showStaticName() {
        return "Static DemoInt";
    }
}

abstract class DemoClass {

    abstract void show();

    public String showName(){
        return "DemoClass";
    }
}
