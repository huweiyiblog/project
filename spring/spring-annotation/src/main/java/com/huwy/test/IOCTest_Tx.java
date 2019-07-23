package com.huwy.test;

import com.huwy.tx.TxConfig;
import com.huwy.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/23 14:57
 * <p>作者: huwy
 */
public class IOCTest_Tx {

    @Test
    public  void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = (UserService) context.getBean("userService");

        userService.insert();

    }
}
