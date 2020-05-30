package classloader;

/**
 * @ClassName MyTest7
 * @Description TODO
 * @Author tan
 * @Date 2020/5/12 16:37
 * @Version 1.0
 **/
public class MyTest7 {

    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("java.lang.String");
        // 返回null 表示String类由bootstrap加载器加载
        System.out.println(clazz.getClassLoader());

        //类C由AppClassLoader加载
        Class<?> clazz2 = Class.forName("classloader.C");
        System.out.println(clazz2.getClassLoader());
    }
}

class C {
    int a = 1;
}