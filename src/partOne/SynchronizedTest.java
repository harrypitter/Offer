package partOne;

public class SynchronizedTest {

    public static synchronized void testOne() {
        System.out.println("Thread One start");
        try {
            System.out.println("Thread one running!");
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Thread one end");
    }

    public static synchronized void testTwo() {
        System.out.println("Thread Two start");
        try {
            System.out.println("Thread two running!");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Thread two end");
    }

    public synchronized void testThree() {
        System.out.println("Thread three start");
        try {
            synchronized (this) {
                System.out.println("Thread three running!");
                Thread.sleep(3000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Thread three end");
    }

    public void testFour() {
        System.out.println("Thread Four start");
        try {
            synchronized (this) {
                System.out.println("Thread Four running!");
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Thread Four end");
    }


    public static void main(String[] args) {
        final SynchronizedTest test = new SynchronizedTest();
        final SynchronizedTest test2 = new SynchronizedTest();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                test.testOne();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                test2.testTwo();
//            }
//        }).start();

        doThread();

    }

    private static void doThread(){
        final SynchronizedTest test = new SynchronizedTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.testThree();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.testFour();
            }
        }).start();
    }
}
