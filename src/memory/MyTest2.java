package memory;

/**
 * @ClassName MyTest2
 * @Description 虚拟机栈溢出
 * @Author tan
 * @Date 2020/7/15 19:42
 * @Version 1.0
 **/
public class MyTest2 {
    private int length;

    public int getLength() {
        return length;
    }

    public void test() {
        this.length++;

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        try {
            myTest2.test();
        } catch (Throwable ex) {
            System.out.println(myTest2.getLength());
            ex.printStackTrace();
        }
    }
}
