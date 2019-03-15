package com.jeiker.factory;

import com.jeiker.product.MushroomPizza;
import com.jeiker.product.Pizza;

/**
 * Description: 蘑菇比萨的创建者
 * User: jeikerxiao
 * Date: 2019/3/15 10:12 AM
 */
public class MushroomPizzaCreator implements PizzaFactory {

    @Override
    public Pizza createPizza() {
        return new MushroomPizza();
    }
}
