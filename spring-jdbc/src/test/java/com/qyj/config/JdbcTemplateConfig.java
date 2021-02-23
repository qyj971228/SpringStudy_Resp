package com.qyj.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("com.qyj")
@PropertySource("classpath:jdbc.properties")
public class JdbcTemplateConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Autowired
    @Qualifier("dataSource_Druid")
    private DataSource dataSource_Druid;

    @Autowired
    @Qualifier("dataSource_C3P0")
    private DataSource dataSource_C3P0;

    @Bean("dataSource_Druid")
    public DataSource getDataSource_Druid() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean("dataSource_C3P0")
    public DataSource getDataSource_C3P0() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean("jdbcTemplate_Druid")
    public JdbcTemplate getJdbcTemplate_Druid(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource_Druid);
        return jdbcTemplate;
    }

    @Bean("jdbcTemplate_C3P0")
    public JdbcTemplate getJdbcTemplate_C3P0(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource_C3P0);
        return jdbcTemplate;
    }

}
