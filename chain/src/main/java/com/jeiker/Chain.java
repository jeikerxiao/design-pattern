package com.jeiker;

/**
 * Description: 抽象基类 Chain
 * User: jeikerxiao
 * Date: 2019/3/15 2:27 PM
 */
public abstract class Chain {

    /**
     * 下一个节点
     */
    private Chain nextNode;

    protected Chain getNextNode() {
        return nextNode;
    }

    protected void setNextNode(Chain nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * 处理请求
     *
     * @param num
     */
    public abstract void handleRequest(int num);

}
