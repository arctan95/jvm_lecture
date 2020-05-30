package classloader;

/**
 * @ClassName MyCat
 * @Description TODO
 * @Author tan
 * @Date 2020/5/17 18:11
 * @Version 1.0
 **/
public class MyCat {
    public MyCat() {
        System.out.println("MyCat is loaded by:" + this.getClass().getClassLoader());
        // 下行代码若删除out文件夹中的MySample.class，会报ClassNotFoundException
        // 原因MyCat由 系统类加载器 加载，MySample由 自定义子类加载器 加载（见MyTest17_1代码）
        System.out.println("from MyCat:" + MySample.class);
    }
}
