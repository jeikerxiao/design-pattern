package com.jeiker;

import com.jeiker.factory.BeefPizzaCreator;
import com.jeiker.factory.CheesePizzaCreator;
import com.jeiker.factory.MushroomPizzaCreator;
import com.jeiker.factory.PizzaFactory;
import com.jeiker.product.Pizza;

/**
 * Description: 测试类
 * 抽象工厂模式把对象的创建推迟到了子类之中，这样达到了解耦的目的。
 * 客户并不需要知道 CheesePizza 和 MushroomPizza 在准备原料，烘焙，包装时的一些差异，
 * 客户只需要知道，我需要一个蘑菇风味的披萨，于是我要MushroomPizzaCreator这个子工厂去给我生成一个蘑菇披萨就好了。
 * 如果下次我们打算加入一个新的披萨例如HamPizza,
 * 原有的代码不需要做任何改变，我们只要添加一个实际的产品，HamPizza和实际的子工厂，HamPizzaCreator就可以了。
 * 如果我们不打算销售 MushroomPizza，只需要删除 MushroomPizza 产品和其对应的子工厂就好了，客户只要根据菜单来点菜就好了。
 * <p>
 * 抽象工厂模式有几个优点符合OO设计原则：
 * 1. 将不变（比萨的三个步骤）和可变部分（比萨三步的具体实现）分离开来，对可变部分进行封装。
 * 2. 将对象的实例化推迟到子类来达到解耦的目的。
 * 3. 面向接口编程而非面向实现编程
 * User: jeikerxiao
 * Date: 2019/3/15 10:13 AM
 */
public class MyTest {

    public static void main(String[] args) {
//        PizzaFactory factory = new BeefPizzaCreator();
//        PizzaFactory factory = new CheesePizzaCreator();
        PizzaFactory factory = new MushroomPizzaCreator();
        Pizza pizza = factory.createPizza();
        pizza.prepare();
        pizza.bake();
        pizza.box();
    }
}
