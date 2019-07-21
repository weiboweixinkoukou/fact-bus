package com.woter.fact.bus.adpter;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.woter.fact.bus.event.BaseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

/**
 * 所有Event处理类都要继承此Adapter类 实现process进行相关event处理
 * @author woter
 * @date 2017-6-29 下午2:34:25
 * @version
 */
public abstract class EventAdapter<E extends BaseEvent> {

    private static final Logger logger = LoggerFactory.getLogger(EventAdapter.class);

    private static final String METHOD_NAME = "process";

    @Subscribe
    @AllowConcurrentEvents
    @SuppressWarnings("all")
    public void onEvent(BaseEvent event) {
        if (ReflectionUtils.findMethod(this.getClass(), METHOD_NAME, event.getClass()) != null) {
            try {
                if (!process((E) event)) {
                    logger.warn("handle event {} fail", event.getClass());
                }
            } catch (Exception e) {
                exceptionProcess((E) event);
                //执行任务失败了 记录失败的对象,在库里或者在缓存中进行标识 这些失败的对象 需要跑定时任务进行重试
                logger.error(String.format("handle event %s exception", event.getClass()), e);
            }
        }
    }

    protected abstract void exceptionProcess(E event);

    public abstract boolean process(E e);

}
