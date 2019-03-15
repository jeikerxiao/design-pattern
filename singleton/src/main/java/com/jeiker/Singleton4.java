package com.jeiker;

/**
 * Description: design-pattern
 * 优点：可以实现延迟实例化，可以保证多线程场景下单例的问题
 * 缺点：Java 1.5 之前的版本不适用
 * User: jeikerxiao
 * Date: 2019/3/15 2:55 PM
 */
public class Singleton4 {

    private volatile static Singleton4 instance = null;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
