package classloader;

/**
 * @ClassName MyTest6
 * @Description 初始化按照从上到下的顺序
 * @Author tan
 * @Date 2020/5/4 17:28
 * @Version 1.0
 **/
public class MyTest6 {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        System.out.println("counter1:" + Singleton.counter1);
        System.out.println("counter2:" + Singleton.counter2);
    }
}

class Singleton {

    public static int counter1 = 1;

    private static Singleton singleton = new Singleton();
    private Singleton() {
        counter1++;
        counter2++;
        System.out.println(counter1);
        System.out.println(counter2);
    }

    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}
