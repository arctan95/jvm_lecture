package classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * @ClassName MyTest19
 * @Description 扩展类加载器
 * @Author tan
 * @Date 2020/5/17 21:43
 * @Version 1.0
 **/
public class MyTest19 {
    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class.getClassLoader());
    }
}
