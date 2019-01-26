package partOne;

public class SingletonFive {

    private SingletonFive(){}
    private static class Singleton{
        private static final SingletonFive INSTANCE = new SingletonFive();
    }

    public static SingletonFive getInstance(){
        return Singleton.INSTANCE;
    }

}
