package com.qyj.service.impl;

import com.qyj.dao.UserDao;
import com.qyj.service.UserService;
import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<bean id="serviceDao" class="com.com.qyj.service.impl.UserServiceImpl"></bean>
//@Component("serviceDao")
//@Scope("prototype")
@Service("userService")
@Scope("singleton")

public class UserServiceImpl implements UserService {

    @Value("${jdbc.driver}")
    private String driver;

    //<property name="userDao" ref="userDao"></property>
//    @Autowired //按照数据类型从Spring容器中进行匹配
//    @Qualifier("userDao") //按照id值从容器中进行匹配
    @Resource(name = "userDao")
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct
    public void inti(){
        System.out.println("初始化");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁");
    }
}
