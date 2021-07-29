package com.imbharatteja.collectionDemo;

import java.util.Collections;
import java.util.TreeMap;

/*
    TreeMap implements SortedMap
    SortedMap extends Map
    So while initializing TreeMap, we use TreeMap itself, not Map

    TreeMap is not an HashMap, hence it does not follow hashing concept.
    It's the implementation of SortedMap, which sorts the elements on the basis of Keys (By Default).
    It uses Red-Black Binary Tree to store the keys.

    https://www.youtube.com/watch?v=ecQJCRBxabY

 */


public class ITreeMapDemoClass {
    public static void main(String[] args) {
        TreeMap<Integer, String> values = new TreeMap<>();

        values.put(1000, "Bharat");
        values.put(5000, "Teja");
        values.put(3000, "Kiyan");
        values.put(10000, "Hanvi");
        values.put(7000, "Sundu");

        values.forEach((k,v) -> System.out.println("Key: " + k + " value: " + v));

        values.remove(5000);

        values.forEach((k,v) -> System.out.println("Key: " + k + " value: " + v));

        values.put(6000, "Bhargav");

        values.forEach((k,v) -> System.out.println("Key: " + k + " value: " + v));

        System.out.println(values.lastKey());
        System.out.println(values.firstEntry());

        System.out.println(values.headMap(4000));
        System.out.println(values.tailMap(4000));


        TreeMap<Integer, String> reverse = new TreeMap<>(Collections.reverseOrder());

        reverse.put(20, "Hi");
        reverse.put(80, "hello");
        reverse.put(30, "namaste");
        reverse.put(15, "namaskaram");
        reverse.put(70, "bonjour");

        reverse.forEach((k,v) -> System.out.println("Key: " + k + " value: " + v));


    }
}
