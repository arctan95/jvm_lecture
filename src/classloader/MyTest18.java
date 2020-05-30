package classloader;

/**
 * @ClassName MyTest18
 * @Description 不同类加载器作用及加载范围
 * @Author tan
 * @Date 2020/5/17 21:43
 * @Version 1.0
 **/
public class MyTest18 {
    public static void main(String[] args) {
        //启动类加载器
        System.out.println(System.getProperty("sun.boot.class.path"));
        //扩展类加载器
        System.out.println(System.getProperty("java.ext.dirs"));
        //系统类加载器
        System.out.println(System.getProperty("java.class.path"));
    }
}
