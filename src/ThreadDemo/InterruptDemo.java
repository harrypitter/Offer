package ThreadDemo;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {
    static private int i;

    public static void main(String[] args) throws InterruptedException {
        i = 0;

        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println(i);
        });

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Current Thread 1 is :"+Thread.currentThread().isInterrupted());
        thread.interrupt();
        System.out.println("Current Thread 2 is :"+thread.isInterrupted());
        Thread.interrupted();
        System.out.println("Current Thread 3 is :"+thread.isInterrupted());
        thread.interrupt();

    }
}
