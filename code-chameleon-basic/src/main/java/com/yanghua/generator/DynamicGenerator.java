package com.yanghua.generator;

import com.yanghua.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName DynamicGenerator.java
 * @Description TODO 动态 文件生成器
 * @createTime 2024年07月07日 20:12:00
 */
public class DynamicGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

        // 1、获取输入目录(源路径)
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        // 2、获取输出目录
        String outputPath = projectPath + File.separator + "MainTemplate.java";

        // 3、设置 动态替换的 数据（对象）
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yanghua");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");

        // 4、调用 生成文件
        doGenerate(inputPath, outputPath, mainTemplateConfig);

    }

    /**
     * 生成文件
     *
     * @param inputPath 模板文件输入路径
     * @param outputPath 输出路径
     * @param model 数据模型
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 1、创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        // 2、创建数据模型
        // MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        // mainTemplateConfig.setAuthor("yupi");
        // mainTemplateConfig.setLoop(false);
        // mainTemplateConfig.setOutputText("求和结果：");

        // 3、生成
        Writer out = new FileWriter(outputPath);
        template.process(model, out);

        // 生成文件后别忘了关闭哦
        out.close();
    }
}
