package CountDownLatchDemo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    private final static int size = 3;

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for(int i=1;i<=3;i++){
            new Thread(()->{
                try{
                    countDownLatch.await();
                    System.out.println(System.currentTimeMillis());

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(100);
        countDownLatch.countDown();
    }
}
