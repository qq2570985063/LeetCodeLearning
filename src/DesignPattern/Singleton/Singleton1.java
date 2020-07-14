package DesignPattern.Singleton;

/**
 * 单例模式四大原则：
 * 1.构造私有。
 * 2.以静态方法或者枚举返回实例。
 * 3.确保实例只有一个，尤其是多线程环境。
 * 4.确保反序列换时不会重新构建对象。
 */

/**
 * 懒汉式
 *
 * 1.私有构造函数，不能从外部实例化。
 * 2.在类内实例化一个私有静态对象。
 * 3.提供一个公有静态方法，返回实例对象。
 * 4.延时加载，即一开始不实例化对象，只有第一次调用到该实例时才加载，节省空间。
 */

// 非线程安全
public class Singleton1{
    private Singleton1(){}
    private static Singleton1 instance = null;

    public static Singleton1 getInstance(){
        if(instance == null) instance = new Singleton1();
        return instance;
    }
}

// 线程安全
// 在get方法前加synchronized修饰
//public class Singleton1{
//    private static Singleton1 instance = null;
//    private Singleton1(){}
//
//    public static synchronized Singleton1 getInstance(){
//        if(instance == null) instance = new Singleton1();
//        return instance;
//    }
//}
