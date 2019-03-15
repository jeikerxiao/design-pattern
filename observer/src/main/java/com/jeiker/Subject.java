package com.jeiker;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 被观察的主题
 * User: jeikerxiao
 * Date: 2019/3/15 1:46 PM
 */
public class Subject {

    private String msg;

    private List<Observer> observers = new ArrayList<Observer>();

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 注册观察者
     *
     * @param observer
     */
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * 删除观察者
     *
     * @param observer
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知观察者
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
