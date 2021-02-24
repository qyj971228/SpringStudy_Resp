package com.qyj.service.impl;

import com.qyj.dao.impl.AccountDao;
import com.qyj.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Override
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        int i = 1/0;//用于测试事务控制是否实现
        accountDao.in(inMan,money);
    }
}
