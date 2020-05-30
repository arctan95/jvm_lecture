package classloader;

import java.util.Random;

/**
 * @ClassName MyTest5
 * @Description 一个父接口并不会因为它的子接口或者实现类的初始化而初始化，
 * 只有当程序首次使用特定接口的静态变量时才会导致该接口的初始化
 * @Author tan
 * @Date 2020/5/4 15:32
 * @Version 1.0
 **/
public class MyTest5 {

    public static void main(String[] args) {
        System.out.println(MyChild5.b);
        System.out.println(MyParent5_1.thread);
    }
}

interface MyGrandPa {
    public static Thread thread = new Thread() {
        {
            System.out.println("MyGrandPa invoked");
        }
    };
}

interface MyParent5 extends MyGrandPa{
    public static Thread thread = new Thread() {
        {
            System.out.println("MyParent5 invoked");
        }
    };
}

class MyChild5 implements MyParent5 {
    public static int b = 5;
}

interface MyGrandPa5_1 {
    public static Thread thread = new Thread() {
        {
            System.out.println("MyGrandPa5_1 invoked");
        }
    };
}

interface MyParent5_1 extends MyGrandPa5_1{
    public static Thread thread = new Thread() {
        {
            System.out.println("MyParent5_1 invoked");
        }
    };
}