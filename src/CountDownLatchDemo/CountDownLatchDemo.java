package CountDownLatchDemo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int size = 3;
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 1; i <= size; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    System.out.println(System.currentTimeMillis());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(100);
        countDownLatch.countDown();
    }
}
