package com.jeiker;

/**
 * Description: 观察者1
 * User: jeikerxiao
 * Date: 2019/3/15 1:47 PM
 */
public class MyObserver1 implements Observer {

    @Override
    public void update(Subject subject) {
        System.out.println(String.format("MyObserver1: You are %s ?", subject.getMsg()));
    }
}
