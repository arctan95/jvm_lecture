package classloader;

import sun.misc.Launcher;

/**
 * @ClassName MyTest23
 * @Description 在运行期，一个Java类是由该类的完全限定名（binary name，二进制名）和用于加载该类的定义类加载器（defining loader）所共同决定的
 * 如果同样名字（即相同的完全限定名）的类是由两个不同的加载器所加载，那么这些类就是不同的（即使.class文件所在位置和字节码完全一样）
 * @Author tan
 * @Date 2020/5/18 12:48
 * @Version 1.0
 **/
public class MyTest23 {

    public static void main(String[] args) {
        /**
         * 在Oracle的Hotspot实现中，系统属性sun.boot.class.path如果被修改，则会报如下错误：
         * Error occurred during initialization of VM
         * java/lang/NoClassDefFoundError: java/lang/Object
         **/
        //启动类加载器
        System.out.println(System.getProperty("sun.boot.class.path"));
        //扩展类加载器
        System.out.println(System.getProperty("java.ext.dirs"));
        //系统类加载器
        System.out.println(System.getProperty("java.class.path"));
        /*
         内建于JVM中的启动类加载器会加载java.lang.ClassLoader以及其他的Java平台类，
         当JVM启动时，一块特殊的机器码会运行（启动类加载器Bootstrap），它会加载扩展类加载器与系统类加载器

         启动类加载器并不是Java类，是特定于平台的机器指令，它负责开启整个的加载过程
         启动类加载器还会负责加载供JRE正常运行所需要的基本组件，包括java.util、java.lang包中的类等
         除了启动类加载器外，其他的类加载器都是Java类
        */

        // ClassLoader类由启动类加载器加载
        System.out.println(ClassLoader.class.getClassLoader());
        // 如果Launcher类是由启动类加载器加载，那么Launcher中的ExtClassLoader和AppClassLoader也将会由启动类加载器加载
        System.out.println(Launcher.class.getClassLoader());
        System.out.println("-------------------");
        // 默认情况下java.system.class.loader没有被定义
        System.out.println(System.getProperty("java.system.class.loader"));
        System.out.println(MyTest23.class.getClassLoader());
        System.out.println(MyClassLoader.class.getClassLoader());

        // 终端运行java -Djava.system.class.loader=classloader.MyClassLoader可以将自定义的类加载器变成系统类加载器
        // 但其是由AppClassLoader加载的
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
