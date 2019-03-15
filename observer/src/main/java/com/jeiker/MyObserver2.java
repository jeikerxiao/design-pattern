package com.jeiker;

/**
 * Description: 观察者2
 * User: jeikerxiao
 * Date: 2019/3/15 1:48 PM
 */
public class MyObserver2 implements Observer {

    @Override
    public void update(Subject subject) {
        System.out.println(String.format("MyObserver2: You are %s ?", subject.getMsg()));

    }
}
