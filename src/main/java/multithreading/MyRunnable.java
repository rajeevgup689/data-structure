package multithreading;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable thread: " + Thread.currentThread().getName());
    }

    static void main() {
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();

        // using Lambda expression :
        Thread thread3 = new Thread(
                () -> System.out.println("Lambda Runnable: " + Thread.currentThread().getName())
        );
        thread3.start();

        /**
         * Threading: More threads won’t help much, and can actually hurt performance due to context switching.
         * Optimal Threads: Typically, 1 thread per CPU core is enough.
         * Use: Threads ≈ Number of CPU cores (Runtime.getRuntime().availableProcessors())
         * Example: For 8 cores, use 8–10 threads.
         *
         * CPU-heavy? Use fewer threads (≈ core count).
         * I/O-heavy? Use more threads to cover wait time.
         * Mixed/uncertain? Start small, monitor performance, and adjust.
         */
    }
}
