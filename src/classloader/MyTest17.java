package classloader;

/**
 * @ClassName MyTest17
 * @Description 复杂类加载情况
 * 加载当前类的加载器也会去加载其调用的类，但仍首先委托给父加载器尝试加载
 * @Author tan
 * @Date 2020/5/17 18:10
 * @Version 1.0
 **/
public class MyTest17 {
    public static void main(String[] args) throws Exception {
        MyClassLoader loader1 = new MyClassLoader("loader1", null);
        Class<?> clazz = loader1.loadClass("classloader.MySample");
        System.out.println("class:" + clazz.hashCode());
        // 如果注释下行代码，那么并不会实例化MySample对象，即MySample构造方法不会被调用
        // 因此也不会实例化MyCat对象，没有对MyCat主动使用，就不会加载MyCat Class
        // 但JVM规范允许类加载器在预料某个类将被使用时就预先加载它，如果预加载过程中遇到.class文件缺失或存在错误
        // 类加载器必须在程序 首次主动使用 该类时才报告错误（LinkedError）错误

        Object object = clazz.newInstance();
    }
}
