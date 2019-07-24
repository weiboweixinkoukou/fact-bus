package com.woter.fact.bus.test.strategy;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.woter.fact.bus.test.event.TrcBaseEvent;
import org.springframework.stereotype.Component;


import java.util.Map;

@Component
public class KingDeeStrategyContext {

    public static final Map<String, CallKingDeeStrategy> STRATEGY_MAP = Maps.newConcurrentMap();

    public void doCallBiz(TrcBaseEvent trcBaseEvent) {
        CallKingDeeStrategy callKingDeeStrategy = STRATEGY_MAP.get(trcBaseEvent.getTrcOperateObject().getName() + trcBaseEvent.getTrcOperateType().getName());
        callKingDeeStrategy.doCallKingDee(trcBaseEvent);
    }

}
