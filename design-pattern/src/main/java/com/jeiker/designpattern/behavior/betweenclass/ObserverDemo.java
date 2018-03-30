package com.jeiker.designpattern.behavior.betweenclass;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 观察者模式
 *
 * 类和类之间的关系，不涉及到继承
 * 当一个对象变化时，其它依赖该对象的对象都会收到通知，并且随着变化！
 * 对象之间是一种一对多的关系。
 */
public class ObserverDemo {

	/**
	 * 观察者接口
	 */
	public interface Observer {
		void update();
	}

	public static class Observer1 implements Observer {

		@Override
		public void update() {
			System.out.println("2.Observer1 has received message!");
		}
	}

	public static class Observer2 implements Observer {

		@Override
		public void update() {
			System.out.println("2.Observer2 has received message!");
		}
	}

	public interface Subject {

		/**
		 * 增加观察者
		 */
		void add(Observer observer);

		/**
		 * 删除观察者
		 */
		void del(Observer observer);

		/**
		 * 通知所有的观察者
		 */
		void notifyObservers();

		/**
		 * 自身的操作
		 */
		void operation();
	}

	public abstract static class AbstractSubject implements Subject {

		private Vector<Observer> vector = new Vector<Observer>();

		@Override
		public void add(Observer observer) {
			vector.add(observer);
		}

		@Override
		public void del(Observer observer) {
			vector.remove(observer);
		}

		@Override
		public void notifyObservers() {
			Enumeration<Observer> enumo = vector.elements();
			while (enumo.hasMoreElements()) {
				enumo.nextElement().update();
			}
		}
	}

	/**
	 * 主题
	 */
	public static class MySubject extends AbstractSubject {

		@Override
		public void operation() {
			System.out.println("1.Subject send message.");
			notifyObservers();
		}

	}

	public static void main(String[] args) {
		// 主题相当于广告板
		Subject sub = new MySubject();
		// 主题添加观察者1
		sub.add(new Observer1());
		// 主题添加观察者2
		sub.add(new Observer2());
		// 主题发送消息：观察者1和观察者2应该都收到通知
		sub.operation();
	}
}
