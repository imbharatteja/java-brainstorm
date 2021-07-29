package com.imbharatteja.collectionDemo.concurrentMap;

import java.util.Map;


public class MapHelper1 implements Runnable{
    Map<Integer, String> map;

    public MapHelper1(Map<Integer, String> map) {
        this.map = map;
        new Thread(this, "MapHelper1").start();
    }

    @Override
    public void run() {
        map.put(1, "One");
        try {
            System.out.println("MapHelper 1 Sleeping for 100ms");
            Thread.sleep(100);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
