package com.jeiker;

/**
 * Description: design-pattern
 * User: jeikerxiao
 * Date: 2019/3/15 11:46 AM
 */
public class MyTest {

    public static void main(String[] args) {

        //        DriveTemplate template = new Car();
        DriveTemplate template = new Motorcycle();
        template.drive();
    }
}
