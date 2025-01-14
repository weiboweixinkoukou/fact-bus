package com.woter.fact.bus.annotation;

import com.woter.fact.bus.adpter.EventAdapter;
import com.woter.fact.bus.facede.EventBusManager;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 实现自动注册及注销EventAdapter
 * @author woter
 * @date 2017-6-29 上午11:24:00
 * @version
 */
@Configuration
public class EventBusConfiguration implements InitializingBean, DisposableBean {

    @Autowired
    private ApplicationContext applicationContext;

    private Map<String, EventAdapter> beans = null;


    public void afterPropertiesSet() throws Exception {

        beans = applicationContext.getBeansOfType(EventAdapter.class);
        if (beans != null) {
            for (EventAdapter eventAbstract : beans.values()) {
                EventBusManager.register(eventAbstract);
            }
        }
    }


    public void destroy() throws Exception {
        if (beans != null) {
            for (EventAdapter eventAbstract : beans.values()) {
                EventBusManager.unregister(eventAbstract);
            }
        }
    }

}
