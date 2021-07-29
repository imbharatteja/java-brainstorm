package com.imbharatteja.multiThreading.executorService;

/*
    Callable Interface-
        Similar to Runnable Interface, Callable is also used to create Threads
        Runnable has only 1 abstract method - run(), which doesn't return any value
        Callable is also a Functional interface which has call method which can return value passed as a generic to callable class

        The executor service, which used callable int., uses .submit() instead of .execute() method which we use while working with Runnable interface

        We need to use Future<> class to save the value returned by submit method.
        Here, Future is a placeholder to save the value till the actual execution of the task using executor service is completed.

        Once the task is completed, we can fetch the result of the callable task using Future's get() method.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableFutureDemoClass {
    public static void main(String[] args) {

        // Create Thread pool
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future> futuresList = new ArrayList<>();

        // submit the tasks for execution 100 times
        for (int i = 0; i < 100; i++) {
            // Future saves the return of callable task, it is a place holder
            Future<Integer> future = service.submit(new TaskThread(i));
            futuresList.add(future);
        }

        for (int i = 0; i < futuresList.size(); i++) {
            Future<Integer> future = futuresList.get(i);

            try {
                // this is a blocking method. This method blocks the main() thread till it gets the value
                // While passing the timeout parameter, the get method waits for 1 sec and interrupts the execution after that
                int result = future.get(1, TimeUnit.SECONDS);
                System.out.println("Result of future#" + i + " = " + result);
            } catch (InterruptedException | TimeoutException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }


        /* CompletableFuture: to execute tasks which are dependent on sequence of the methods to be executed
        It uses ForkJoinPool service internally
        for (int i = 0; i < 100; i++) {
            CompletableFuture.supplyAsync(() -> method1())
                                .thenApply(order -> method2(order))
                                .thenApply(order -> method3(order));
        }
        */
    }
}

class TaskThread implements Callable<Integer> {
    int i;
    public TaskThread(int i) {
        this.i = i;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Thread executing: " + i + Thread.currentThread().getName());
        return new Random().nextInt();
    }
}