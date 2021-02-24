package com.qyj.service.impl;

import com.qyj.dao.AccountDao;
import com.qyj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao;

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,timeout = -1,readOnly = false)
    @Override
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        //int i = 1/0;//用于测试事务控制是否实现
        accountDao.in(inMan,money);
    }
}
