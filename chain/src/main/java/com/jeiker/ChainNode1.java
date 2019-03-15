package com.jeiker;

/**
 * Description: design-pattern
 * User: jeikerxiao
 * Date: 2019/3/15 2:28 PM
 */
public class ChainNode1 extends Chain {

    @Override
    public void handleRequest(int num) {
        if (num < 10) {
            System.out.println("ChinaNode1 take in charge the number less than 10");
        } else {
            Chain nextNode = getNextNode();
            if (nextNode != null) {
                nextNode.handleRequest(num);
            }
        }
    }
}
