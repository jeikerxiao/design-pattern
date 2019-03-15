package com.jeiker;

/**
 * Description: 单例模式2
 * 优点：既能实现延迟实例化也能保证在多线程环境下只有一个实例
 * 缺点：synchronized关键字却引出了另外一个问题,性能问题
 * 当 Singleton2.getInstance 方法要被很多个类同时调用很多次，这个时候你就不得不考虑性能问题了
 * User: jeikerxiao
 * Date: 2019/3/15 2:49 PM
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {

    }

    public synchronized static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
