package com.qyj.test;

import com.qyj.config.JdbcTemplateConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = JdbcTemplateConfig.class)
public class JdbcTemplateCRUDTest {

    @Autowired
    @Qualifier("jdbcTemplate_Druid")
    private JdbcTemplate jdbcTemplate_Druid;//依靠依赖注入生成

    /**
     * 1.修改1号数据的 salary为10000
     */
    @Test
    public void test1(){
        String sql = "update users set password = ? where id = ?";
        int count = jdbcTemplate_Druid.update(sql,"12345","1");
        System.out.println(count);
    }
    /**
     * 2.添加一条记录
     */
    @Test
    public void test2(){
        String sql = "insert into users(id,username,password) values(?,?,?)";
        int count = jdbcTemplate_Druid.update(sql,"2","lisi","2345");
        System.out.println(count);
    }
    /**
     * 3.删除记录
     */
    @Test
    public void test3(){
        String sql = "delete from users where id = ?";
        int count = jdbcTemplate_Druid.update(sql,"2");
        System.out.println(count);
    }
    /**
     * 4.查询id为1的记录,将其封装为Map集合
     *  注:此方法结果集长度只能为1
     */
    @Test
    public void test4(){
        String sql = "select * from users where id = ?";
        Map<String,Object> map = jdbcTemplate_Druid.queryForMap(sql,1);
        System.out.println(map);
    }
    /**
     * 5.查询所有的记录,并将其封装为List集合
     *  注:将每一条数据封装为map集合再全部封装到list集合中
     */
    @Test
    public void test5(){
        String sql = "select * from users";
        List<Map<String,Object>> list = jdbcTemplate_Druid.queryForList(sql);
        System.out.println(list);
    }
    /**
     * 6.查询所有记录,将其封装为指定javabean对象
     *
     */
    @Test
    public void test6(){
        String sql = "select * from users";
        List<User> list = jdbcTemplate_Druid.query(sql, new BeanPropertyRowMapper<User>(User.class));
        for (User u : list) {
            System.out.println(u);
        }
    }
    /**
     * 7.查询结果输出为目标类型,但是只能输出一个
     */
    @Test
    public void test7(){
        String sql = "select id from users where username='zhangsan'";
        int total = jdbcTemplate_Druid.queryForObject(sql,Integer.class);
        System.out.println(total);
    }
}
