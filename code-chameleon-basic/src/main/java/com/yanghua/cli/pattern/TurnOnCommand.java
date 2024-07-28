package com.yanghua.cli.pattern;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName TurnOnCommand.java
 * @Description TODO 开关按钮 - 打开 指定设备
 * @createTime 2024年07月21日 13:45:00
 */
public class TurnOnCommand implements Command{
    private Device device;

    /**
     * 对 哪个 设备 发送 打开 的命名
     * @param device
     */
    public TurnOnCommand(Device device) {
        this.device = device;
    }
    @Override
    public void execute() {
        device.turnOn();
    }
}
