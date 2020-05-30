package classloader;

import java.util.Random;

/**
 * @ClassName MyTest8
 * @Description TODO
 * @Author tan
 * @Date 2020/5/12 18:01
 * @Version 1.0
 **/
public class MyTest8 {

    public static void main(String[] args) {
        System.out.println(FinalTest.s);
    }
}

class FinalTest {
    public static final int s = new Random().nextInt();
    static {
        System.out.println("FinalTest static block");
    }
}