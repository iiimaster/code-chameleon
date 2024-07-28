package com.yanghua.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName staticGenerator.java
 * @Description TODO 静态文件生成器
 * @createTime 2024年07月06日 18:05:00
 */
public class StaticGenerator {
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
        // copyFilesByHotool(inputPath, outputPath);

        // 方式二：自己实现递归 调用，复制文件
        copyFilesByRecursive(inputPath, outputPath);


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

    /**
     * 方式二：
     * 自己实现递归拷贝文件
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByRecursive(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        // 进行文件拷贝
        try {
            copyFilesByRecursive(inputFile, outputFile);
        } catch (IOException e) {
            System.out.println("文件复制失败");
            e.printStackTrace();
        }

    }

    /**
     * 递归处理 创建文件、文件夹
     * @param inputFile 源文件/文件夹
     * @param outputFile 输出文件/ 文件夹
     */
    public static void copyFilesByRecursive(File inputFile, File outputFile) throws IOException {
        // 判断是不是文件夹
        // 是文件夹 遍历文件夹（继续递归），不是文件夹，拷贝文件
        if (inputFile.isDirectory()) {
            System.out.println(inputFile.getName());

            File destOutputFile = new File(outputFile, inputFile.getName());

            // 判断 文件夹 是否 存在，不存在则创建
            if (!destOutputFile.exists()) {
                destOutputFile.mkdirs();
            }

            // 获取文件夹 子目录
            File[] files = inputFile.listFiles();

            // 没有子目录, 返回
            if (ArrayUtil.isEmpty(files)) {
                return;
            }

            // 有子目录，递归处理
            for (File file : files) {
                copyFilesByRecursive(file, destOutputFile);
            }
        } else {
            // 是文件，直接拷贝到目标目录下
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
