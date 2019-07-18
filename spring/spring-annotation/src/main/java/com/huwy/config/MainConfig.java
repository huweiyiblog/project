package com.huwy.config;

import com.huwy.bean.Person;
import com.huwy.bean.Red;
import com.huwy.condition.LinuxCondition;
import com.huwy.condition.MyImportBeanDefinitionRegistrar;
import com.huwy.condition.MyImportSelector;
import com.huwy.condition.WindowCondition;
import com.huwy.bean.ColorFactory;
import com.huwy.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/16 17:15
 * <p>作者: huwy
 */


//@Configuration告诉spring这是一个配置类（相当于配置类）
/************************************************************/
/**
 * @ComponentScans：
 * value：指定要扫描的包
 * excludeFilters = filter[] 指定扫描的时候按照什么规则排除那些组件
 * includeFilters = filter[] 指定扫描的时候只需要包含那些组建，要配合禁用默认过滤规则（useDefaultFilters=false）
 * @componentSans注解在4.1.1是没有的。
 * demo:@ComponentScan(value = "com.huwy", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class, Service.class})})
 */
/***********************************************************/
/**
 * @Import:
 *   1)@Import(要导入到容器中组件)，容器中就会自动注册这个组件，id默认是全类名
 *   2）importSelector: 返回需要导入的组件的全类名数组，所有实现类需要继承importSelector接口。例子参考：MyImportSelector
 *   3) ImportBeanDefinitionRegistrar：手动注册bean到容器中
 */
@Configuration
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
@Import({Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
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

    /**
     * 使用spring 提供的factoryBean 给容器注入bean
     * 1)、默认获取到时工厂bean调用getObject创建的对象
     * 2）、要获取工厂bean本身，我们需要给ID前面加入一个&
     * @return
     */
    @Bean
    public ColorFactory colorFactory() {
        return new ColorFactory();
    }


}
