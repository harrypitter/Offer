package partOne;

public class SingletonFinal {
    // volatile 防止指令重排
    private static volatile SingletonFinal singletonFinal;
    private SingletonFinal() {}
    public static SingletonFinal getInstance(){
        if(singletonFinal == null) {
            // 现在加锁
            synchronized (SingletonFinal.class){
                // 第二层判断
                // 如果A,B两个线程都在synchronized 等待，A创建完对象之后，B还会再进入，如果不再检查一遍，B又会创建一个对象
                if(singletonFinal == null) {
                    singletonFinal = new SingletonFinal();
                }
            }
        }
        return singletonFinal;
    }
}
