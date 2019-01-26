package partOne;

public class SingletonThree {
    private static SingletonThree singletonThree = null;
    private SingletonThree(){}
    public static synchronized SingletonThree getInstance(){
        if(singletonThree==null){
            singletonThree = new SingletonThree();
        }
        return singletonThree;
    }


}
