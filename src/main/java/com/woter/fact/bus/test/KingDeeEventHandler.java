package com.woter.fact.bus.test;

import com.woter.fact.bus.adpter.EventAdapter;
import org.springframework.stereotype.Component;

@Component
public class KingDeeEventHandler extends EventAdapter<KingDeeBaseEvent> {
    protected void exceptionProcess(KingDeeBaseEvent event) {

    }

    public boolean process(KingDeeBaseEvent kingDeeBaseEvent) {
        OperateObject operateObject = kingDeeBaseEvent.getOperateObject();
        OperateType operateType = kingDeeBaseEvent.getOperateType();
        switch (operateObject){
            case ITEM:
                switch (operateType){
                    case SAVE:
                        System.out.println("执行商品保存同步给金蝶");
                        break;
                    case UPDATE:
                        System.out.println("执行商品更新同步给金蝶");
                        break;
                }

            case WAREHOUSE:
                switch (operateType){
                    case SAVE:
                        System.out.println("执行仓库保存同步给金蝶");
                        break;
                    case UPDATE:
                        System.out.println("执行仓库更新同步给金蝶");
                        break;
                }
        }



        return true;
    }
}
