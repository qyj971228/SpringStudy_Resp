package com.qyj.proxy.jkd;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {

        //创建目标对象
        final Target target = new Target();

        //增强对象
        final Advice advice = new Advice();

        //返回值 就是动态生成的代理对象 基于jdk
        //因为使用jdk的方式,所以返回值使用接口接收
        TargetInterface proxy = (TargetInterface)Proxy.newProxyInstance(
                target.getClass().getClassLoader(),//目标对象类加载器
                target.getClass().getInterfaces(),//目标对象相同的接口字节码对象数组
                new InvocationHandler() {//调用代理对象的任何方法 实质执行的都是invoke方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();//前置增强
                        Object invoke = method.invoke(target, args);//执行目标方法
                        advice.after();//后置增强
                        return invoke;
                    }
                });

        //调用代理对象的方法
        proxy.save();
    }
}
