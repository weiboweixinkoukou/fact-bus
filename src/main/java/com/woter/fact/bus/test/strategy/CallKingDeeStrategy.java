package com.woter.fact.bus.test.strategy;

import com.woter.fact.bus.test.KingDeeBaseEvent;

public interface CallKingDeeStrategy {

    String doCallKingDee(KingDeeBaseEvent kingDeeBaseEvent);

    /// <summary>
    /// 是否可以解析
    /// </summary>
    boolean Analysisable();

    //TODO 插入失败数据

}
