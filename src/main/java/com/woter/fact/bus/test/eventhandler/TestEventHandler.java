package com.woter.fact.bus.test.eventhandler;

import com.woter.fact.bus.adpter.EventAdapter;
import com.woter.fact.bus.test.event.TestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestEventHandler extends EventAdapter<TestEvent> {

    private Logger logger = LoggerFactory.getLogger(TestEventHandler.class);

    protected void exceptionProcess(TestEvent event, String message) {
        logger.info("testEventprocess抛出了异常，需要改变test的状态为同步失败！event里面存的name是"+event.getName());
    }

    public void process(TestEvent testEvent) {
        /*try {
            Thread.currentThread().sleep(3000);
//            int i = 1/0;
            System.out.println("hahahahahah ");
            logger.info("==================== 收到测试事件 ===================");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            return true;
        }*/
        //            int i = 1/0;
        System.out.println("hahahahahah ");
        logger.info("==================== 收到测试事件 ===================");
    }
}
