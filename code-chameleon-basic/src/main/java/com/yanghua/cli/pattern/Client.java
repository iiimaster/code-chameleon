package com.yanghua.cli.pattern;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO 客户端----使用遥控器的人
 * @createTime 2024年07月21日 13:48:00
 */
public class Client {
    public static void main(String[] args) {
        // 1、创建接收者对象
        Device xiaomi = new Device("小米电视");
        Device huawei = new Device("华为电视");

        // 2、创建指令
        TurnOnCommand turnOnCommand = new TurnOnCommand(xiaomi);
        TurnOffCommand turnOffCommand = new TurnOffCommand(huawei);

        // 3、创建调用者
        RemoteControl remoteControl = new RemoteControl();

        // 3.1设置指令
        remoteControl.setCommand(turnOnCommand);
        // 3.2按下 开机 键
        remoteControl.pressButton();

        remoteControl.setCommand(turnOffCommand);
        remoteControl.pressButton();


    }
}
