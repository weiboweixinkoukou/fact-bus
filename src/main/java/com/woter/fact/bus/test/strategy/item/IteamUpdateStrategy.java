package com.woter.fact.bus.test.strategy.item;

import com.woter.fact.bus.test.event.TrcBaseEvent;
import com.woter.fact.bus.test.strategy.CallKingDeeStrategy;
import com.woter.fact.bus.test.strategy.KingDeeStrategyContext;
import com.woter.fact.bus.test.trc.TrcOperateObject;
import com.woter.fact.bus.test.trc.TrcOperateType;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class IteamUpdateStrategy implements CallKingDeeStrategy, InitializingBean {

    public void doCallKingDee(TrcBaseEvent trcBaseEvent) {
        System.out.println("调用金蝶商品更新");
    }


    @Override
    public void afterPropertiesSet() {
        KingDeeStrategyContext.STRATEGY_MAP.put(TrcOperateObject.ITEM.getName()+TrcOperateType.UPDATE.getName(),this);
    }
}
