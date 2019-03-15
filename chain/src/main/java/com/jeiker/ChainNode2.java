package com.jeiker;

/**
 * Description: design-pattern
 * User: jeikerxiao
 * Date: 2019/3/15 2:29 PM
 */
public class ChainNode2 extends Chain {

    @Override
    public void handleRequest(int num) {
        if (num >= 10 && num < 20) {
            System.out.println("ChinaNode2 take in charge the number less than 20");
        } else {
            Chain nextNode = getNextNode();
            if (nextNode != null) {
                nextNode.handleRequest(num);
            }
        }
    }
}
