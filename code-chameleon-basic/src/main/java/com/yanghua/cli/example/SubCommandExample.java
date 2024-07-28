package com.yanghua.cli.example;

import picocli.CommandLine;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import static picocli.CommandLine.*;

/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName SubCommandExample.java
 * @Description TODO 测试 子命令
 * @createTime 2024年07月21日 10:08:00
 */

@Command(name = "main", mixinStandardHelpOptions = true)
public class SubCommandExample implements Runnable{

    @Override
    public void run() {
        System.out.println("执行主命令");
    }

    @Command(name = "add", description = "新增", mixinStandardHelpOptions = true)
    static class addCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("执行新增（add）操作");
        }
    }

    @Command(name = "edit", description = "修改", mixinStandardHelpOptions = true)
    static class editCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("执行修改（add）操作");
        }
    }

    @Command(name = "del", description = "删除", mixinStandardHelpOptions = true)
    static class delCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("执行删除（del）操作");
        }
    }


    public static void main(String[] args) {
        // 执行主命令
        String[] myArgs = new String[] {};

        // 执行主命令帮助手册
        // myArgs = new String[] {"--help"};

        // 执行新增命令
        // myArgs = new String[] {"add"};

        // 执行新增命令的帮助手册
        // myArgs = new String[] {"add", "--help"};

        // 执行不存在的命令会报错
        // myArgs = new String[] {"query"};

        int execute = new CommandLine(new SubCommandExample())
                .addSubcommand(new addCommand())
                .addSubcommand(new editCommand())
                .addSubcommand(new delCommand())
                .execute(myArgs);

        System.out.println(execute);

        // todo 拓展：循环输入执行命令
        /*Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            System.out.print("请输入要执行的命令(exit 退出)：");
            String input = scanner.nextLine();
            if (input.equals("exit")){
                break;
            }

            new CommandLine(new SubCommandExample())
                    .addSubcommand(new addCommand())
                    .addSubcommand(new editCommand())
                    .addSubcommand(new delCommand())
                    .execute(input.split(" "));
            count++;
        }

        System.out.println("====>>>> 执行了" + count + "个命令！");*/
    }


}
