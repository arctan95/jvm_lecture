package classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @ClassName MyClassLoader
 * @Description 自定义类加载器 需继承ClassLoader类
 *  必须重写ClassLoader类的findClass方法,该方法会在检查完父类加载器能否加载指定类后，由继承自ClassLoader类的loadClass方法调用
 *  findClass方法调用继承自ClassLoader类的defineClass方法(从字节数组中返回一个Class对象)
 * @Author tan
 * @Date 2020/5/16 18:42
 * @Version 1.0
 **/
public class MyClassLoader extends ClassLoader {

    private String classLoaderName;

    private String path;

    private String fileExtension = ".class";

    public MyClassLoader(String classLoaderName) {
        // 将系统类加载器当作该类的父加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    public MyClassLoader(String classLoaderName, ClassLoader parent) {
        // 显式指定该类的父加载器
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return this.getClass() + "@[" + this.classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass invoked:" + name);
        System.out.println("class loader name:" + this.classLoaderName);
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);

    }

    // 从文件中获得字节数组
    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        name = name.replace(".","\\");

        try {
            is = new FileInputStream(new File(this.path + name + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
             e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader loader1 = new MyClassLoader("MyClassLoader1");

        loader1.setPath("C:\\Users\\acer\\Desktop\\");
        Class<?> clazz = loader1.loadClass("classloader.MyTest1");
        System.out.println("class" + clazz.hashCode());
        System.out.println("class loader of " + clazz.getName() + ":" + clazz.getClassLoader());
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println("======================================");

        // 类的卸载
        // 虚拟机自带的类加载器（包括根类加载器、扩展类加载器和系统类加载器）所加载的类，在虚拟机的生命周期中，始终不会被卸载
        // 由用户自定义的类加载器所加载的类是可以被卸载的
        loader1 = null;
        clazz = null;
        object = null;
        System.gc();

        loader1 = new MyClassLoader("loader1");
        loader1.setPath("G:\\github\\jvm_lecture\\out\\production\\jvm_lecture\\");
        clazz = loader1.loadClass("classloader.MyTest1");
        System.out.println("class" + clazz.hashCode());
        System.out.println("class loader of " + clazz.getName() + ":" + clazz.getClassLoader());
        object = clazz.newInstance();
        System.out.println(object);

//        MyClassLoader loader2 = new MyClassLoader("MyClassLoader2", loader1);
//
//        loader2.setPath("G:\\github\\jvm_lecture\\out\\production\\jvm_lecture\\");
//        Class<?> clazz2 = loader2.loadClass("classloader.MyTest1");
//        System.out.println("class" + clazz2.hashCode());
//        System.out.println("class loader of " + clazz2.getName() + ":" + clazz2.getClassLoader());
//        Object object2 = clazz2.newInstance();
//        System.out.println(object2);
//        System.out.println("======================================");
//
//        MyClassLoader loader3 = new MyClassLoader("MyClassLoader3");
//        Class<?> clazz3 = loader3.loadClass("classloader.MyTest1");
//        System.out.println("class" + clazz3.hashCode());
//        System.out.println("class loader of " + clazz3.getName() + ":" + clazz3.getClassLoader());
//        Object object3 = clazz3.newInstance();
//        System.out.println(object3);

    }
}
