package com.jeiker.product;

/**
 * Description: 牛肉比萨
 * User: jeikerxiao
 * Date: 2019/3/15 10:04 AM
 */
public class BeefPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("prepare BeefPizza");

    }

    @Override
    public void bake() {
        System.out.println("bake BeefPizza");

    }

    @Override
    public void box() {
        System.out.println("box BeefPizza");

    }
}
