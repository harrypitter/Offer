package CountDownLatchDemo;

import java.util.concurrent.Semaphore;

// 三个线程交叉执行 使用Semaphore实现
public class SemaphoreDemo {
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {

                for (int i = 0; i < 10; i++) {
                    semaphoreA.acquire();
                    System.out.println("a" + i);
                    semaphoreB.release();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            try {

                for (int i = 0; i < 10; i++) {
                    semaphoreB.acquire();
                    System.out.println("b" + i);
                    semaphoreC.release();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            try {

                for (int i = 0; i < 10; i++) {
                    semaphoreC.acquire();
                    System.out.println("c" + i);
                    semaphoreA.release();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
