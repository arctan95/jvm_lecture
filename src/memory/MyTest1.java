package memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyTest1
 * @Description
 * 线程私有：
 *              虚拟机栈：Stack Frame 栈帧：方法执行的时候创建。栈用于存放局部变量表、操作栈、动态链接、方法出口等信息。一个方法的执行过程就是该方法对于栈帧的入栈出栈过程
 *              程序计数器（Program Counter）
 *              本地方法栈：主要用于执行本地native方法
 * 线程共享：
 *              堆（Heap）：JVM管理的最大一块内存空间 新生代、老年代：Eden空间（80%）、From Survivor空间（10%）与To Survivor空间（10%）
 *              方法区（Method Area）：存储元信息，永久代（Permanent Generation）从JDK1.8开始已经彻底废弃，使用与堆不相连的本地内存区域：元空间（Meta Space）64位默认21M
 *              运行时常量池：方法区的一部分，存储常量、符号引用等
 *
 *              直接内存（Direct Memory）：堆外内存，非JVm直接管理而是由操作系统管理，与Java NIO密切相关
 *              JVM通过堆上的DirectByteBuffer来操作直接内存
 *
 *
 * 关于Java对象创建的过程：
 *      new关键字创建对象的3个步骤
 *      1.在堆内存中创建出对象的实例
 *      2.为对象的实例成员变量赋初始值
 *      3.将对象的引用返回
 *
 *      指针碰撞（前提是堆中的空间通过一个指针进行分割，一侧是已经被占用的空间，另一侧是未被占用的空间）
 *      空闲列表（前提是堆内存空间中已被使用与未被使用的空间是交织在一起的，虚拟机此时需要一个列表记录可以使用的空间和已被使用的空间）
 *
 *      对象在内存中的布局：
 *      1.对象头
 *      2.实例数据（即一个类中声明的各项信息）
 *      3.对齐填充（可选）
 *
 *      引用对象的方式：
 *      1.句柄：句柄包含：对象实例数据地址、类型数据地址
 *      2.直接指针
 * @Author tan
 * @Date 2020/7/14 21:24
 * @Version 1.0
 **/
public class MyTest1 {
    public static void main(String[] args) {
        List<MyTest1> list = new ArrayList<MyTest1>();
        for (; ;) {
            list.add(new MyTest1());
            System.gc();// 不推荐显式调用
        }
    }
}
