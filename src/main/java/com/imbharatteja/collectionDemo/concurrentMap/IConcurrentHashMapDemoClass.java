package com.imbharatteja.collectionDemo.concurrentMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
The ConcurrentHashMap class provides a concurrent version of the standard HashMap.
Locks are applied at the segment or bucket level.
While working with threads, a thread applies lock only at the segment level (Out of 16 segments available in a hashmap)
The other segments are free for the other threads working with the same hashset

As no concurrency level has been set explictity, the ConcurrentHashMap gets divided into 16 segments.
And each segment acts as an independent HashMap.
During right operation the Lock is obtained on this particular segment and not on the entire HashMap Debug the code
when it reaches the for Loop above and check the conMap details-

We use ConcurrentHashMap when a high level of concurrency is required.
But already SynchronizedMap is present so what advantages does ConcurrentHashMap have over synchronized map.
Both are thread safe.
The major advantage is in case of synchronizedMap every write operation acquires lock on entire SynchronizedMap,
while in case of ConcurrentHashMap the lock is only on one of the segments.

 */


public class IConcurrentHashMapDemoClass {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> syncMap = Collections.synchronizedMap(hashMap);
        //Map<Integer, String> syncMap = new ConcurrentHashMap<>();

        MapHelper1 helper1 = new MapHelper1(syncMap);
        MapHelper2 helper2 = new MapHelper2(syncMap);
        MapHelper3 helper3 = new MapHelper3(syncMap);
        MapHelper4 helper4 = new MapHelper4(syncMap);

        for(Map.Entry<Integer, String> values : syncMap.entrySet()) {
            System.out.println(values.getKey() + " : " + values.getValue());
        }
    }
}
