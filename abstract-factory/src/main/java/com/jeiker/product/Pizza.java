package com.jeiker.product;

/**
 * Description: Pizza的接口
 * User: jeikerxiao
 * Date: 2019/3/15 9:57 AM
 */
public interface Pizza {

    /**
     * 准备材料
     */
    void prepare();

    /**
     * 烘培
     */
    void bake();

    /**
     * 打包
     */
    void box();
}
