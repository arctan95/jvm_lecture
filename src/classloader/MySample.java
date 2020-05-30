package classloader;

/**
 * @ClassName MySample
 * @Description TODO
 * @Author tan
 * @Date 2020/5/17 18:13
 * @Version 1.0
 **/
public class MySample {
    public MySample() {
        System.out.println("MySample is loaded by:" + this.getClass().getClassLoader());
        new MyCat();
        System.out.println("form MySample:" + MyCat.class);
    }
}
