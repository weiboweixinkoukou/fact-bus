package com.woter.fact.bus.test;

import com.google.common.collect.Lists;
import com.woter.fact.bus.adpter.EventAdapter;
import com.woter.fact.bus.test.strategy.CallKingDeeStrategy;
import com.woter.fact.bus.test.strategy.IteamAddStrategy;
import com.woter.fact.bus.test.strategy.KingDeeStrategyContext;
import com.woter.fact.bus.test.strategy.WareHouseAddStrategy;
import org.springframework.stereotype.Component;


@Component
public class KingDeeEventHandler extends EventAdapter<KingDeeBaseEvent> {

    private KingDeeStrategyContext context;

    protected void exceptionProcess(KingDeeBaseEvent event) {

    }

    public boolean process(KingDeeBaseEvent kingDeeBaseEvent) {
       /* OperateObject operateObject = kingDeeBaseEvent.getOperateObject();
        OperateType operateType = kingDeeBaseEvent.getOperateType();
        switch (operateObject){
            case ITEM:
                switch (operateType){
                    case SAVE:
//                        System.out.println("执行商品保存同步给金蝶");
                        context = new KingDeeStrategyContext(new IteamAddStrategy());
                        break;
                    case UPDATE:
                        System.out.println("执行商品更新同步给金蝶");
                        break;
                }

            case WAREHOUSE:
                switch (operateType){
                    case SAVE:
//                        System.out.println("执行仓库保存同步给金蝶");
                        context = new KingDeeStrategyContext(new WareHouseAddStrategy());
                        break;
                    case UPDATE:
                        System.out.println("执行仓库更新同步给金蝶");
                        break;
                }

                context.AnalysisAction(kingDeeBaseEvent);
        }*/
        KingDeeStrategyContext kingDeeStrategyContext = new KingDeeStrategyContext(kingDeeBaseEvent);
        String s = kingDeeStrategyContext.AnalysisAction();//自动实现解析，不用关心使用哪种策略
        System.out.println(s);
        return true;
    }
}
