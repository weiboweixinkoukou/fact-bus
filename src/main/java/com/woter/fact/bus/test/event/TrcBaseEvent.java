package com.woter.fact.bus.test.event;

import com.woter.fact.bus.event.BaseEvent;
import com.woter.fact.bus.test.trc.TrcOperateObject;
import com.woter.fact.bus.test.trc.TrcOperateType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrcBaseEvent implements Serializable, BaseEvent {
    /**
     * 操作的业务单号
     */
    private String businessOrderNo;

    /**
     * 操作的对象
     */
    private TrcOperateObject trcOperateObject;

    /**
     * 操作的业务类型
     */
    private TrcOperateType trcOperateType;

    /**
     * 保存和更新需要json 作废和删除不需要json 直接拿businessOrderNo自己拼接json进行操作
     */
    private String request;


//    @Transient 不入库
//    首次调用不记录次数传false 重试的时候记录传true
    private Boolean isRecordFail;

}
