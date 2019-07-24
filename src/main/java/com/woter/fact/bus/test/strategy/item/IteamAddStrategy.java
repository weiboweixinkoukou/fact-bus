package com.woter.fact.bus.test.strategy.item;

import com.google.common.base.Preconditions;
import com.woter.fact.bus.test.event.TrcBaseEvent;
import com.woter.fact.bus.test.strategy.CallKingDeeStrategy;
import com.woter.fact.bus.test.strategy.KingDeeStrategyContext;
import com.woter.fact.bus.test.trc.TrcOperateObject;
import com.woter.fact.bus.test.trc.TrcOperateType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class IteamAddStrategy implements CallKingDeeStrategy, InitializingBean {

    public void doCallKingDee(TrcBaseEvent trcBaseEvent) {
//        int i = 1/0;
        log.info("调用金蝶商品新增");
        System.out.println("调用金蝶商品新增");
    }


    @Override
    public void afterPropertiesSet() {
        KingDeeStrategyContext.STRATEGY_MAP.put(TrcOperateObject.ITEM.getName()+TrcOperateType.SAVE.getName(),this);
    }
}
