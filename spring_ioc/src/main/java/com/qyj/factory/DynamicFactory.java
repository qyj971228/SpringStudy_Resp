package com.qyj.factory;

import com.qyj.dao.UserDao;
import com.qyj.dao.impl.UserDaoImpl;

public class DynamicFactory {

    public UserDao getUserDao(){
        return new UserDaoImpl();
    }

}
