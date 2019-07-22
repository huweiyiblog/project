package com.huwy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/22 10:24
 * <p>作者: huwy
 */
@Aspect
public class LogAspect {

    @Pointcut("execution(public int com.huwy.aop.MathCalculator.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object [] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"方法， 参数：【"+ Arrays.asList(args) +"】");
    }

    @After("pointCut()")
    public  void logEnd(JoinPoint joinPoint) {
        Object [] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"方法， 参数：【"+ Arrays.asList(args) +"】");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        Object [] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"方法， 参数：【"+ Arrays.asList(args) +"】");
    }

    @AfterThrowing(value="pointCut()",throwing="exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(""+joinPoint.getSignature().getName()+"异常。。。异常信息：{"+exception+"}");
    }
}
