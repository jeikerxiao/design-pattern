package com.jeiker;

/**
 * Description: 小汽车
 * User: jeikerxiao
 * Date: 2019/3/15 11:44 AM
 */
public class Car extends DriveTemplate {

    @Override
    protected void openDoor() {
        System.out.println("keyless entry");

    }

    @Override
    protected void gear() {
        System.out.println("gear with hand");

    }

    @Override
    protected void brake() {
        System.out.println("brake with foot");

    }
}
