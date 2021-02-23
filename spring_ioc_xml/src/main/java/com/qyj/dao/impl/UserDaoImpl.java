package com.qyj.dao.impl;

import com.qyj.dao.UserDao;
import com.qyj.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    private String username;
    private int age;

    private List<String> stringList;
    private Map<String, User> userMap;
    private Properties properties;

    public UserDaoImpl(String username,int age,List<String> stringList,Map<String, User> userMap,Properties properties){
        this.username=username;
        this.age=age;
        this.stringList=stringList;
        this.userMap=userMap;
        this.properties=properties;
    }

    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建..");
    }

    public void init(){
        System.out.println("初始化方法..");
    }

    public void destroy(){
        System.out.println("销毁方法..");
    }

    @Override
    public void save() {
        //System.out.println("username"+username+";"+"age"+age);
        System.out.println("stringList"+stringList+"\n"+"userMap"+userMap+"\n"+"properties"+properties);
        System.out.println("save running");
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
