package com.huwy.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * <p>描述:
 *   1）给方法上标注@Transacational表示当前方法是是一个事务方法
 *   2）@EnableTransactionManagement 开启基于注解的事务管理功能
 *   3）配置事务管理在容器中
 *   @Bean
 *     public PlatformTransactionManager transactionManager() throws PropertyVetoException {
 *         return new DataSourceTransactionManager(dataSource());
 *     }
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/23 14:38
 * <p>作者: huwy
 */
@EnableTransactionManagement
@PropertySource("db/dbconfig.properties")
@ComponentScan("com.huwy.tx")
@Configuration
public class TxConfig {

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String password;

    @Value("${db.jdbcUrl}")
    private String jdbcUrl;

    @Value("${db.driverClass}")
    private String driverClass;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return  jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
