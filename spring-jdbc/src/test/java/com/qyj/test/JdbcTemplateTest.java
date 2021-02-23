package com.qyj.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateTest {

    /**
     * 测试JdbcTemplate开发步骤
     */
    @Test
    public void test10() throws PropertyVetoException {
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
    public void test20(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate_Druid");

        String sql = "insert into users values(?,?,?)";
        int row = jdbcTemplate.update(sql,5,"zhaoliu","456789");
        System.out.println(row);

    }
    /**
     * 1.修改1号数据的 salary为10000
     */
    @Test
    public void test1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate_Druid");

        String sql = "update users set password = ? where id = ?";
        int count = jdbcTemplate.update(sql,"12345","1");

        System.out.println(count);
    }
    /**
     * 2.添加一条记录
     */
    @Test
    public void test2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate_Druid");

        String sql = "insert into users(id,username,password) values(?,?,?)";
        int count = jdbcTemplate.update(sql,"2","lisi","2345");

        System.out.println(count);
    }
    /**
     * 3.删除记录
     */
    @Test
    public void test3(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate_Druid");

        String sql = "delete from users where id = ?";
        int count = jdbcTemplate.update(sql,"2");

        System.out.println(count);
    }
    /**
     * 4.查询id为1的记录,将其封装为Map集合
     *  注:此方法结果集长度只能为1
     */
    @Test
    public void test4(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate_Druid");

        String sql = "select * from users where id = ?";
        Map<String,Object> map = jdbcTemplate.queryForMap(sql,1);

        System.out.println(map);
    }
    /**
     * 5.查询所有的记录,并将其封装为List集合
     *  注:将每一条数据封装为map集合再全部封装到list集合中
     */
    @Test
    public void test5(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate_Druid");

        String sql = "select * from users";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);

        System.out.println(list);
    }
    /**
     * 6.查询所有记录,将其封装为javabean对象
     */
    @Test
    public void test6(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate_Druid");

        String sql = "select * from users";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));

        for (User u : list) {
            System.out.println(u);
        }
    }
    /**
     * 7.查询总记录数
     */
    @Test
    public void test7(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate_Druid");

        String sql = "select count(id) from users";
        Long total = jdbcTemplate.queryForObject(sql,Long.class);

        System.out.println(total);
    }
}
