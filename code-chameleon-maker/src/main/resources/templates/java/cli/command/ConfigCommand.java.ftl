package ${basePackage}.cli.command;

import cn.hutool.core.util.ReflectUtil;
import ${basePackage}.model.DataModel;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;

/**
 * @author ${author}
 * @version 1.0.0
 * @ClassName ConfigCommand.java
 * @Description TODO Config子命令：查看允许用户传入的动态参数信息
 */
@Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{

    @Override
    public void run() {
        System.out.println("查看参数信息");
        // 方式一：
        /*Class<MainTemplateConfig> configClass = MainTemplateConfig.class;
        Field[] fields = configClass.getFields();*/

        // 方式二
        Field[] fields = ReflectUtil.getFields(DataModel.class);
        for (Field field : fields) {
            System.out.println("字段名称：" + field.getName());
            System.out.println("字段类型：" + field.getType());
            System.out.println("---");
        }
    }
}
