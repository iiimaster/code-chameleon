package com.yanghua.model;

import lombok.Data;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName MainTemplateConfig.java
 * @Description TODO 动态模板配置：用于 动态生成 MainTemplate.java.ftl 文件
 * @createTime 2024年07月07日 20:08:00
 */

@Data
public class MainTemplateConfig {

    /**
     * 是否生成循环
     */
    private boolean loop;

    /**
     * 作者注释
     */
    private String author = "yupi";

    /**
     * 输出信息
     */
    private String outputText = "sum = ";
}
