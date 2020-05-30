package classloader;

/**
 * @ClassName MyTest18_1
 * @Description 不同类加载器作用及加载范围
 * 若将想要加载的class文件放到启动类加载器对应的目录下，就可以由启动类加载器加载
 * @Author tan
 * @Date 2020/5/17 21:43
 * @Version 1.0
 **/
public class MyTest18_1 {
    public static void main(String[] args) throws Exception {
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("C:\\Users\\acer\\Desktop\\");
        Class<?> clazz = loader1.loadClass("classloader.MyTest1");
        System.out.println("class:" + clazz.hashCode());
        System.out.println("class loader:" + clazz.getClassLoader());
    }
}
