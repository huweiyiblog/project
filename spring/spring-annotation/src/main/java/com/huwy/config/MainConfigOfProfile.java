package com.huwy.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/19 14:18
 * <p>作者: huwy
 * profile:
 *    spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能。
 *    开发环境、测试环境、生产环境
 *    1)加上环境标识的bean，只有这个环境被激活的时候才能注册到容器中，默认是default环境
 *    2）@profile写在配置类上，只有时指定的环境的时候，整个配置类里面的所有配置才能开始生效
 *
 */
@PropertySource("db/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private String password;

    private String jdbcUrl;

    private String driverClass;


   private StringValueResolver valueResolver;


    //测试数据源
    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(jdbcUrl);
        try {
            dataSource.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    //开发数据源
    @Profile("dev")
    @Bean("DevDataSource")
    public DataSource dataSourceDev() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(jdbcUrl);
        try {
            dataSource.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    //生产数据源
    @Profile("prod")
    @Bean("ProdDataSource")
    public DataSource dataSourceProd() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(jdbcUrl);
        try {
            dataSource.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }


    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;
        password = valueResolver.resolveStringValue("${db.password}");
        jdbcUrl = valueResolver.resolveStringValue("${db.jdbcUrl}");
        driverClass = valueResolver.resolveStringValue("${db.driverClass}");
    }
}
