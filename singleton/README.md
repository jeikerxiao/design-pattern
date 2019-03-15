# 单例模式


## 实现1

```java

/**
 * Description: 单例模式1
 * 优点：可以实现“延迟实例化”。
 * 缺点：无法保证在多线程场景中依然可以保持单例。
 * User: jeikerxiao
 * Date: 2019/3/15 2:46 PM
 */
public class Singleton1 {

    private static Singleton1 instance;

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
```

延迟实例化？也就是说如果 Singleton1.getInstance() 这个方法不被调用的话，JVM里面永远都不会有MyClass的实例。

如果 getInstance 方法被调用的话，程序会首先判断静态变量instance是否为null，

如果为null则第一次(也是最后一次)使用new关键字调用私有构造方法实例化一个 Singleton1 对象并赋值给静态变量instance，这样instance变量就会持有 Singleton1 的对象，当getInstance方法第二次被调用的时候，程序直接返回一个已经存在在JVM内存静态区的instance.

仔细想想，Singleton1 对象真的只会创建一次吗？

有没有那种场景，万一的巧合，Singleton1 类创建了两个实例呢？

答案是肯定的，在多线程场景中，Singleton1 对象很有可能被实例化多次，这样就引出了第一种实现方式的局限性。

缺点：无法保证在多线程场景中依然可以保持单例。


## 实现2

```java

/**
 * Description: 单例模式2
 * 优点：既能实现延迟实例化也能保证在多线程环境下只有一个实例
 * 缺点：synchronized关键字却引出了另外一个问题,性能问题
 * 当 Singleton2.getInstance 方法要被很多个类同时调用很多次，这个时候你就不得不考虑性能问题了
 * User: jeikerxiao
 * Date: 2019/3/15 2:49 PM
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {

    }

    public synchronized static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
```

从以上代码可以看到，我们在 getInstance 方法上使用了 synchronized 关键字，这样我们这个单例模式可以经得住多线程场景的考验了吧？

确实，synchronized 方法不会再惧怕两个线程同时进入 getInstance 方法创建两个实例的尴尬情况，但是 synchronized 关键字却引出了另外一个问题，性能。

当然如果 Singleton2 方法半天都难得被调用一次，你完全可以采用这种方式实现你的单例模式，

但是想想，有没有那么一种可能，Singleton2.getInstance 方法要被很多个类同时调用很多次，这个时候你就不得不考虑性能问题了，

综上所述，第二种实现方式的优缺点显而易见：

优点：既能实现延迟实例化也能保证在多线程环境下只有一个实例

缺点：性能问题


## 实现3

```java

/**
 * Description: design-pattern
 * 优点：能够解决多线程环境下的单例问题也不会出现性能问题
 * 缺点：JVM在加载 Singleton3 类的时候就会把 Singleton3 的对象实例化出来并放置到JVM内存静态区,无法实现延迟实例化
 * User: jeikerxiao
 * Date: 2019/3/15 2:54 PM
 */
public class Singleton3 {

    private static Singleton3 instance = new Singleton3();

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        return instance;
    }
}

```

第三种单例实现方式也就是我们通常所说的饿汉单例模式，

这种方式将 Singleton3 的对象赋值给类变量，这样JVM在加载 Singleton3 类的时候就会把 Singleton3 的对象实例化出来并放置到JVM内存静态区，下次有其他类调用 Singleton3.getInstance 方法时直接返回静态区的实例，避免了再次创建对象。

但是这种饿汉单例模式也有一个明显的缺点，那就是无法实现延迟实例化，

对象的实例化放到了类加载阶段而不是 getInstane 方法首次调用的时候，

初看起来这也没什么不好，但是仔细想想：

如果我们有很多个类都是实现的饿汉单例模式，而每一个类实例化的时候都需要使用很多资源，

例如获得数据连接或建立数据池等等，那JVM在加载这些类的时候是不是需要花很长时间甚至出现 OutOfMemory 异常呢，

而且依据OO设计依赖倒置原则：变量不可以持有具体类的引用。

综上所述，貌似第三种实现方式也需要改良。

优点：能够解决多线程环境下的单例问题也不会出现性能问题

缺点：无法实现延迟实例化


## 实现4

```java
/**
 * Description: design-pattern
 * 优点：可以实现延迟实例化，可以保证多线程场景下单例的问题
 * 缺点：Java 1.5 之前的版本不适用
 * User: jeikerxiao
 * Date: 2019/3/15 2:55 PM
 */
public class Singleton4 {

    private volatile static Singleton4 instance = null;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
```

第四种方式使用了双重检查加锁机制，这种方式保证了只有第一次创建对象的时候才会同步，从而既保证了多线程场景下只有一个实例被创建也避免了同步方法带来的性能问题，

但是是不是这种解决方案没有任何缺点呢? 

答案是否定的，Java 1.5开始才有volatile关键字，如果你使用的是1.4及之前的版本，还是忘了这种实现方式吧！

优点：可以实现延迟实例化，可以保证多线程场景下单例的问题

缺点：Java 1.5 之前的版本不适用