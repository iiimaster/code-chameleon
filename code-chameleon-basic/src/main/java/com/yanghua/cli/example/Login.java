package com.yanghua.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName Login.java
 * @Description TODO 命令行框架实现 登录、注册
 * @createTime 2024年07月09日 21:00:00
 */
public class Login implements Callable<Integer> {

    // 设置了 arity 参数，可选交互式
    @Option(names = {"-u", "--username"}, description = "用户名")
    String username;

    // 设置了 required = true 参数，强制交互式
    @Option(names = {"-p", "--password"}, description = "密码", required = true)
    String password;

    // 设置了 arity 参数，可选交互式
    @Option(names = {"-cp", "--checkPassword"}, arity = "0..1", description = "确认密码", interactive = true)
    String checkPassword;

    @Override
    public Integer call() throws Exception {
        // 若用户没有 确认密码，则提示并等待用户输入
        if (checkPassword == null && System.console() != null) {
            // 主动提示用户输入
            checkPassword = System.console().readLine("Enter value for --interactive: ");
        }
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        // 1、用户传递 完整参数 与 值， 没有任何问题
        // new CommandLine(new Login()).execute("-u","yanghua","-p","123","-cp","456");

        // 2、用户 传递 -p -cp 参数，不传递值， 会报错：Expected parameter for option '--password' but found '-cp'
        // 原因：password 设置了必填属性（required = true）
        // new CommandLine(new Login()).execute("-u","yanghua", "-p", "-cp");

        // 3、用户 不传递 -p -cp 参数， 不传递值（传递-cp，不传值）
        // 发现      未传递的 -p 会报错 “Missing required option: '--checkPassword'”;
        //              原因：该参数上设置了必填属性（required = true）
        //          未传递的 -cp 没报错，
        //              原因：checkPassword 为 可选交互式（arity = "0..1", interactive = false）
        // new CommandLine(new Login()).execute("-u","yanghua");

        // 4、传递了 -p 及 值123，传递了 -cp，由于在call函数中定义了判空，会校验引导用户输入；
        // 若 不传递 -cp 则不会 提示用户确认密码，因为 checkPassword 为 可选交互式
        new CommandLine(new Login()).execute("-u", "yanghua1", "-p", "123", "-cp");
    }
}
