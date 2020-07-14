package DesignPattern.Singleton;

/**
 * 饿汉式
 * 1.私有构造函数，不能从外部实例化。
 * 2.在类内实例化一个私有静态对象。
 * 3.提供一个公有静态方法，返回实例对象。
 * 4.类加载时创建一个实例对象，节省判断时间。
 */
public class Singleton2 {
    private Singleton2(){}
    private static Singleton2 instance = new Singleton2();

    public static Singleton2 getInstance(){
        return instance;
    }
}
