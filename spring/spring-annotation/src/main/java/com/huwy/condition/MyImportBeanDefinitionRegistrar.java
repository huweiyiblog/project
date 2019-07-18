package com.huwy.condition;

import com.huwy.bean.Blue;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/18 10:57
 * <p>作者: huwy
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /*
     * AnnotationMetadata : 当前类的注解信息
     * BeanDefinitionRegistry ：BeanDefinition注册类；
     *           把所有需要添加到容器中的bean：调用BeanDefinitionRegistry.registerBeanDefinition手工注册进来。
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //判断是否存在blue组件
       boolean definition = registry.containsBeanDefinition("blue");

       if (!definition) {
           RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Blue.class);
           registry.registerBeanDefinition("blue", rootBeanDefinition);
       }
    }
}
