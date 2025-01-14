package com.woter.fact.bus.facede;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.woter.fact.bus.adpter.EventAdapter;
import com.woter.fact.bus.event.BaseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * EventBus处理类，主要用于注册或注销及发布相关事件
 * @author woterF
 * @date 2017-6-29 上午11:18:14
 * @version
 */
public class EventBusManager {

    private static final Logger logger = LoggerFactory.getLogger(EventBusManager.class);

//    private final static EventBus eventBus = new EventBus();
    private static BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();
    private final static AsyncEventBus eventBus = new AsyncEventBus(new ThreadPoolExecutor(5,20,30, TimeUnit.SECONDS,workQueue));



//    private final static Executor executor = Executors.newCachedThreadPool();

    public static void post(BaseEvent event) {
        execute(event);
    }

    /***
     * 异步执行
     * @param event
     *
     * @author woter
     * @date 2017-7-6 上午8:47:42
     * @version
     */
    public static void execute(BaseEvent event) {
        if (event == null) {
            return;
        }
        logger.info("eventBus异步注册事件"+event.getClass());
        eventBus.post(event);
    }

    /**
     * 异步提交
     * @param event
     *
     * @author woter
     * @date 2017-7-6 上午8:47:30
     * @version
     */
    /*public static void submit(final BaseEvent event) {
        if (event == null) {
            return;
        }
        executor.execute(new Runnable() {
            public void run() {
                logger.info("eventBus异步注册事件");
                eventBus.post(event);
            }
        });
    }*/

    /**
     * 注册event handler
     * @param handler
     *
     * @author woter
     * @date 2017-7-6 上午11:47:30
     * @version
     */
    public static void register(EventAdapter<? extends BaseEvent> handler) {
        if (handler == null) {
            return;
        }
        eventBus.register(handler);
        logger.info("Registered eventAdapter class: {}", handler.getClass());
    }


    public static void unregister(EventAdapter<? extends BaseEvent> handler) {
        if (handler == null) {
            return;
        }
        eventBus.unregister(handler);
        logger.info("Unregisted eventAdapter class: {}", handler.getClass());
    }

}
