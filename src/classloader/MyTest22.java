package classloader;

/**
 * @ClassName MyTest22
 * @Description 扩展类加载器只会加载指定目录下的jar文件
 *  终端输入 java -Djava.ext.dirs=./ classloader/MyTest22
 *  表示扩展类加载器加载目录更改为当前目录，但若当前目录若没有jar文件，那么扩展类加载器不会加载任何类
 * @Author tan
 * @Date 2020/5/18 12:21
 * @Version 1.0
 **/
public class MyTest22 {

    static {
        System.out.println("MyTest22 initializer");
    }

    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());
        System.out.println(MyTest1.class.getClassLoader());
    }
}
