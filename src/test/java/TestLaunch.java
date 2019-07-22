import com.woter.fact.bus.facede.EventBusManager;
import com.woter.fact.bus.test.KingDeeBaseEvent;
import com.woter.fact.bus.test.OperateObject;
import com.woter.fact.bus.test.OperateType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.woter.fact.bus.test.TestEvent;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring.xml")
public class TestLaunch {
    @Test
    public void testExecute() throws InterruptedException {
        System.out.println(System.currentTimeMillis() + "-----------------------1");
//        EventBusManager.execute(new TestEvent("仓库")); //发布事件
        EventBusManager.execute(new KingDeeBaseEvent("KC0001", OperateObject.WAREHOUSE, OperateType.UPDATE,"仓库保存的json")); //发布事件
//        EventBusManager.submit(new TestEvent("仓库")); //发布事件
        System.out.println(System.currentTimeMillis() + "-----------------------2");


    }
}
