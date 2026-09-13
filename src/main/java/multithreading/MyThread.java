package multithreading;

public class MyThread extends Thread {

    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }
    static void main() {
        MyThread thread1 = new MyThread();
        thread1.start(); // starts a new thread
    }
}
