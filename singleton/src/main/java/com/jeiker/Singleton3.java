package com.jeiker;

/**
 * Description: design-pattern
 * 优点：能够解决多线程环境下的单例问题也不会出现性能问题
 * 缺点：JVM在加载 Singleton3 类的时候就会把 Singleton3 的对象实例化出来并放置到JVM内存静态区,无法实现延迟实例化
 * User: jeikerxiao
 * Date: 2019/3/15 2:54 PM
 */
public class Singleton3 {

    private static Singleton3 instance = new Singleton3();

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        return instance;
    }
}
