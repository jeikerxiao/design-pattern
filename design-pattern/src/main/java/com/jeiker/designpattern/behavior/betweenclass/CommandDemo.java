package com.jeiker.designpattern.behavior.betweenclass;

/**
 * 命令模式
 * <p>
 * 司令员下令让士兵去干件事情，从整个事情的角度来考虑，司令员的作用是，发出口令，口令经过传递，传到了士兵耳朵里，士兵去执行。
 * 这个过程好在，两者相互解耦，任何一方都不用去依赖其他人，只需要做好自己的事儿就行，司令员要的是结果，不会去关注到底士兵是怎么实现的
 * Invoker是调用者（司令员），Receiver是被调用者（士兵），MyCommand是命令，实现了Command接口，持有接收对象
 * 这个很好理解，命令模式的目的就是：达到命令的发出者和执行者之间解耦，
 * 实现请求和执行分开，熟悉Struts的同学应该知道，Struts其实就是一种将请求和呈现分离的技术，其中必然涉及命令模式的思想！
 */
public class CommandDemo {
    // 命令接口
    public interface Command {
        void exe();
    }

    // 命令 (持有命令接收者，实现命令接口)
    public static class MyCommand implements Command {

        private Receiver receiver;

        public MyCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void exe() {
            System.out.println("2.Command call Receiver.");
            receiver.action();
        }
    }

    // 士兵（被调用者）
    public static class Receiver {
        public void action() {
            System.out.println("3.Receiver execute Command.");
        }
    }

    // 司令（调用者，持有命令）
    public static class Invoker {

        private Command command;

        public Invoker(Command command) {
            this.command = command;
        }

        public void action() {
            System.out.println("1.Invoker send Command.");
            command.exe();
        }
    }

    public static void main(String[] args) {
        // 士兵（被调用者）
        Receiver receiver = new Receiver();
        // 命令 (持有命令接收者，实现命令接口)
        Command cmd = new MyCommand(receiver);
        // 司令（调用者）
        Invoker invoker = new Invoker(cmd);
        // 司令发送命令：invoker.action()->command.exe()->receiver.action()
        // 目的：让 司令（调用者）与 士兵（被调用者）解耦
        invoker.action();
    }
}
