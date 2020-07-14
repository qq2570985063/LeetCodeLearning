package DesignPattern.Singleton;

/**
 * 静态内部类
 * 静态内部类的优点是：外部类（Singleton4）加载时不需要立即加载内部类（Singleton4Holder）,
 * 内部类不被加载则不去初始化instance，故而不占内存。
 * 即当Singleton4第一次被加载时，并不需要立即加载Singleton4Holder，
 * 只有当getInstance方法被第一次调用时，才加载Singleton4Holder类，并初始化instance。
 * 这种方法不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。
 */
public class Singleton4 {
    private Singleton4(){}
    private static class Singleton4Holder{
        private static Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance(){
        return Singleton4Holder.instance;
    }
}
