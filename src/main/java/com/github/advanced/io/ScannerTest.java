package com.github.advanced.io;

import java.util.Scanner;

/**
 * Scanner扫描控制台输入
 * Created by jiabin on 2018/5/16.
 */
public class ScannerTest {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入字符串：");
        while (true) {
            String line = s.nextLine();
            if (line.equals("exit")) break;
            System.out.println(">>>" + line);
        }
    }
}
