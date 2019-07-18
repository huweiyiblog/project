package com.huwy.config;

import com.huwy.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/18 17:27
 * <p>作者: huwy
 */


/**
 * 使用@Value赋值：
 * 1.基本数值  @Value("张三")
 * 2.可以谢SpEL:#{}   @Value("#{20-2}")
 * 3.可以写${};取出配置文件【properties】中的值（在运行环境变量的值）
 * 使用注解方式加载properties文件。
 * @PropertySource(value = {"classpath:person.properties"}, encoding = "utf-8")
 */
@PropertySource(value = {"classpath:person.properties"}, encoding = "utf-8")
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Person person() {
        return new Person();
    }
}
