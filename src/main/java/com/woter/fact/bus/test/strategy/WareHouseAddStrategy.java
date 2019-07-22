package com.woter.fact.bus.test.strategy;

import com.woter.fact.bus.test.KingDeeApi;
import com.woter.fact.bus.test.KingDeeBaseEvent;
import com.woter.fact.bus.test.OperateObject;
import com.woter.fact.bus.test.OperateType;

public class WareHouseAddStrategy implements CallKingDeeStrategy {
    private KingDeeBaseEvent kingDeeBaseEvent;

    public WareHouseAddStrategy(KingDeeBaseEvent kingDeeBaseEvent) {
        this.kingDeeBaseEvent = kingDeeBaseEvent;
    }

    public String doCallKingDee(KingDeeBaseEvent kingDeeBaseEvent) {
        System.out.println("调用金蝶仓库新增");
        return null;
    }

    public boolean Analysisable() {
        OperateObject operateObject = kingDeeBaseEvent.getOperateObject();
        OperateType operateType = kingDeeBaseEvent.getOperateType();
        return operateObject.equals(OperateObject.WAREHOUSE)&&operateType.equals(OperateType.SAVE);
    }
}
