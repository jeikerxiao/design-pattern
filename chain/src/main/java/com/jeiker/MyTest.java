package com.jeiker;

/**
 * Description: 责任链设计模式
 * 责任链条里面都一定会有一个节点根据你的数字大小来处理，
 * 而客户端本身并不知道具体是哪个节点处理了这个请求，
 * 客户端只需要知道请求一定会被某个节点处理。
 * User: jeikerxiao
 * Date: 2019/3/15 2:31 PM
 */
public class MyTest {

    public static void main(String[] args) {
        // 组合责任链
        Chain node1 = new ChainNode1();
        Chain node2 = new ChainNode2();
        Chain node3 = new ChainNode3();
        Chain lastNode = new ChainNodeLast();
        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(lastNode);

        // 使用责任链处理请求
        node1.handleRequest(200);
    }
}
