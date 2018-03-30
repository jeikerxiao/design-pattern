package com.jeiker.designpattern.behavior.betweenclass;

/**
 * 迭代模式
 * <p>
 * 此处我们貌似模拟了一个集合类的过程，感觉是不是很爽？
 * 其实JDK中各个类也都是这些基本的东西，加一些设计模式，再加一些优化放到一起的，
 * 只要我们把这些东西学会了，掌握好了，我们也可以写出自己的集合类，甚至框架！
 */
public class IteratorDemo {

    public interface Collection {
        /**
         * 迭代器
         */
        Iterator iterator();

        /**
         * 取得集合元素
         */
        Object get(int i);

        /**
         * 取得集合大小
         */
        int size();
    }

    public interface Iterator {
        /**
         * 取得第一个元素
         */
        Object first();

        /**
         * 前移
         */
        Object previous();

        /**
         * 后移
         */
        Object next();

        /**
         * 是否有下一个
         */
        boolean hasNext();

    }

    /**
     * 实现集合
     */
    public static class MyCollection implements Collection {

        public String string[] = {"A", "B", "C", "D", "E"};

        @Override
        public Iterator iterator() {
            return new MyIterator(this);
        }

        @Override
        public Object get(int i) {
            return string[i];
        }

        @Override
        public int size() {
            return string.length;
        }
    }

    /**
     * 实现迭代器
     */
    public static class MyIterator implements Iterator {

        private Collection collection;
        private int pos = -1;

        public MyIterator(Collection collection) {
            this.collection = collection;
        }

        @Override
        public Object previous() {
            if (pos > 0) {
                pos--;
            }
            return collection.get(pos);
        }

        @Override
        public Object next() {
            if (pos < collection.size() - 1) {
                pos++;
            }
            return collection.get(pos);
        }

        @Override
        public boolean hasNext() {
            if (pos < collection.size() - 1) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Object first() {
            pos = 0;
            return collection.get(pos);
        }

    }

    public static void main(String[] args) {
        Collection collection = new MyCollection();
        Iterator it = collection.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
