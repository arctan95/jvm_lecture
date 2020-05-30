package classloader;

/**
 * @ClassName MyTest13
 * @Description 启动类加载器-扩展类加载器-系统类加载器-自定义类加载器
 * @Author tan
 * @Date 2020/5/14 17:02
 * @Version 1.0
 **/
public class MyTest13 {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (null != classLoader) {
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}

