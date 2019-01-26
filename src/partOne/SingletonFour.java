package partOne;

public class SingletonFour {
    private static SingletonFour singletonFour = null;
    private SingletonFour(){}
    public static SingletonFour getInstance(){
        if(singletonFour == null){
            synchronized (SingletonFour.class){
                if(singletonFour == null){
                    singletonFour = new SingletonFour();
                }
            }
        }
        return singletonFour;
    }
}
