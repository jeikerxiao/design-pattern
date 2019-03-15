package com.jeiker.factory;

import com.jeiker.product.CheesePizza;
import com.jeiker.product.Pizza;

/**
 * Description: 芝士比萨的创建者
 * User: jeikerxiao
 * Date: 2019/3/15 10:10 AM
 */
public class CheesePizzaCreator implements PizzaFactory {

    @Override
    public Pizza createPizza() {
        return new CheesePizza();
    }
}
