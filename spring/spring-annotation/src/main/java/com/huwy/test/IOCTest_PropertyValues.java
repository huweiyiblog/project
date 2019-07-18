package com.huwy.test;

import com.huwy.bean.Person;
import com.huwy.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/18 17:29
 * <p>作者: huwy
 */
public class IOCTest_PropertyValues {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);


    @Test
    public void test01() {
        printDefinition(context);
        Person person = (Person) context.getBean("person");
        System.out.println(person.toString());
    }



    public void printDefinition(ApplicationContext context) {
        String [] definitionNames = context.getBeanDefinitionNames();

        for (int i = 0; i < definitionNames.length; i++) {
            System.out.println(definitionNames[i]);
        }
    }
}
