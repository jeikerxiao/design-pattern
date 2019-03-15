package com.jeiker.factory;

import com.jeiker.product.BeefPizza;
import com.jeiker.product.Pizza;

/**
 * Description: 牛肉比萨的创建者
 * User: jeikerxiao
 * Date: 2019/3/15 10:11 AM
 */
public class BeefPizzaCreator implements PizzaFactory {

    @Override
    public Pizza createPizza() {
        return new BeefPizza();
    }
}
