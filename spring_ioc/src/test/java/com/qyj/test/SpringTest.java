package com.qyj.test;

import com.qyj.dao.UserDao;
import com.qyj.service.UserService;
import com.qyj.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringTest {
    /**
     * 快速原型
     */
    @Test
    public void test(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("UserDao");
        userDao.save();
    }
    /**
     * scope属性测试
     */
    @Test
    public void test2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("UserDao");
        UserDao userDao2 = (UserDao) app.getBean("UserDao");
        System.out.println(userDao);
        System.out.println(userDao2);
    }
    /**
     * init-method
     * destroy-method
     * 测试
     * 要求:Bean的scope="singleton
     */
    @Test
    public void test3(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("UserDao");
        UserDao userDao2 = (UserDao) app.getBean("UserDao");
        ((ClassPathXmlApplicationContext)app).close();//手动指定容器关闭
    }
    /**
     * 静态工厂
     * 测试
     */
    @Test
    public void test4(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("staticFactory");
    }
    /**
     * 实例工厂
     * 测试
     */
    @Test
    public void test5(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("UserDao");
    }
    /**
     * service层实现
     * 测试
     */
    @Test
    public void test6(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("UserService");
        userService.save();

    }
    /**
     * set注入 -> 普通数据类型注入&引用数据类型注入&集合数据类型注入
     * 构造注入
     */
    @Test
    public void test7(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("UserDao");
        userDao.save();
    }
    /**
     * Spring-API
     * ApplicationContext实现类
     * 两个getBean()
     */
    @Test
    public void test8(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext app = new FileSystemXmlApplicationContext(
//                "D:\\Study\\framework\\spring\\spring_ioc\\src\\main\\resources\\applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("UserDao");
//        UserDao userDao = app.getBean(UserDao.class);
        userDao.save();
    }
}










