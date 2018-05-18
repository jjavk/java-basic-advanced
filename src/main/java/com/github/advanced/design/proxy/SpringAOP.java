package com.github.advanced.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by jiabin on 2018/5/16.
 */
public class SpringAOP implements InvocationHandler {
    Object target;

    public SpringAOP(Object target) {
        this.target = target;
    }

    /**
     * SpingAOP在使用JDK代理下的原理。
     * AfterReturningAdvice和AfterThrowingAdvice只能被执行一个
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // BeforeAdvice
        Object retVal = null;
        try {
            // AroundAdvice
            retVal = method.invoke(target, args);
            // AroundAdvice
            // AfterReturningAdvice
        }
        catch (Throwable e) {
            // AfterThrowingAdvice
        }
        finally {
            // AfterAdvice
        }
        return retVal;
    }
}
