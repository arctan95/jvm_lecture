package classloader;

/**
 * @ClassName MyTest9
 * @Description TODO
 * @Author tan
 * @Date 2020/5/12 18:14
 * @Version 1.0
 **/
public class MyTest9 {

    static {
        System.out.println("MyTest9 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child.b);
    }
}

class Parent {
    static int a = 3;

    static {
        System.out.println("Parent static block");
    }
}

class Child extends Parent{
    static int b = 4;

    static {
        System.out.println("Child static block");
    }
}