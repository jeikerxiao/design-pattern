package com.jeiker;

/**
 * Description: design-pattern
 * User: jeikerxiao
 * Date: 2019/3/15 11:44 AM
 */
public class Motorcycle extends DriveTemplate {

    @Override
    protected void openDoor() {
        System.out.println("no door actually");

    }

    @Override
    protected void gear() {
        System.out.println("gear with foot");

    }

    @Override
    protected void brake() {
        System.out.println("brake with hand");

    }
}
