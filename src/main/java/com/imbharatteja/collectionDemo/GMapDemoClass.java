package com.imbharatteja.collectionDemo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class GMapDemoClass {
    public static void main(String[] args) {

        Map<Integer, String> values = new HashMap<>();

        values.put(1, "Bharat");
        values.put(2, "Teja");
        values.put(3, "hanvi");
        values.put(4, "Kiyan");
        values.put(5, "Sundu");
        values.put(5, "Sundari");

        System.out.println(values); // As we are using HashMap, the order is not saved as it uses hashing, fast, one null key allowed
        //to have the order preserved, we have linkedhashmap
        //treemap preserves in the sorted order

        Set<Integer> keys = values.keySet();
        for (Integer key: keys){
            System.out.println(key +" : " + values.get(key));
        }

        Map<Integer, String> tabValues = new Hashtable<>();

        tabValues.put(1, "Bharat");
        tabValues.put(2, "Teja");
        tabValues.put(3, "hanvi");
        tabValues.put(4, "Kiyan");
        tabValues.put(5, "Sundu");
        tabValues.put(5, "Sundari");

        System.out.println(tabValues); // Hashtable is synchronized, slow, doesnot allow null key

        Set<Integer> tkeys = values.keySet();
        for (Integer key: tkeys){
            System.out.println(key +" : " + values.get(key));
        }
    }
}
