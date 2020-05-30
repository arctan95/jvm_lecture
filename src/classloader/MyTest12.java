package classloader;

/**
 * @ClassName MyTest12
 * @Description 调用ClassLoader类的loadClass方法加载一个类并不是对该类的主动使用，不会导致其初始化
 * @Author tan
 * @Date 2020/5/12 22:13
 * @Version 1.0
 **/
public class MyTest12 {

    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("classloader.CL");
        System.out.println(clazz);
        System.out.println("===================");
        // 反射会导致CL类被初始化
        clazz = Class.forName("classloader.CL");
        System.out.println(clazz);
    }
}

class CL {
    static {
        System.out.println("Class CL");
    }
}