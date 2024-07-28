package com.yanghua.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.yanghua.model.MainTemplateConfig;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName ConfigCommand.java
 * @Description TODO Config子命令：查看允许用户传入的动态参数信息
 * @createTime 2024年07月21日 14:15:00
 */
@Command(name = "config", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{

    @Override
    public void run() {
        // 方式一：
        /*Class<MainTemplateConfig> configClass = MainTemplateConfig.class;
        Field[] fields = configClass.getFields();*/

        // 方式二
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段名称：" + field.getName());
            System.out.println("字段类型：" + field.getType());
            System.out.println("---");
        }
    }
}
