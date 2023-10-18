package org.example;

public class ThreadInterrupt {

    private static final long loop = 100000000000l;

    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationTask());
        thread.start();
        thread.interrupt();
    }

    private static class LongComputationTask implements Runnable {

        @Override
        public void run() {
            System.out.println("Running loop " + loop + " times");
            iterate(loop);
        }

        private static void iterate(long n) {
            long sum = 0;
            System.out.println("Starting loop");
            for (long i = 0; i < n; i++) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("Permanently interrupted computations");
                    return;
                }
                sum += 1;
            }
        }
    }

}
