package com.jeiker.product;

/**
 * Description: 芝士比萨
 * User: jeikerxiao
 * Date: 2019/3/15 10:00 AM
 */
public class CheesePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("prepare CheesePizza");
    }

    @Override
    public void bake() {
        System.out.println("bake CheesePizza");
    }

    @Override
    public void box() {
        System.out.println("box CheesePizza");
    }
}
