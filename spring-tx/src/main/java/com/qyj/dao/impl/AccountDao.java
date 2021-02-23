package com.qyj.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

public interface AccountDao {

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
    public void out(String outMan,double money);
    public void in(String outMan,double money);

}
