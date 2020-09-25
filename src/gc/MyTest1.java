package gc;

/**
 * @ClassName MyTest1
 * @Description -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @Author tan
 * @Date 2020/9/23 11:18
 * @Version 1.0
 **/
public class MyTest1 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[3 * size];
        byte[] myAlloc4 = new byte[3 * size];

        System.out.println("hello world");
    }
}
