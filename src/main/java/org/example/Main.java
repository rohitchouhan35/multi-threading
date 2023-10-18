package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("we are in now in thread: " + Thread.currentThread().getName());
                System.out.println("current thread priority is: " + Thread.currentThread().getPriority());
//                throw new RuntimeException("Intentional error");
            }
        });

        thread.setName("new SPECIAL thread");

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread " + t.getName() + " the error is " + e.getMessage());
            }
        });

        System.out.println("before starting thread name: " + Thread.currentThread().getName());
        thread.start();
        System.out.println("after starting thread name: " + Thread.currentThread().getName());

        Thread.sleep(10000);
    }
}