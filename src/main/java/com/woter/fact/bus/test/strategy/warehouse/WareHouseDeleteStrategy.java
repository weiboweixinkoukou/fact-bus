package com.woter.fact.bus.test.strategy.warehouse;

import com.woter.fact.bus.test.event.TrcBaseEvent;
import com.woter.fact.bus.test.strategy.CallKingDeeStrategy;
import com.woter.fact.bus.test.strategy.KingDeeStrategyContext;
import com.woter.fact.bus.test.trc.TrcOperateObject;
import com.woter.fact.bus.test.trc.TrcOperateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class WareHouseDeleteStrategy implements CallKingDeeStrategy, InitializingBean {
    private Logger log = LoggerFactory.getLogger(WareHouseDeleteStrategy.class);

    public void doCallKingDee(TrcBaseEvent trcBaseEvent) {
        log.info("调用金蝶仓库删除");
    }



    @Override
    public void afterPropertiesSet()  {
        KingDeeStrategyContext.STRATEGY_MAP.put(TrcOperateObject.WAREHOUSE.getName()+TrcOperateType.DELETE.getName(),this);
    }
}
