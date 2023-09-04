package partOne;

public class MultiThreadsRunnable implements Runnable {
    int num;

    public MultiThreadsRunnable(int num) {
        this.num = num;
        System.out.println("thread index is " + num);
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Thread " + num + " running time" + i);
        }
        System.out.println("Thread " + num + "finished!");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MultiThreadsRunnable(1));

        t1.setPriority(5);
        Thread t2 = new Thread(new MultiThreadsRunnable(2));
        t2.setPriority(7);
        t1.start();
        t2.start();
    }
}

