package classloader;

/**
 * @ClassName MyTest2
 * @Description final常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中（本例中常量str被存入到MyTest2类的常量池中），
 * 本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化（实际上本例中MyParent2类未被加载）
 *
 * 助记符：ldc表示将int，float或String类型的常量值从常量池中推送至栈顶
 *        bipush表示将单字节（-128~127）的常量值推送至栈顶
 *        sipush表示将短整型（-32768~32767）的常量值推送至栈顶
 *        iconst_{i}表示将int类型{i}推送至栈顶（i范围：iconst_m1 - iconst_5）
 * @Author tan
 * @Date 2020/5/4 15:53
 * @Version 1.0
 **/
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.m);
    }
}

class MyParent2 {
    public static final String str = "hello world";
    public static final short s = 127;
    public static final int i = 128;
    public static final int m = 1;
    static {
        System.out.println("MyParent2 static block");
    }
}