package ${basePackage}.model;

import lombok.Data;

/**
* @author ${author}
* @version ${version}
* @Description TODO 动态模板配置：用于 动态生成 DataModel.java.ftl 文件
*/

@Data
public class DataModel {

<#list modelConfig.models as modelInfo>
    <#if modelInfo.description??>
    /**
    * ${modelInfo.description}
    */
    </#if>
<#--    ?c 作用：将布尔类型转化为字符串 -->
    private ${modelInfo.type} ${modelInfo.fieldName} <#if modelInfo.defaultValue??> = ${modelInfo.defaultValue?c}</#if>;

</#list>

}
