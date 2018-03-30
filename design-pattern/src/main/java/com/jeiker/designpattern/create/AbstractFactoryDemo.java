package com.jeiker.designpattern.create;

import com.jeiker.designpattern.create.util.MailSender;
import com.jeiker.designpattern.create.util.Sender;
import com.jeiker.designpattern.create.util.SmsSender;

/**
 * 抽象工厂模式
 */
public class AbstractFactoryDemo {

    public interface Provider {
        public Sender produce();
    }

    public static class SendMailFactory implements Provider {

        @Override
        public Sender produce() {
            return new MailSender();
        }
    }

    public static class SendSmsFactory implements Provider {

        @Override
        public Sender produce() {
            return new SmsSender();
        }
    }

    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }
}
