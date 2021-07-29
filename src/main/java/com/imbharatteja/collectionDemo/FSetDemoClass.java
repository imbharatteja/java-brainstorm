package com.imbharatteja.collectionDemo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FSetDemoClass {
    public static void main(String[] args) {

        Set<Integer> values = new HashSet<>();
        values.add(100);
        values.add(800);
        values.add(300);
        values.add(600);
        values.add(200);
        values.add(300);

        for (Integer i: values) {
            System.out.println(i);
            //As we are using HashSet, hashing will get the value which is near to the current memory
            //So, HashSet doesn't maintain the order in which we are inserting
        }

        Set<Integer> treeValues = new TreeSet<>();
        treeValues.add(100);
        treeValues.add(800);
        treeValues.add(300);
        treeValues.add(600);
        treeValues.add(200);
        treeValues.add(300);

        for (Integer i: treeValues) {
            System.out.println(i);
            //Treeset will save the data in sorted order
        }
    }
}
