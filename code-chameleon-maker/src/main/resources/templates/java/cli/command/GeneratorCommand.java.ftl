package ${basePackage}.cli.command;

import cn.hutool.core.bean.BeanUtil;
import ${basePackage}.generator.MainGenerator;
import ${basePackage}.model.DataModel;
import lombok.Data;
import picocli.CommandLine.*;

import java.util.concurrent.Callable;

/**
 * @author ${author}
 * @version 1.0.0
 * @ClassName GeneratorCommand.java
 * @Description TODO Generator子命令：生成指定文件
 */

@Command(name = "generate", mixinStandardHelpOptions = true)
@Data
public class GeneratorCommand implements Callable<Integer> {
<#list modelConfig.models as modelInfo>
    /**
     * ${modelInfo.description}
     */
    // 设置了 arity 参数，可选交互式,
    // echo = true: 用户输入是否可见
    @Option(names = {<#if modelInfo.abbr??>"-${modelInfo.abbr}", </#if>"--${modelInfo.fieldName}"}, arity = "0..1", <#if modelInfo.description??>description = "${modelInfo.description}", </#if>interactive = true, echo = true)
    private ${modelInfo.type} ${modelInfo.fieldName}<#if modelInfo.defaultValue??> = ${modelInfo.defaultValue?c}</#if>;
</#list>

    @Override
    public Integer call() throws Exception {
        DataModel dataModel = new DataModel();
        BeanUtil.copyProperties(this, dataModel);
        MainGenerator.doGenerate(dataModel);
        return 0;
    }
}
