package com.yanghua.cli.pattern;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName Device.java
 * @Description TODO 接受者----设备（即执行指令的对象）
 * @createTime 2024年07月21日 13:35:00
 */
public class Device {
    private String name;

    public Device() {}

    public Device(String name) {
        this.name = name;
    };

    /**
     * 设备具有的功能
     */
    public void turnOn(){
        System.out.println(name + "设备打开");
    }

    public void turnOff(){
        System.out.println(name + "设备关闭");
    }
}
