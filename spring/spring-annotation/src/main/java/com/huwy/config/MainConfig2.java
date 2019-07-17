package com.huwy.config;

import com.huwy.bean.Person;
import com.huwy.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/16 17:15
 * <p>作者: huwy
 */
@Configuration   //告诉spring这是一个配置类（相当于配置类）
public class MainConfig2 {

    //给容器注册一个bean,类型为返回值类型，id默认是用方法名做为id
    @Bean()
    public Person person() {
        Person person = new Person("huwy", 12);
        return person;
    }
}
