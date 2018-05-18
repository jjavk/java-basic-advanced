package com.github.advanced.design.strategy;

/**
 * 客户端
 * Created by jiabin on 2018/5/16.
 */
public class Client {
    //持有具体策略的对象
    private Strategy strategy;

    /**
     * 构成函数传入策略对象
     * @param strategy
     */
    public Client(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 策略方法
     */
    public void contextInterface(){
        strategy.strategyInterface();
    }
}
