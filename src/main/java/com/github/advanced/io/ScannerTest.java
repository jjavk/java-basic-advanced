package com.github.advanced.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Scanner扫描控制台输入
 * Created by jiabin on 2018/5/16.
 */
public class ScannerTest {
    public static void main(String[] args) throws Exception{
        test7();
    }

    /**
     * 扫描控制台输入
     */
    public static void test1() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入字符串：");
        while (true) {
            String line = s.nextLine();
            if (line.equals("exit")) break;
            System.out.println(">>>" + line);
        }
    }

    /**
     * Scanner 默认使用空格作为分隔符来分隔文本，但允许我们通过使用方法useDelimiter(String pattern)指定新的分隔符。
     * pattern是一个正则表达式字符串，若想指定多个分隔符来分割，须使用”|”将它们隔开。
     */
    public static void test2() {
        Scanner s = new Scanner("123 asdf sd 45 789 sdf asdfl,sdf.sdfl,asdf    ......asdfkl    las");
        s.useDelimiter(" |,|\\.");    // 将使用空格，逗号和点号来分割Scanner输入
        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }

    /**
     * nextLine特点：
     * 以行（回车）读取，每在控制台输入三行则打印一次；不够三行，则阻塞等待
     * 以行读取，每敲一次回车键读取一次，不会忽略空格
     */
    public static void test3() {
        Scanner scanner = new Scanner(System.in);
        while (true) {      // scanner 不断从控制台读取，若无内容，则阻塞等待

            // 以行读取
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String s3 = scanner.nextLine();

            System.out.println(">>>" + s1);
            System.out.println(">>>" + s2);
            System.out.println(">>>" + s3);
        }
    }

    /**
     * 和test3一样
     */
    public static void test4() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {        // 一旦控制台有输入，scanner就开始从控制台读取

            // 以行读取
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String s3 = scanner.nextLine();

            System.out.println(">>>" + s1);
            System.out.println(">>>" + s2);
            System.out.println(">>>" + s3);
        }
    }

    /**
     * next特点：
     * 默认以一个或多个空格作为分割符来分隔行文本,每三个作为一组输出一次（不够三个则阻塞等待，直到够三个才作为一组进行输出）;
     * 此外，连续输入三行（每行一个）也可以。
     *
     */
    public static void test5() {
        Scanner scanner = new Scanner(System.in);
        while (true) {   // scanner 不断从控制台读取，若无内容，则阻塞等待
            String s1 = scanner.next();
            String s2 = scanner.next();
            String s3 = scanner.next();
            System.out.println(">>>" + s1);
            System.out.println(">>>" + s2);
            System.out.println(">>>" + s3);
        }
    }

    /**
     * 和test6一样
     */
    public static void test6() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {    // 一旦控制台有输入，scanner就开始从控制台读取
            String s1 = scanner.next();
            String s2 = scanner.next();
            String s3 = scanner.next();
            System.out.println(">>>" + s1);
            System.out.println(">>>" + s2);
            System.out.println(">>>" + s3);
        }
    }

    /**
     * Scanner 扫描文件输入
     * @throws FileNotFoundException
     */
    public static void test7() throws FileNotFoundException {
        InputStream in = new FileInputStream(new File("/Users/jiabin/.bash_profile")); // 创建文件输入流
        Scanner s = new Scanner(in);
        while(s.hasNextLine()){
            System.out.println(s.nextLine());
        }
    }
}

/*
delimiter()
　　返回此 Scanner 当前正在用于匹配分隔符的 Pattern。

hasNext()
　　判断扫描器中当前扫描位置后是否还存在下一段，默认以一个或多个连续的空格作为段的分隔符。

hasNextLine()
　　如果在此扫描器的输入中存在另一行（以回车作为”分行符”），则返回 true。

next()
　　查找并返回来自此扫描器的下一个完整标记（取得输入段）。

nextLine()
　　此扫描器执行当前行，并返回跳过的输入信息(取得输入行文本)。
*/


/*
nextLine()：以回车作为换行标志；

next() ：以一个或多个空格作为分段标志，也可以以回车作为分段标志
*/