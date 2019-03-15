package com.jeiker;

/**
 * Description: 测试观察者模式
 * User: jeikerxiao
 * Date: 2019/3/15 1:50 PM
 */
public class MyTest {

    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.registerObserver(new MyObserver1());
        subject.registerObserver(new MyObserver2());
        subject.setMsg("Subject");
        subject.notifyObservers();
    }
}
