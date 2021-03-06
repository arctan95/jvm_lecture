package memory;

/**
 * @ClassName MyTest3
 * @Description 死锁
 * @Author tan
 * @Date 2020/7/15 21:08
 * @Version 1.0
 **/
public class MyTest3 {
    public static void main(String[] args) {
        new Thread(() -> A.method(), "Thread-A").start();
        new Thread(() -> B.method(), "Thread-B").start();
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class A {
    public static synchronized void method() {
        System.out.println("method form A");
        try {
            Thread.sleep(5000);
            B.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class B {
    public static synchronized void method() {
        System.out.println("method form B");
        try {
            Thread.sleep(5000);
            A.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}