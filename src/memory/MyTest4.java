package memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @ClassName MyTest4
 * @Description 方法区产生内存溢出错误
 * @Author tan
 * @Date 2020/7/15 21:30
 * @Version 1.0
 **/
public class MyTest4 {
    public static void main(String[] args) {
        for (; ;) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)(obj, method, args1, proxy) -> proxy.invokeSuper(obj, args1));
            System.out.println("hello world");
            enhancer.create();
        }
    }
}
