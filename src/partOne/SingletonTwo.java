package partOne;

public class SingletonTwo {
    private static SingletonTwo singletonTwo;
    static {
        singletonTwo = new SingletonTwo();
    }
    private SingletonTwo(){}
    public SingletonTwo getInstance(){
        return singletonTwo;
    }
}
