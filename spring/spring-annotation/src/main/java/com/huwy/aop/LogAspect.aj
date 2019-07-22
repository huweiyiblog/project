package com.huwy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspect {

    @Pointcut("execution(* com.huwy.aop.MathCalculator.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void logStart(JoinPoint joinPoint) {
        Object [] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"方法， 参数：【"+ Arrays.asList(args) +"】");
    }

    @After("pointcut()")
    public  void logEnd(JoinPoint joinPoint) {
        Object [] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"方法， 参数：【"+ Arrays.asList(args) +"】");
    }

   /* @AfterReturning(value = "pointcut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        Object [] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"方法， 参数：【"+ Arrays.asList(args) +"】");
    }*/


}
