package com.yanghua.generator;

import com.yanghua.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName MainGenerator.java
 * @Description TODO 核心生成器：动态、静态文件生成
 * @createTime 2024年07月07日 20:26:00
 */
    public class MainGenerator {
        public static void main(String[] args) throws TemplateException, IOException {
            MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
            mainTemplateConfig.setAuthor("yanghua");
            mainTemplateConfig.setLoop(false);
            mainTemplateConfig.setOutputText("求和结果：");

            doGenerate(mainTemplateConfig);
        }


        /**
         * 对代码模板 进行 填坑
         * @param model 参数值
         * @throws TemplateException
         * @throws IOException
         */
        public static void doGenerate(Object model) throws TemplateException, IOException {
            // 获取当前相对路径（文件夹名称）
            String projectPath = System.getProperty("user.dir");
            // System.out.println(projectPath);

            // 获取父文件夹路径
            File parentFile = new File(projectPath).getParentFile();

            // 输入路径（源路径）
            String inputPath = new File(parentFile, "code-chameleon-demo-projects/acm-template").getAbsolutePath();
            // 输出文件路径
            String outputPath = parentFile.getPath();

            // 1、生成静态文件
            StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

            // 2、生成动态文件
            // 动态文件 源模板文件地址
            String inputDynamicFilePath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
            String outputDynamicFilePath = outputPath + File.separator + "acm-template/src/com/yanghua/acm/MainTemplate.java";
            // 生成的动态文件地址
            DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);

        }
    }
