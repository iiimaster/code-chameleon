package com.yanghua.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;
import picocli.CommandLine.*;

import java.io.File;
import java.util.List;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName ListCommand.java
 * @Description TODO list子命令：查看要生成的源文件的列表信息
 * @createTime 2024年07月21日 14:16:00
 */

@Command(name = "list", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{
    @Override
    public void run() {
        // 获取当前项目地址
        String projectPath = System.getProperty("user.dir");
        // 项目跟路径
        String parentPath = new File(projectPath).getParent();

        // 项目模板具体路径
        String inputPath = new File(parentPath +  File.separator + "code-chameleon-demo-projects"+ File.separator + "acm-template").getAbsolutePath();
        List<File> files = FileUtil.loopFiles(inputPath);
        System.out.println(files.isEmpty() ? "":"---------源文件路径start---------");
        for (File file : files) {
            System.out.println(file);
        }

        System.out.println(files.isEmpty() ? "":"---------源文件路径end---------");
    }
}
