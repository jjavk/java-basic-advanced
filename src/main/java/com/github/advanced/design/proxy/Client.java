package com.github.advanced.design.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by jiabin on 2018/5/16.
 */
public class Client {
    public static void main(String[] args) {
        Subject real = new RealSubject();

        /**
         * 代理对象proxySubject的类型为”com.sun.proxy.$Proxy0”并继承自java.lang.reflect.Proxy
         * 单继承的关系，所以不能代理类，只能代理接口
         */
        Subject proxySubject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(),
                new Class[]{Subject.class}, new ProxyHandler(real));

        proxySubject.doSomething();
    }
}


/*
package com.sun.proxy;

import com.youku.zixu.api.HelloService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

// JDK动态代理生成的代理类继承于父类Proxy
public final class $Proxy0 extends Proxy
  implements HelloService {

  private static Method m1;
  private static Method m3;
  private static Method m2;
  private static Method m0;

  // 构造函数
  public $Proxy0(InvocationHandler paramInvocationHandler){
    super(paramInvocationHandler);
  }

  public final boolean equals(Object paramObject){
    try{
      return ((Boolean)this.h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
    }catch (Error|RuntimeException localError){
      throw localError;
    }catch (Throwable localThrowable){
      throw new UndeclaredThrowableException(localThrowable);
    }
  }

  public final String doSomething(){
    try{
      return (String)this.h.invoke(this, m3, new Object[] { });
    }catch (Error|RuntimeException localError){
      throw localError;
    }catch (Throwable localThrowable){
      throw new UndeclaredThrowableException(localThrowable);
    }
  }

  public final String toString(){
    try{
      return (String)this.h.invoke(this, m2, null);
    }catch (Error|RuntimeException localError){
      throw localError;
    }catch (Throwable localThrowable){
      throw new UndeclaredThrowableException(localThrowable);
    }
  }

  public final String hello(String paramString){
    try{
      return (String)this.h.invoke(this, m4, new Object[] { paramString });
    }catch (Error|RuntimeException localError){
      throw localError;
    }catch (Throwable localThrowable){
      throw new UndeclaredThrowableException(localThrowable);
    }
  }

  public final int hashCode(){
    try{
      return ((Integer)this.h.invoke(this, m0, null)).intValue();
    }catch (Error|RuntimeException localError){
      throw localError;
    }catch (Throwable localThrowable){
      throw new UndeclaredThrowableException(localThrowable);
    }
  }

  static{
    try{
      m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[] { Class.forName("java.lang.Object") });
      m3 = Class.forName("com.github.advanced.design.proxy.Subject").getMethod("doSomething", new Class[] { });
      m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
      m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
      return;
    }catch (NoSuchMethodException localNoSuchMethodException){
      throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
    }catch (ClassNotFoundException localClassNotFoundException){
      throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
    }
  }
}
 */
