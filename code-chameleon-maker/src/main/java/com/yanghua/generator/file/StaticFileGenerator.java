package com.yanghua.generator.file;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName staticGenerator.java
 * @Description TODO 静态文件生成器
 * @createTime 2024年07月06日 18:05:00
 */
public class StaticFileGenerator {
    public static void main(String[] args) {

        // 1、获取 要生成的目录地址
        String projectPath = System.getProperty("user.dir");
        // 由于生成目录位置不在项目根目录，故需要调整文件位置
        File parentFile = new File(projectPath).getParentFile();
        // System.out.println(parentFile.getPath());
        String outputPath = parentFile.getPath();

        // 2、获取 源文件地址
        String inputPath = outputPath + File.separator + "code-chameleon-demo-projects" + File.separator + "acm-template";
        // System.out.println(inputPath);

        // 方式一：使用hutool文件复制工具类
        copyFilesByHotool(inputPath, outputPath);

    }

    /**
     * 方式一：
     * 存在问题：不够灵活，无法排除 不需要复制的文件
     * 拷贝文件（hotool 实现. 会将输入的目录完整拷贝到输出目录下）
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     */
    public static void copyFilesByHotool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }

}
