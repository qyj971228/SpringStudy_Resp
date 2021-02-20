package com.qyj.dao.impl;

import com.qyj.dao.UserDao;

public class UserDaoImpl implements UserDao {


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
        System.out.println("save running");
    }
}
