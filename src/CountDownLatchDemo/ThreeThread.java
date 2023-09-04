package CountDownLatchDemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 三个线程依次执行 使用volatile
 */
public class ThreeThread {

    static volatile int i = 1;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            if (i == 1) {
                try {
                    Thread.sleep(100);
                    for (int j = 1; j <= 3; j++) {
                        System.out.println("a" + j);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end a" );
                i = 2;
            }
            return;

        });
        Thread thread2 = new Thread(() -> {
            if (i == 2) {
                try {
                    Thread.sleep(100);
                    for (int j = 1; j < 3; j++) {
                        System.out.println("b" + j);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                i = 3;
            }
            return;
        });
        Thread thread3 = new Thread(() -> {
            if (i == 3) {
                try {
                    Thread.sleep(100);
                    for (int j = 1; j < 3; j++) {
                        System.out.println("b" + j);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                i=1;
            }
            return;
        });

        thread1.start();
        thread2.start();
        thread3.start();

        singlepool();


    }

    private static void singlepool(){
        Thread threada = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int k = 1;k<=3;k++){
                    System.out.println("ka"+k);
                }
            }
        });
        Thread threadb = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int k = 1;k<=3;k++){
                    System.out.println("kb"+k);
                }
            }
        });
        Thread threadc = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int k = 1;k<=3;k++){
                    System.out.println("kc"+k);
                }
            }
        });

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(threada);
        service.submit(threadb);
        service.submit(threadc);
        service.shutdown();
    }
}
