package com.github.advanced.design.proxy;

/**
 * Created by jiabin on 2018/5/16.
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("do something!");
    }
}
