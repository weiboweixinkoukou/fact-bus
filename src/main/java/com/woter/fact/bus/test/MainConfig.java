package com.woter.fact.bus.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    @Bean(initMethod="initUser",destroyMethod="destroyUser")
    public User getUser(){
        return new User();
    }
    @Bean
    public MyPostProcessor getMyPostProcessor(){
        return new MyPostProcessor();
    }
}
