package com.imbharatteja.collectionDemo.concurrentMap;

import java.util.Map;


public class MapHelper2 implements Runnable{
    Map<Integer, String> map;

    public MapHelper2(Map<Integer, String> map) {
        this.map = map;
        new Thread(this, "MapHelper1").start();
    }

    @Override
    public void run() {
        map.put(2, "Two");
        try {
            System.out.println("MapHelper 2 Sleeping for 100ms");
            Thread.sleep(100);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
