package com.woter.fact.bus.test.strategy;

import com.google.common.collect.Lists;
import com.woter.fact.bus.test.KingDeeApi;
import com.woter.fact.bus.test.KingDeeBaseEvent;
import com.woter.fact.bus.test.OperateObject;
import com.woter.fact.bus.test.OperateType;

import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.util.List;

public class KingDeeStrategyContext {

    private List<CallKingDeeStrategy> strategyList = Lists.newArrayListWithCapacity(20);

    private KingDeeBaseEvent kingDeeBaseEvent;

    public KingDeeStrategyContext(KingDeeBaseEvent kingDeeBaseEvent) {
        strategyList.add(new IteamAddStrategy(kingDeeBaseEvent));
        strategyList.add(new WareHouseAddStrategy(kingDeeBaseEvent));
        this.kingDeeBaseEvent = kingDeeBaseEvent;
    }

    /*private CallKingDeeStrategy strategy;
    /// <summary>
    /// 外层调用的时候决定使用哪个扫描策略
    /// </summary>
    /// <param name="strategy"></param>
    public KingDeeStrategyContext(CallKingDeeStrategy strategy)
    {
        this.strategy = strategy;
    }*/

    public String AnalysisAction() {
        if (strategyList != null && strategyList.size() > 0) {
            for (CallKingDeeStrategy callKingDeeStrategy : strategyList) {
                if (callKingDeeStrategy.Analysisable()){
                    String s = callKingDeeStrategy.doCallKingDee(kingDeeBaseEvent);
                    return s;
                }
            }
        }
        return null;
    }



    public static void main(String[] args) {
        KingDeeBaseEvent kingDeeBaseEvent = new KingDeeBaseEvent("CK0001", OperateObject.WAREHOUSE, OperateType.SAVE,"json");
        KingDeeStrategyContext kingDeeStrategyContext = new KingDeeStrategyContext(kingDeeBaseEvent);
        kingDeeStrategyContext.AnalysisAction();//自动实现解析，不用关心使用哪种策略
    }
}
