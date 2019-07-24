import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EventBusTest {
    private AsyncEventBus asyncEventBus;

    @Before
    public void before(){
        asyncEventBus=new AsyncEventBus(Executors.newFixedThreadPool(3));
        asyncEventBus.register(this);
    }

    @Subscribe
    @AllowConcurrentEvents
    public void subscribe(Object object){
        System.out.println("收到:"+object);
    }

    @Test
    public void test_sendMsg() throws InterruptedException {
        System.out.println("开始发送消息");
        asyncEventBus.post("这是消息");
        System.out.println("开始睡眠");
        TimeUnit.SECONDS.sleep(5L);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<EventBusTest> eventBusTestClass = EventBusTest.class;
        Method subscribe = eventBusTestClass.getMethod("subscribe", Object.class);
        Class<?>[] parameterTypes = subscribe.getParameterTypes();
        Class<?> parameterType = parameterTypes[0];
        System.out.println(parameterType);
    }
}
