package gc;

/**
 * @ClassName MyTest2
 * @Description 打印JVM启动时的参数 java -XX:+PrintCommandLineFlags -version
 * -XX:PretenureSizeThreshold=4194304：若待创建对象超过此设置阈值（单位是字节），则该对象将不会在新生代创建，直接在老年代分配
 * 但必须配合-XX:+UseSerialGC才会生效
 * @Author tan
 * @Date 2020/9/25 20:46
 * @Version 1.0
 **/
public class MyTest2 {

    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAlloc = new byte[5 * size];
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
