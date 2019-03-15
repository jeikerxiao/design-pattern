package com.jeiker;

/**
 * Description: design-pattern
 * User: jeikerxiao
 * Date: 2019/3/15 2:30 PM
 */
public class ChainNode3 extends Chain {

    @Override
    public void handleRequest(int num) {
        if (num >= 20 && num < 30) {
            System.out.println("ChinaNode3 take in charge the number less than 30");
        } else {
            Chain nextNode = getNextNode();
            if (nextNode != null) {
                nextNode.handleRequest(num);
            }
        }
    }
}
