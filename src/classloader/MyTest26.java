package classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @ClassName MyTest26
 * @Description 线程上下文类加载器的一般使用模式（获取-使用-还原）
 * 示例：
 *     ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
 *     try {
 *         Thread.currentThread().setContextClassLoader(targetThreadContextClassLoader);
 *         myMethod();
 *     } finally {
 *         Thread.currentThread().setContextClassLoader(classLoader);
 *     }
 *
 *     myMethod()里面调用了Thread.currentThread().getContextClassLoader()获取当前线程的上下文类加载器（这里就用到了想调用的targetThreadContextClassLoader）做某些事情。
 *     使用完后要把当前线程的类加载器还原回去
 *
 * 当高层提供了统一的接口让低层去实现，同时又要在高层加载（或实例化）低层的类时，就必须要通过线程上下文类加载器帮助高层的ClassLoader找到并加载该类
 * @Author tan
 * @Date 2020/5/21 17:50
 * @Version 1.0
 **/
public class MyTest26 {

    public static void main(String[] args) {
//        Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator= loader.iterator();
        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("driver:" + driver.getClass() + ", loader:" + driver.getClass().getClassLoader());
        }
        System.out.println("当前线程上下文类加载器:" + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器:" + ServiceLoader.class.getClassLoader());
    }
}
