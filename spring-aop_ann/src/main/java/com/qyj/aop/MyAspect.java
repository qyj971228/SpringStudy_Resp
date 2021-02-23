package com.qyj.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect //标注当前Aspect是一个切面
public class MyAspect {

    /**
     * 定义切点表达式
     */
    @Pointcut("execution(public void com.qyj.aop.Target.save())")
    public void pointcut(){}

    @Before("MyAspect.pointcut()")
    public void before(){
        System.out.println("前置增强");
    }
    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("后置增强");
    }
    @Around("pointcut()")
    //Proceeding JoinPoint: 正在执行的连接点
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强");
        Object obj = pjp.proceed();//切点方法
        System.out.println("环绕后增强");
        return obj;
    }
    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        System.out.println("异常增强");
    }
    @After("pointcut()")
    public void after(){
        System.out.println("最终增强");
    }

}
