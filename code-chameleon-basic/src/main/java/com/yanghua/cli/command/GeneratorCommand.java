package com.yanghua.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.yanghua.generator.MainGenerator;
import com.yanghua.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;
import picocli.CommandLine.*;

import java.util.concurrent.Callable;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName GeneratorCommand.java
 * @Description TODO Generator子命令：生成指定文件
 * @createTime 2024年07月21日 14:16:00
 */

@Command(name = "generate", mixinStandardHelpOptions = true)
@Data
public class GeneratorCommand implements Callable<Integer> {
    /**
     * 是否生成循环
     */
    // 设置了 arity 参数，可选交互式,
    // echo = true: 用户输入是否可见
    @Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否生成循环", interactive = true, echo = true)
    private boolean loop;

    /**
     * 作者注释
     */
    @Option(names = {"-a", "--author"}, arity = "0..1", description = "作者注释", interactive = true, echo = true)
    private String author = "yanghua";

    /**
     * 输出信息
     */
    @Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出信息", interactive = true, echo = true)
    private String outputText = "sum = ";

    @Override
    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        System.out.println("配置信息：" + mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}
