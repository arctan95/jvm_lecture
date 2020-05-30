package classloader;

/**
 * @ClassName MyTest15
 * @Description 数组的类加载器和数组的元素的类加载器是一致的，数组的元素为基本类型(int,short等)时，数组没有类加载器
 * @Author tan
 * @Date 2020/5/16 17:19
 * @Version 1.0
 **/
public class MyTest15 {
    public static void main(String[] args) {
        String[] strs = new String[2];
        // null表示启动类加载器
        System.out.println(strs.getClass().getClassLoader());

        System.out.println("---------------");

        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());

        System.out.println("---------------");

        int[] ints = new int[2];
        // null表示数组没有加载器
        System.out.println(ints.getClass().getClassLoader());
    }
}
