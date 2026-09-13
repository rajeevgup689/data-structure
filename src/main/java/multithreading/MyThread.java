package multithreading;

public class MyThread extends Thread {

    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }
    static void main() {
        MyThread thread1 = new MyThread(); // No, the Thread class is not abstract in Java. It is a concrete class located in the java.lang package. Thread implements the Runnable interface.
        //  When you create a thread by extending the Thread class directly, you usually override its run() method to give the thread a task. However, doing this is optional because the Thread class already provides a default, concrete implementation of the run()
        thread1.start(); // starts a new thread
    }
}
