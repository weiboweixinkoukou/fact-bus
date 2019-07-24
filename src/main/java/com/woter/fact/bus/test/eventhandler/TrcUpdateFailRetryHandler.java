package com.woter.fact.bus.test.eventhandler;

import com.google.common.base.Preconditions;
import com.woter.fact.bus.adpter.EventAdapter;
import com.woter.fact.bus.facede.EventBusManager;
import com.woter.fact.bus.test.domain.CallKingDeeRequest;
import com.woter.fact.bus.test.event.TrcBaseEvent;
import com.woter.fact.bus.test.event.TrcUpdateFailRetryEvent;
import com.woter.fact.bus.test.strategy.KingDeeStrategyContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TrcUpdateFailRetryHandler extends EventAdapter<TrcUpdateFailRetryEvent> {

    private Logger log = LoggerFactory.getLogger(TrcUpdateFailRetryHandler.class);

    @Override
    protected void exceptionProcess(TrcUpdateFailRetryEvent trcUpdateFailRetryEvent, String message) {
        //出现异常 如果算更新失败次数的话 得单独拉一张表 针对哪个单号 对象 更新操作 创建更新时间   【顺序执行时哪一个失败请求重试出现异常的id】 返回异常信息 重试次数
        //TODO 表中不存在这个数据 新增 存在更新重试次数 最新的失败返回信息 最新的顺序执行失败的id

    }

    @Override
    public void process(TrcUpdateFailRetryEvent trcUpdateFailRetryEvent) {
        //针对一批的更新失败进行重试
        List<CallKingDeeRequest> callKingDeeRequests = trcUpdateFailRetryEvent.getCallKingDeeRequests();
        callKingDeeRequests.forEach(i->{
           //必须同步重试 得按照顺序一个一个来 每一个抓异常
            try {
                //调用金蝶接口
            }catch (Exception e){
                trcUpdateFailRetryEvent.setUpdateRetryFailId(i.getId());
            }
        });
    }
}
