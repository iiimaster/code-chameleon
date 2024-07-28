package com.yanghua.cli.example;

import picocli.CommandLine;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName ASCIIArt.java
 * @Description TODO 命令行开发框架 - Picocli
 * @createTime 2024年07月09日 20:32:00
 */

/*
解释：
1.创建一个实现Runnable或callable接口的类,这就是一个命令。
2.使用@Command注解标记该类并为其命名,mixinStandardHelpoptions属性设置为真实可以给应用程序自动添加选帮助和——版本项。
3.通过@Option注解将字段设置为命令行选项,可以给选项设置名称和描述。
4.通过@ phase注解将字段设置为命令行参数,可以指定默认值,描述等信息。
5.Picodli会将命令行参数转换为强类型值,并自动注入到注解字段中。
6.在类的 run 或 call方法中定义业务逻辑,当命令解析成功(用户敲了回车)后被调用。
7.在main方法中,通过CommandLine对象的execute方法来处理用户输入的命令,剩下的就交给Picocli框架来解析命 令并执行业务逻辑啦~
8.CommandLine.execute方法返回一个退出代码。可以调用System.exit并将该退出代码作为参数,从而向调用进程表示 成功或失败。
 */
@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
public class ASCIIArt implements Runnable {
    @Option(names = { "-s", "--font-size" }, description = "单词长度")
    int fontSize = 19;

    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = { "Hello,", "picocli" };

    @Override
    public void run() {
        // 自己实现业务逻辑
        System.out.println("fontSize = " + fontSize);
        System.out.println("words = " + String.join(",", words));
    }

    public static void main(String[] args) {
        // 方式二：直接传参 -s 12 yanghua good
        //int exitCode = new CommandLine(new ASCIIArt()).execute("-s", "10", "hello", "word");

        // 方式一：改变args初始值为 -s 12 yanghua good
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);
        System.exit(exitCode);
    }
}
