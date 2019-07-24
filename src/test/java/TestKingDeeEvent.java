import com.woter.fact.bus.facede.EventBusManager;
import com.woter.fact.bus.test.event.TrcBaseEvent;
import com.woter.fact.bus.test.trc.TrcOperateObject;
import com.woter.fact.bus.test.trc.TrcOperateType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring.xml")
@Slf4j
public class TestKingDeeEvent {

    @Test
    public void test(){
//        EventBusManager.execute(new TrcBaseEvent("KC0001", TrcOperateObject.WAREHOUSE, TrcOperateType.UPDATE,"仓库更新的json",false)); //发布事件
//
//        EventBusManager.execute(new TrcBaseEvent("KC0001", TrcOperateObject.WAREHOUSE, TrcOperateType.DELETE,"仓库删除的json",false)); //发布事件
//
//        EventBusManager.execute(new TrcBaseEvent("KC0001", TrcOperateObject.ITEM, TrcOperateType.UPDATE,"商品更新的json",false)); //发布事件
        log.info("抛出商品新增post");
        EventBusManager.execute(new TrcBaseEvent("KC0001", TrcOperateObject.ITEM, TrcOperateType.SAVE,"商品新增的json",true)); //发布事件
    }
}
