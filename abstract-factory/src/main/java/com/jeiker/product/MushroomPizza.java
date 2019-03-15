package com.jeiker.product;

/**
 * Description: 蘑菇比萨
 * User: jeikerxiao
 * Date: 2019/3/15 10:05 AM
 */
public class MushroomPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("prepare MushroomPizza");

    }

    @Override
    public void bake() {
        System.out.println("bake MushroomPizza");

    }

    @Override
    public void box() {
        System.out.println("box MushroomPizza");

    }
}
