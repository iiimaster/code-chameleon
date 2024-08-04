package ${basePackage}.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;
import picocli.CommandLine.*;

import java.io.File;
import java.util.List;

/**
 * @author ${author}
 * @version 1.0.0
 * @ClassName ListCommand.java
 * @Description TODO list子命令：查看要生成的源文件的列表信息
 */

@Command(name = "list", description = "查看文件列表", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{
    @Override
    public void run() {

        // 项目模板具体路径
        String inputPath = "${fileConfig.inputRootPath}";
        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files) {
            System.out.println(file);
        }
    }
}
