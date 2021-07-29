package com.imbharatteja.collectionDemo;

/*
    Iterators are used to traverse through the collections
    Fail-Fast Iterators:
        Immediately throw concurrent modification exception when if a collection is modified while iterating over it
        use the original collection to traverse
        do not require extra memory as they use the original collection
        ArrayList, Vector, HashMap

    Fail-Safe Iterators:
        Do not throw concurrent modification exception when if a collection is modified while iterating over it
        use the copy of the original collection to traverse
        require extra memory as they create a copy of the original collection
        May not have the latest element while iterating
        ConcurrentHashMap, CopyOnWriteArrayList

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class JFailFastFailSafeIteratorsDemoClass {
    public static void main(String[] args) {

        List<Integer> values = new ArrayList();
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);

        Iterator<Integer> itr = values.iterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());
            //values.add(6); // gives concurrentmodificationexception
            //values.remove(2); // gives concurrentmodificationexception
            values.set(2, 22); // does not give concurrentmodificationexception, as set method does not change the structure of arraylist
            // itr.remove(); this remove method doesnot throw exception
        }

        for (Integer i: values) {
            System.out.println(i);
          //  values.add(6); // gives concurrentmodificationexception

        }

        System.out.println("---------------------------------------------");
        List<Integer> values2 = new CopyOnWriteArrayList<>();
        values2.add(2);
        values2.add(3);
        values2.add(4);
        values2.add(5);

        Iterator<Integer> itr2 = values2.iterator();

        while(itr2.hasNext()) {
            System.out.println(itr2.next());
            values2.add(6); // does not gives concurrentmodificationexception,  but the values is also not added as it creates a copy
            values2.remove(2); //  does not gives concurrentmodificationexception
            values2.set(2, 22); // does not give concurrentmodificationexception, but the values is also not added as it creates a copy
        }
    }
}
