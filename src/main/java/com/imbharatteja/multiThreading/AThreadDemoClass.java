package com.imbharatteja.multiThreading;

public class AThreadDemoClass {
    public static void main(String[] args) throws Exception{
        /*Hi obj1 = new Hi();
        Hello obj2 = new Hello();

        obj1.start();
        //obj2.start(); -> no start in runnable
        Thread t = new Thread(obj2);
        t.start();;*/

        Hi obj1 = new Hi();
        obj1.start();;
        obj1.setName("Thread extends name");
        obj1.setPriority(1);

        /*
            Runnable r = new Runnable() {
                @Override
                public void run() {

                }
            };
         */

        //Usage of lambda expression as Runnable is a functional interface
        //Replacing the obj passed to Thread with the entire runnable class with lambda exp

        Thread t = new Thread(() -> {
            for(int i=0;i<5;i++) {
                System.out.println("Hello : "  + Thread.currentThread().getName()); // We can refer to the current Thread
                try{
                    Thread.sleep(1000);
                } catch (Exception e){

                }
            }
        }, "Runnable name"); // we can give the name to this thread while creating it itself
        t.start();

        System.out.println(obj1.getName());
        System.out.println(t.getName());

        System.out.println(obj1.getPriority()); //we set the priority as 1
        System.out.println(t.getPriority()); //By default the priority is 5

        obj1.join(); // join method is used to make sure the main thread Waits for this thread to die.
        t.join();;

        System.out.println(obj1.isAlive()); // Tests if this thread is alive.
        System.out.println(t.isAlive()); //A thread is alive if it has been started and has not yet died

        System.out.println("Bye"); //Gets executed at the end only as t.join asks main to wait till it is dead
    }
}

class Hi extends Thread{
    public void run(){
        for(int i=0;i<5;i++) {
            System.out.println("Hi");
            try{
                Thread.sleep(1000);
            } catch (Exception e){

            }
        }
    }
}

// Not required as we are using Lambda expression as this class is used only once
class Hello implements Runnable{
    public void run(){
        for(int i=0;i<5;i++) {
            System.out.println("Hello");
            try{
                Thread.sleep(1000);
            } catch (Exception e){

            }
        }
    }
}