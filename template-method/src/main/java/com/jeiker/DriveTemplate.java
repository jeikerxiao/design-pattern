package com.jeiker;

/**
 * Description: design-pattern
 * User: jeikerxiao
 * Date: 2019/3/15 11:43 AM
 */
public abstract class DriveTemplate {

    public final void drive() {
        openDoor();
        startEngine();
        gear();
        go();
        brake();
        stop();
    }

    protected abstract void openDoor();

    protected void startEngine() {
        System.out.println("engine started !");
    }

    protected abstract void gear();

    protected void go() {
        System.out.println("running...");
    }

    protected abstract void brake();

    protected void stop() {
        System.out.println("stopped !");
    }

}
