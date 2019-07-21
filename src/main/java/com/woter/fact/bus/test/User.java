package com.woter.fact.bus.test;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Data
@ToString
//@Component
public class User implements InitializingBean, DisposableBean {
    private int id;

    private String name;

    private String beanName;

    public User() {
        System.out.println("User 被实例化");
    }

    public void setName(String name) {
        System.out.println("设置：" + name);
        this.name = name;
    }

    public void destroy() throws Exception {
        System.out.println("destory ....");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet....");
    }


    public void initUser() {
        System.out.println("执行initMethod方法.....");
    }

    public void destroyUser() {
        System.out.println("执行destroyMethod方法......");
    }

}
