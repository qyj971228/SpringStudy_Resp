package com.qyj.service;

import com.qyj.dao.impl.AccountDao;

public interface AccountService {

    public void setAccountDao(AccountDao accountDao);
    public void transfer(String outMan, String inMan, double money);

}
