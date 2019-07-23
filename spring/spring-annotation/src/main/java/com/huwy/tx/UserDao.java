package com.huwy.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/23 14:47
 * <p>作者: huwy
 */
@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public void insert() {
        String sql = "insert into user(username, age) values (?, ?)";
        jdbcTemplate.update(sql, "admin", 18);
    }
}
