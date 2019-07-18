package com.huwy.config;

import com.huwy.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>描述: bean的生命周期
 *    bean创建--初始化--销毁的过程
 *    容器管理bean的生命周期;
 *    我们可以自定义初始化和销毁方法：容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 *    1)指定初始化和销毁方法
 *     a)通过@Bean指定init-method 和 destroy-method
 *     b)通过让bean实现InitializingBean(定义初始化逻辑)，DisposableBean（定义销毁逻辑）两个接口
 *     c)BeanPostProcessor【interface】:bean的后置处理器。在bean初始化前后进行一些处理工作。
 *     postProcessBeforeInitialization 初始化之前工作
 *     postProcessAfterInitialization  初始化之后工作
 *
 *
 *    初始化：
 *          对象创建好，并复制好，调用初始化方法。。。
 *    销毁：
 *          单实例：容器关闭的时候
 *          多实例：容器不会管理这个bean，容器不会调用销毁方法。
p>日期: 2019/7/18 14:59
 * <p>作者: huwy
 */
@ComponentScan(value = "com.huwy.bean")
@Configuration
public class MainConfigOfLifeCycle {



    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
