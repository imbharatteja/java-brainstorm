package com.imbharatteja.multiThreading;

class Q{
    int num;
    boolean isValueSet = false;

    public synchronized void showNum() {
        if(!isValueSet){
            try{wait();}catch (Exception e){}
        }
        System.out.println("consumer - " + num);
        isValueSet=false;
        notify();
    }

    public synchronized void setNum(int num) {
        if(isValueSet){
            try{wait();}catch (Exception e){}
        }
        System.out.println("producer - " + num);
        this.num = num;
        isValueSet = true;
        notify();
    }

    // wait and notify are object's methods
    // wait on a thread is done using a object
}

class Producer implements Runnable{
    Q q;

    public Producer(Q q) {
        this.q = q;
        Thread t = new Thread(this,"Producer");
        t.start();
    }

    public void run(){
        int i=0;
        while(true){
            q.setNum(i++);
            try {Thread.sleep(500);} catch (Exception e){}
        }
    }
}

class Consumer implements Runnable{
    Q q;

    public Consumer(Q q) {
        this.q = q;
        Thread t = new Thread(this,"Consumer");
        t.start();
    }

    public void run(){
        while(true){
            q.showNum();
            try {Thread.sleep(5000);} catch (Exception e){}
        }
    }
}

public class CProducerConsumerDemoClass {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
