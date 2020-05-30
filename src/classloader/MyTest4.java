package classloader;

/**
 * @ClassName MyTest4
 * @Description 对于数组实例来说，并不会主动使用相应的类。其类型是由JVM在运行期间动态生成的，
 * 表示为[Lclassloader.MyParent4这种形式。动态生成的类型，其父类型是Object
 *
 * 对于数组来说，JavaDoc经常将构成数组的元素称为Component，实际上就是将数组降低一个维度后的类型
 *
 * 助记符：anewarray表示创建一个引用类型（如类、接口、数组等）的数组，并将其引用值压入栈顶
 *        newarray表示创建一个原始类型（如int、float、char等）的数组，并将其引用值压入栈顶
 * @Author tan
 * @Date 2020/5/4 16:43
 * @Version 1.0
 **/
public class MyTest4 {
    public static void main(String[] args) {
        MyParent4[] myParent4s = new MyParent4[1];
        System.out.println(myParent4s.getClass());
        System.out.println(myParent4s.getClass().getSuperclass());

        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());
    }
}
class MyParent4 {
    static {
        System.out.println("MyParent4 static block");
    }
}