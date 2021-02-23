package com.qyj.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JdbcTemplateTest {

    /**
     * 测试JdbcTemplate开发步骤
     */
    @Test
    public void test1() throws PropertyVetoException {
        //创建数据源对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/login?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("DBJdedi2gehao");

        //设置数据源对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        int row = jdbcTemplate.update("insert into users values(?,?,?)",3,"zhaoliu","456789");
        System.out.println(row);
    }

    /**
     * 测试spring产生jdbctemplate对象
     */
    @Test
    public void test2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate_Druid");
        String sql = "insert into users values(?,?,?)";
        int row = jdbcTemplate.update(sql,5,"zhaoliu","456789");
        System.out.println(row);
    }
}
