package com.qyj.config;

import org.springframework.context.annotation.*;

//标志该类是spring的核心配置类
@Configuration

//<context:component-scan base-package="com.com.qyj"></context:component-scan>
@ComponentScan("com.qyj")

//<import resource="applicationContext-constructor-arg.xml"></import>
@Import(com.qyj.config.DataSourceConfiguration.class)

public class SpringConfiguration {
}
