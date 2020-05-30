package classloader;

import classloader.MyClassLoader;

/**
 * @ClassName MyTest17_1
 * @Description 关于命名空间的重要说明
 * 1.命名空间由当前加载器及所有父类加载器所加载的类组成
 * 2.不同类加载器有不同命名空间
 * 3.父类加载器看不到子类加载器的类，但子类加载器能看到父类加载器的类
 * @Author tan
 * @Date 2020/5/17 20:12
 * @Version 1.0
 **/
public class MyTest17_1 {

    public static void main(String[] args) throws Exception {
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("C:\\Users\\acer\\Desktop\\");
        Class<?> clazz = loader1.loadClass("classloader.MySample");
        System.out.println("class:" + clazz.hashCode());

        Object object = clazz.newInstance();
    }
}
