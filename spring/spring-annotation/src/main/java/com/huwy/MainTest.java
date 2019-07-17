package com.huwy;

import com.huwy.bean.Person;
import com.huwy.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/16 15:49
 * <p>作者: huwy
 */
public class MainTest {

    public static void main(String[] args) {
        ApplicationContext context =  new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println(person);

        String [] nameForType = context.getBeanNamesForType(Person.class);
        for (int i = 0; i < nameForType.length; i++) {
            System.out.println(nameForType[i]);
        }
    }
}
