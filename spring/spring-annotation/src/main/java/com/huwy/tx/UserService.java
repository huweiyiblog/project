package com.huwy.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/23 14:47
 * <p>作者: huwy
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Transactional
    public void insert() {
        userDao.insert();
        System.out.println("插入完成...........");
        int n = 1/0;
    }
}
