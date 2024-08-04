package com.yanghua.generator.main;

import java.io.*;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName JarGenerator.java
 * @Description TODO 使用 java 实现 maven命令调用，进行项目打包
 * @createTime 2024年08月04日 16:11:00
 */
public class JarGenerator {

    public static void doGenerate(String projectDir) throws IOException, InterruptedException {
        // 清理之前的构建并打包
        // 注意不同操作系统，执行的命令不同
        String winMavenCommand = "mvn.cmd clean package -DskipTests=true";
        String otherMavenCommand = "mvn clean package -DskipTests=true";
        String mavenCommand = winMavenCommand;

        // 这里一定要拆分！
        // 原因：若直接传入 winMavenCommand，则 Process 会将其当作一个完整字符串去执行，会报错；
        // 此处 先通过空格分割后，传入，它会自动进行空格拼接执行
        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));
        processBuilder.directory(new File(projectDir));

        Process process = processBuilder.start();

        // 读取命令的输出
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // 等待命令执行完成
        int exitCode = process.waitFor();
        System.out.println("命令执行结束，退出码：" + exitCode);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // 要打包的项目路径
        doGenerate("D:\\project\\code\\code-chameleon\\code-chameleon-maker\\generated\\acm-template-pro-generator");
    }
}
