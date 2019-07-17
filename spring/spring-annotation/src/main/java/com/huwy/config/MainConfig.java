package com.huwy.config;

import com.huwy.bean.Person;
import com.huwy.condition.LinuxCondition;
import com.huwy.condition.WindowCondition;
import com.huwy.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/16 17:15
 * <p>作者: huwy
 */
@Configuration   //告诉spring这是一个配置类（相当于配置类）
/**
 * value：指定要扫描的包
 * excludeFilters = filter[] 指定扫描的时候按照什么规则排除那些组件
 * includeFilters = filter[] 指定扫描的时候只需要包含那些组建，要配合禁用默认过滤规则（useDefaultFilters=false）
 * 备注：jdk8以上可以定义多个@componentScan注解，如果是jdk8以下的可以用@componentSans来定义（这是一个数组）, @componentSans注解在4.1.1是没有的。
 * demo:@ComponentScan(value = "com.huwy", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class, Service.class})})
 */
@ComponentScans(
        value = {
                @ComponentScan(value = "com.huwy",
                        includeFilters = {
                            @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class}),
                            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {BookService.class})
                        },
                        useDefaultFilters = false)
        }
)
public class MainConfig {


    /** 1) 给容器注册一个bean,类型为返回值类型，id默认是用方法名做为id
     *   * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * 	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     * 	 2)prototype :多实例的：ioc容器启动并不会去调用方法创建对象放入容器中，每次获取的时候才会调用方法创建对象。
     * 	 3）singleton : 单实例的（默认值）：IOC容器启动会调用方法创建对象放入IOC容器中。以后每次获取就是直接从容器中获取。
     * 	 4）request: 同一次请求创建一个实例
     * 	 5）session: 同一个session创建一个实例
     */
    @Scope(value = "singleton")
    @Bean
    public Person person() {
        System.out.println("往容器中添加............");
        Person person = new Person("huwy", 12);
        return person;
    }


    @Conditional({WindowCondition.class})
    @Bean("bill")
    public Person person2() {
        Person person = new Person("bill", 62);
        return person;
    }

    @Conditional({LinuxCondition.class})
    @Bean("linux")
    public Person person3() {
        Person person = new Person("linux", 48);
        return person;
    }


}
