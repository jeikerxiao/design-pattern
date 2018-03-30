package com.jeiker.designpattern.create;

import com.jeiker.designpattern.create.util.MailSender;
import com.jeiker.designpattern.create.util.Sender;
import com.jeiker.designpattern.create.util.SmsSender;

/**
 * 静态工厂模式
 */
public class StaticFactoryDemo {

    public static Sender produceMail() {
        return new MailSender();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }

    public static void main(String[] args) {
        Sender sender = StaticFactoryDemo.produceMail();
        sender.Send();
    }
}
