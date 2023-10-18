package org.example;

public class ThreadCreation{
    public static void main(String[] args) {
        NewThread th = new NewThread();
        th.start();
    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("hello from: " + this.getName());
        }
    }

}
