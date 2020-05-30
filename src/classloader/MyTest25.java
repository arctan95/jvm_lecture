package classloader;

/**
 * @ClassName MyTest25
 * @Description 默认的上下文类加载器
 * @Author tan
 * @Date 2020/5/21 17:40
 * @Version 1.0
 **/
public class MyTest25 implements Runnable{

    private Thread thread;

    public MyTest25() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader classLoader = this.thread.getContextClassLoader();
        this.thread.setContextClassLoader(classLoader);
        // 默认的上下文类加载器为系统类加载器
        System.out.println("Class:" + classLoader.getClass());
        System.out.println("Parent:" + classLoader.getParent());
    }

    public static void main(String[] args) {
        new MyTest25();
    }
}
