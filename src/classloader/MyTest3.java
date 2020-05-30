package classloader;

import java.util.UUID;

/**
 * @ClassName MyTest3
 * @Description 若一个常量的值在编译期间不可以确定，那么其值就不会被放到调用类的常量池中，
 * 这时在程序运行时，会主动使用这个常量所在的类，导致该类被初始化
 * @Author tan
 * @Date 2020/5/4 16:35
 * @Version 1.0
 **/
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3 {
    public static final String str = UUID.randomUUID().toString();
    static {
        System.out.println("MyParent3 static code");
    }
}
