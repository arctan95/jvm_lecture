package classloader;

/**
 * @ClassName MyTest11
 * @Description 无论通过子类访问父类的静态变量还是静态方法，都只是对父类的主动使用，子类并没有初始化
 * @Author tan
 * @Date 2020/5/12 22:04
 * @Version 1.0
 **/
public class MyTest11 {

    public static void main(String[] args) {
        System.out.println(Child3.a);
        System.out.println("===================");
        Child3.doSomething();
    }
}

class Parent3 {
    static int a = 3;

    static {
        System.out.println("Parent3 static block");
    }

    static void doSomething() {
        System.out.println("so something");
    }
}


class Child3 extends Parent3 {

    static {
        System.out.println("Child3 static block");
    }

}