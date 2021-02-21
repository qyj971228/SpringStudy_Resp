package com.qyj.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.qyj.config.SpringConfiguration;
import com.qyj.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSourceTest {

    /**
     * 测试手动创建c3p0
     */
    @Test
    public void test1() throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/world?serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("DBJdedi2gehao");
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }

    /**
     * 测试手动创建Druid
     */
    @Test
    public void test2() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/world?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("DBJdedi2gehao");
        DruidPooledConnection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }
    /**
     * 测试手动创建c3p0 -> 配置文件形式
     */
    @Test
    public void test3() throws PropertyVetoException, SQLException {

        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("jdbc.driver");
        String url = bundle.getString("jdbc.url");
        String user = bundle.getString("jdbc.username");
        String password = bundle.getString("jdbc.password");

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        Connection conn = dataSource.getConnection();

        System.out.println(conn);
        conn.close();
    }

    /**
     * 测试手动创建Druid -> 配置文件形式
     */
    @Test
    public void test4() throws SQLException {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("jdbc.driver");
        String url = bundle.getString("jdbc.url");
        String user = bundle.getString("jdbc.username");
        String password = bundle.getString("jdbc.password");

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }

    /**
     * 测试spring容器产生数据源对象 -> C3P0
     */
    @Test
    public void test5() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) app.getBean("dataSource_C3P0");
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
    }
    /**
     * 测试spring容器产生数据源对象 -> Druid
     */
    @Test
    public void test6() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) app.getBean("dataSource_Druid");
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
    }

    /**
     *
     */
    @Test
    public void test7(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
        ((ClassPathXmlApplicationContext)app).close();
    }
    /**
     * Spring注解充当配置文件
     */
    @Test
    public void test8() throws SQLException {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }
}
