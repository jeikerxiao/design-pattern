package com.jeiker;

/**
 * Description: 单例模式1
 * 优点：可以实现“延迟实例化”。
 * 缺点：无法保证在多线程场景中依然可以保持单例。
 * User: jeikerxiao
 * Date: 2019/3/15 2:46 PM
 */
public class Singleton1 {

    private static Singleton1 instance;

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
