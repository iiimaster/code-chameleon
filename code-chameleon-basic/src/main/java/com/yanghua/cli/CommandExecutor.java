package com.yanghua.cli;

import com.yanghua.cli.command.ConfigCommand;
import com.yanghua.cli.command.GeneratorCommand;
import com.yanghua.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.*;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName CommandExecutor.java
 * @Description TODO 绑定所有子命令，并 提供执行 命令的方法
 * @createTime 2024年07月21日 14:18:00
 */

@Command(name = "codeChameleon")
public class CommandExecutor implements Runnable{
    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new GeneratorCommand())
                .addSubcommand(new ListCommand());
    }
    @Override
    public void run() {
        System.out.println("请输入具体命令，或输入“--help”查看命令提示！");
    }

    /**
     * 执行命令
     * @param args
     * @return
     */
    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
