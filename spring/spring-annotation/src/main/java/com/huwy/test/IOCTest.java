package com.huwy.test;

import com.huwy.bean.Person;
import com.huwy.config.MainConfig;
import com.huwy.config.MainConfig2;
import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/17 10:40
 * <p>作者: huwy
 */
public class IOCTest {



    @Test
    public void test01() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("IOC容器创建完成。。。。");
        /*
        String [] definitionNames = context.getBeanDefinitionNames();

        for (int i = 0; i < definitionNames.length; i++) {
            System.out.println(definitionNames[i]);
        }*/

        Person person = (Person) context.getBean("person");

        Person person2 = (Person) context.getBean("person");


    }


    @Test
    public void test02() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        String [] definitionNames = context.getBeanDefinitionNames();

        for (int i = 0; i < definitionNames.length; i++) {
            System.out.println(definitionNames[i]);
        }

    }

    //验证@Conditional注解
    @Test
    public void test03() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        String [] namesForType = context.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = (ConfigurableEnvironment) context.getEnvironment();

        String property = environment.getProperty("os.name");
        System.out.println(property);

        for(String name : namesForType) {
            System.out.println(name);
        }

        Map<String, Person> persons = context.getBeansOfType(Person.class);

        System.out.println(persons);
    }

}
