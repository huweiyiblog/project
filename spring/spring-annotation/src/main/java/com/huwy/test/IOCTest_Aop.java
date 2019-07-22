package com.huwy.test;

import com.huwy.aop.MathCalculator;
import com.huwy.config.MainConfigOfAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/19 14:50
 * <p>作者: huwy
 */
public class IOCTest_Aop {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAop.class);

       MathCalculator mathCalculator = (MathCalculator) context.getBean("mathCalculator");

       mathCalculator.div(1, 1);
    }
}
