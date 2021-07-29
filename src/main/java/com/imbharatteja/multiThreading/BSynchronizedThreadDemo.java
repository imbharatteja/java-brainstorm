package com.imbharatteja.multiThreading;

class Counter{
    int count;
    public synchronized void increment(){ //If not synchronized both threads will use the method randomly at the same time
        //If synchronized only 1 thread can execute and the other has to wait
        count++;
    }
}
public class BSynchronizedThreadDemo {
    public static void main(String[] args) throws Exception{
        Counter counter = new Counter();
        //counter.increment();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<5000;i++){
                    counter.increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<5000;i++){
                    counter.increment();
                }
            }
        });
        t2.start();
        t1.start();
        t1.join();
        t2.join();

        System.out.println("Final count: " +counter.count);
    }
}
