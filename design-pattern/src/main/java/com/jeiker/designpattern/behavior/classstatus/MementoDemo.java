package com.jeiker.designpattern.behavior.classstatus;

/**
 * 备忘录模式
 * <p>
 * Original类是原始类，里面有需要保存的属性value及创建一个备忘录类，用来保存value值。
 * Memento类是备忘录类，Storage类是存储备忘录的类，持有Memento类的实例。
 * 简单描述下：
 * 新建原始类时，value被初始化为egg，
 * 后经过修改，将value的值置为niu，
 * 最后倒数第二行进行恢复状态，结果成功恢复了。
 * 其实我觉得这个模式叫“备份-恢复”模式最形象。
 */
public class MementoDemo {

    /**
     * 原始类(需要创建一个备忘录类（Memento）)
     */
    public static class Original {

        private String value;

        public Original(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        /**
         * 创建备忘录类
         */
        public Memento createMemento() {
            return new Memento(value);
        }

        /**
         * 恢复备忘录类
         */
        public void restoreMemento(Memento memento) {
            this.value = memento.getValue();
        }
    }

    /**
     * 备忘录类
     */
    public static class Memento {

        private String value;

        public Memento(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    /**
     * 存储备忘录的类（持有备忘录类）
     */
    public static class Storage {

        private Memento memento;

        public Storage(Memento memento) {
            this.memento = memento;
        }

        public Memento getMemento() {
            return memento;
        }

        public void setMemento(Memento memento) {
            this.memento = memento;
        }
    }

    public static void main(String[] args) {

        // 创建原始类
        Original origi = new Original("鸡蛋");

        // 创建备忘录
        Storage storage = new Storage(origi.createMemento());

        // 修改原始类的状态
        System.out.println("1.初始化的状态为: " + origi.getValue());
        origi.setValue("小鸡");
        System.out.println("2.修改后的状态为: " + origi.getValue());

        // 回复原始类的状态
        origi.restoreMemento(storage.getMemento());
        System.out.println("3.恢复后的状态为: " + origi.getValue());
    }
}
