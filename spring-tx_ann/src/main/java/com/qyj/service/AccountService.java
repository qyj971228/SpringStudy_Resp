package com.qyj.service;

import com.qyj.dao.AccountDao;

public interface AccountService {

    public void transfer(String outMan, String inMan, double money);

}
