package com.huwy.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/18 15:28
 * <p>作者: huwy
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("cat constructor.......");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat........destroy.......");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat..........afterPropertiesSet...........");
    }
}
