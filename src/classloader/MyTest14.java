package classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @ClassName MyTest14
 * @Description 获得ClassLoader的途径
 * 获得当前类的ClassLoader : clazz.getClassLoader();
 * 获得当前上下文的ClassLoader : Thread.currentThread().getContextClassLoader();
 * 获得系统的ClassLoader : ClassLoader.getSystemClassLoader();
 * 获得调用者的ClassLoader : DriverManager.getCallerClassLoader();
 * @Author tan
 * @Date 2020/5/14 17:56
 * @Version 1.0
 **/
public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String resources = "classLoader/MyTest13.class";
        Enumeration<URL> urls = classLoader.getResources(resources);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }

        System.out.println("--------");
        Class<?> clazz = String.class;
        System.out.println(clazz.getClassLoader());
    }
}
