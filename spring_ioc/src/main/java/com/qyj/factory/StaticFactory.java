package com.qyj.factory;

import com.qyj.dao.UserDao;
import com.qyj.dao.impl.UserDaoImpl;

public class StaticFactory {

    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }

}
