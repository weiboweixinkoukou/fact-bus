package com.woter.fact.bus.test.eventhandler;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.woter.fact.bus.adpter.EventAdapter;
import com.woter.fact.bus.test.event.TrcBaseEvent;
import com.woter.fact.bus.test.strategy.KingDeeStrategyContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TrcEventHandler extends EventAdapter<TrcBaseEvent> {

    private Logger log = LoggerFactory.getLogger(TrcEventHandler.class);

    @Autowired
    private KingDeeStrategyContext context;

    protected void exceptionProcess(TrcBaseEvent event, String message) {
        Preconditions.checkNotNull(event);
        if (event.getIsRecordFail()) {
            /*
            这个是定时器的逻辑

            对于更新操作 比较特殊 泰然城更新和金蝶更新是断开的
            如果第一次更新失败 第二次更新成功 会存在跑重试的时候讲最新的更新数据还原到第一次失败的数据
            如果采用每次更新去失败表查一次将关联的这条数据更新为成功 也会存在更新的时候这个失败任务已经在跑了，
            所以还是将所有成功和失败的请求都记录下来 然后对于更新重试的请求 按照时间升序进行重试 会存在同一个单据重新跑过多流程的问题
            不对，如果这样做的话，得满足处理的顺序和抛出去的事件的顺序是一样的。这样好像得用同步？？？？？ 还得考虑一个单据重试跑之前的过多次的流程的问题

            如果第一次失败 第二次还是失败 这个好像没有问题 如果第二次失败 去查数据库的时候 定时任务跑了并且更新了之前的一条失败数为成功，第二次去查的时候查出来是成功的，可以覆盖这条数据
            如果第一条数据还没来得及更新为成功 这时候还是可以覆盖第一次的失败记录 但是跑了之后还是失败 拿到又去查失败记录最新的失败记录 将其改为原来的失败记录？ 这样好像还是有问题？？？？？

            这样说来还是要记录所有成功和失败的记录 然后去跑所有经历过的流程
            不管失败成功 都得重新记录一条记录
            那更新的失败请求 还要啥失败重试次数？？？？
            而且如果做成同步的话 这边的TrcBaseEvent也不能让其使用了 得用eventBus 重新定义事件 或者不是更新的全部先跑出去
            是更新的在定时任务主线程一个个跑 那对于类型是更新的所有基础和单据只要有一个出错是不是定时任务里更新的全部gg
            或者更新的可以根据单号进行分组
            不同的组再定义一个失败重试事件 handler里对这一组进行顺序重试
            */

            //TODO 如果不是更新
            log.error("失败原因:{}", message);
            System.out.println("失败重试，需要将重试次数加1");
            //TODO 如果是更新 需要向表里添加此次更新失败的记录

        } else {
            log.error("失败原因:{}", message);
            System.out.println("第一次调用失败，只需将记录保存");
        }
    }

    public void process(TrcBaseEvent trcBaseEvent) {
       /* KingDeeOperateObject kingDeeOperateObject = trcBaseEvent.getKingDeeOperateObject();
        KingDeeOperateType kingDeeOperateType = trcBaseEvent.getKingDeeOperateType();
        switch (kingDeeOperateObject){
            case ITEM:
                switch (kingDeeOperateType){
                    case SAVE:
//                        System.out.println("执行商品保存同步给金蝶");
                        context = new KingDeeStrategyContext(new IteamAddStrategy());
                        break;
                    case UPDATE:
                        System.out.println("执行商品更新同步给金蝶");
                        break;
                }

            case WAREHOUSE:
                switch (kingDeeOperateType){
                    case SAVE:
//                        System.out.println("执行仓库保存同步给金蝶");
                        context = new KingDeeStrategyContext(new WareHouseAddStrategy());
                        break;
                    case UPDATE:
                        System.out.println("执行仓库更新同步给金蝶");
                        break;
                }

                context.AnalysisAction(trcBaseEvent);
        }*/
        context.doCallBiz(trcBaseEvent);//自动实现解析，不用关心使用哪种策略
    }
}
