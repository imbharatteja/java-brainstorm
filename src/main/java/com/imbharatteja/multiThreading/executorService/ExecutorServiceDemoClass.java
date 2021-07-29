package com.imbharatteja.multiThreading.executorService;

/*
    The Java ExecutorService is a construct that allows you to pass a task to be executed by a thread asynchronously.
    The executor service creates and maintains a reusable pool of threads for executing submitted tasks.
    The service also manages a queue, which is used when there are
    more tasks than the number of threads in the pool and there is a need to queue up tasks until there is a
    free thread available to execute the task.

    Thread pool uses blocking queue which is thread safe to perform concurrent operations

    The ideal pool size depends on the tasks we want to execute

    - If the task is CPU Intensive (Internal to a single OS, no external calls)
    Let us take if we have 4 core CPU, it is suggestible to have 4 threads in the ThreadPool.
    So, the tasks we want to perform, will be inserted in the blocking queue and executed by these 4 threads concurrently

    - If the task is IO extensive (Any external DB calls, or API calls getting data)
    If few threads are waiting for the response from IO operations, then it is suggestible to have more threads to
    act on the remaining tasks and make them ready for the execution.
    Here it depends on the rate of task submission and task time. It will increase the memory consumption though

    https://www.youtube.com/watch?v=sIkG0X4fqs4&list=PLhfHPmPYPPRl0LntrCBnQD5ln6lnqqoms&index=2
 */

import java.util.concurrent.*;

public class ExecutorServiceDemoClass {
    public static void main(String[] args) {

        // Creating ThreadPool with 10 threads
        // If the Task is IO related task, better to have higher number of threads
        // ExecutorService service = Executors.newFixedThreadPool(10);

        // Creating ThreadPool of size equal to core size of the cpu
        int coreSize = Runtime.getRuntime().availableProcessors();
        System.out.println("Core Size:" + coreSize);

        // Fixed Thread Pool - The num of threads is fixed and the tasks are inserted to a blocking queue
        // Uses Blocking Queue
        // All threads are executed simultaneously
        ExecutorService service = Executors.newFixedThreadPool(coreSize);

        // Single Thread Pool - Only 1 thread is created. All tasks are executed sequentially using a single thread, one after another
        // Uses Blocking Queue
        ExecutorService singleThreadExecutorService = Executors.newSingleThreadExecutor();

        // Cached Thread Pool - Creates dynamic threads based on the execution. Destroys threads after they are idle for 60 secs
        // Uses Synchronous queue. The num of threads are not mentioned as they are created dynamically and destroyed later
        // These are used for short lived threads
        ExecutorService cachedExecutorService = Executors.newCachedThreadPool();


        // ScheduledThreadPool - for scheduling of tasks. This is a diff class all together, execution is also diff
        // Uses Delayed Queue
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        //Task to run after 10 secs delay. This is one time execution
        scheduledExecutorService.schedule(new ThreadClassTask(1), 10, TimeUnit.SECONDS);
        //Task to run repeatedly every 10 secs after initial 15 secs
        scheduledExecutorService.scheduleAtFixedRate(new ThreadClassTask(1), 15, 10, TimeUnit.SECONDS);
        //Task to run repeatedly 10 secs after initial 15 secs and after previous task completes
        scheduledExecutorService.scheduleWithFixedDelay(new ThreadClassTask(1), 20, 10, TimeUnit.SECONDS);


        for (int i=0; i<100; i++) {

            /* -- Normal execution of creating 100 threads and calling the task(the class) for each thread
            Thread t1 = new Thread(new ThreadClass(i));
            t1.start(); //Here we are creating 99 threads which are very heavy weight on the processor

            */

            // service.execute is same for fixed, cache, single thread executor services
            service.execute(new ThreadClassTask(i));


        }
        service.shutdown(); // initiate the shutdown after the service after the execution

        System.out.println("End of execution of threads");
    }
}

class ThreadClassTask implements Runnable{
    int i;

    public ThreadClassTask(int i){
        this.i = i;
    }

    @Override
    public void run(){
        System.out.println("Thread executing: " + i + " : " + Thread.currentThread().getName());
    }
}
