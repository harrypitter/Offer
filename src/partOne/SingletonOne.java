package partOne;

public class SingletonOne {
    private final static SingletonOne singletonOne = new SingletonOne();
    private SingletonOne(){}
    public SingletonOne getInstance(){
        return singletonOne;
    }
}
