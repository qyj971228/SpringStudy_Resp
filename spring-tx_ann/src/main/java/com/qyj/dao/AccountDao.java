package com.qyj.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public interface AccountDao {

    public void out(String outMan,double money);
    public void in(String outMan,double money);

}
