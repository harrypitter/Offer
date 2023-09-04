package ThreadDemo;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class AtomicDemo {
    private  static boolean isStop = false;


    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            int i = 0;
            while (!isStop) {
                i++;
            }
            System.out.println(i);
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        isStop = true;


        LinkedList<String> a = new LinkedList();

        a.add("a");
        a.add("b");

    }
}
