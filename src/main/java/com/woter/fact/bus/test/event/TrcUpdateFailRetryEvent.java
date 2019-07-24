package com.woter.fact.bus.test.event;

import com.woter.fact.bus.event.BaseEvent;
import com.woter.fact.bus.test.domain.CallKingDeeRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TrcUpdateFailRetryEvent implements Serializable, BaseEvent {
    /**
     * 失败记录里更新的失败记录个数
     */
    private List<CallKingDeeRequest> callKingDeeRequests;

    /**
     * 顺序执行时哪一个失败请求重试出现异常的id
     */
    private Long updateRetryFailId;
}
