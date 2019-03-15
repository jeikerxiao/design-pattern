package com.jeiker;

/**
 * Description: design-pattern
 * User: jeikerxiao
 * Date: 2019/3/15 2:30 PM
 */
public class ChainNodeLast extends Chain {

    @Override
    public void handleRequest(int num) {
        System.out.println("Why I'm here, it seems the number is greater than 30 !");
    }
}
