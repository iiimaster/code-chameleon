package com.yanghua.cli.pattern;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName RemoteControl.java
 * @Description TODO 调用者----遥控器
 * @createTime 2024年07月21日 13:40:00
 */
public class RemoteControl {
    /**
     * 遥控器上的一个个的按钮
     */
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
