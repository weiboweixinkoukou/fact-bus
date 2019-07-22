/*
package com.woter.fact.bus.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        User user = null;
        if (bean.getClass().equals(User.class)) {
            System.out.println("postProcessBeforeInitialization.....");
            System.out.println("对初始化之前的Bean进行处理,此时我的名字" + bean);
            user = (User) bean;
            user.setName("shixiaopeng");
        }
        return user;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("对初始化之后的Bean进行处理,此时我的名字" + bean);
        return bean;
    }
}
*/
