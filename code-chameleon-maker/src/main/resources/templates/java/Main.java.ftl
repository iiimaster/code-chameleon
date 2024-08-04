package ${basePackage};

import ${basePackage}.cli.CommandExecutor;

/**
 * @author ${author}
 * @version 1.0.0
 * @Description TODO 执行命令入口类
 */

public class Main {
    public static void main(String[] args) {

        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}