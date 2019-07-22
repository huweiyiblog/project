package com.huwy.test;

import com.huwy.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/19 14:50
 * <p>作者: huwy
 */
public class IOCTest_Profile {

    @Test
    public void test01() {
       /* AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);*/

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(MainConfigOfProfile.class);
        context.refresh();
        String [] nameTypes = context.getBeanNamesForType(DataSource.class);

        for (int i = 0; i < nameTypes.length; i++) {
            System.out.println(nameTypes[i]);
        }




    }
}
