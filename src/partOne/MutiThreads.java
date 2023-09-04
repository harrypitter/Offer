package partOne;

public class MutiThreads extends Thread {
    private int index;

    public MutiThreads(int index) {
        this.index = index;
        System.out.println("thread index is " + index);
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Thread " + index + " running time" + i);
        }
        System.out.println("Thread " + index + "finished!");
    }

    public static void main(String[] args) {
        for (int j = 0; j < 9; j++) {
            Thread t = new MutiThreads(j + 1);
            t.start();
        }
    }
}
