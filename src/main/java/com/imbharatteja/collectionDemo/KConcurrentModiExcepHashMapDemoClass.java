package com.imbharatteja.collectionDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/*
    CME is a RunTime exception, Un checked exception
    concurrent modification exception when if a collection(Arraylist, hashmap, hashset etc) is modified while iterating over
    when a collection is operated using 2 threads, CME is thrown

 */

public class KConcurrentModiExcepHashMapDemoClass {
    public static void main(String[] args) {
        Map<Integer, String> values = new HashMap<>();

        values.put(1, "Bharat");
        values.put(2, "Teja");
        values.put(3, "hanvi");
        values.put(4, "Kiyan");
        values.put(5, "Sundu");
        values.put(5, "Sundari");

        System.out.println(values);
        /*Set<Integer> keys = values.keySet();
        for (Integer key: keys){

            if(key == 5) {
                values.remove(key);
            }
        }*/
        Iterator<Integer> itr = values.keySet().iterator();
        while(itr.hasNext()) {
            if(itr.next() == 1) {
                //values.put(11,"test"); // This throws cme
                //values.remove(11); // this does not throw cme
            }
        }

        System.out.println("Final values: " + values);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------");
        //----------- CME demo using 2 classes(Main and MyClass)

        Map<Integer, String> conMap = new ConcurrentHashMap<>();
        // If we use HashMap, as 2 threads are executing, the program will fail

        conMap.put(1, "Bharat");
        conMap.put(2, "Teja");
        conMap.put(3, "hanvi");
        conMap.put(4, "Kiyan");
        conMap.put(5, "Sundu");
        conMap.put(5, "Sundari");

        MyThread myThread = new MyThread(conMap); // As we are calling the constructor
        new Thread(myThread).start();

        Iterator<Integer> itr2 = conMap.keySet().iterator();
        while(itr2.hasNext()) {
            System.out.println("Main method itr: " + itr2.next());
            conMap.put(11, "main");
        }

    }
}

class MyThread implements Runnable {

    Map<Integer, String> myMap;

    public MyThread(Map<Integer, String> myMap) {
        this.myMap = myMap;
    }

    @Override
    public void run(){
        System.out.println("Running MyThread run before putting the element");
        this.myMap.put(25, "MyThread");
        System.out.println("Running MyThread run after putting the element");
    }
}
