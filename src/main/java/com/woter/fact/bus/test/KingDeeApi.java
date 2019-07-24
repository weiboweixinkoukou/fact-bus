package com.woter.fact.bus.test;

import com.woter.fact.bus.test.trc.KingDeeOperateObject;
import com.woter.fact.bus.test.trc.KingDeeOperateType;
import lombok.Data;

@Data
public class KingDeeApi {
    private KingDeeOperateObject kingDeeOperateObject;
    private KingDeeOperateType kingDeeOperateType;
}
