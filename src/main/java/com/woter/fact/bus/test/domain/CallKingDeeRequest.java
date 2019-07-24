package com.woter.fact.bus.test.domain;

import com.woter.fact.bus.test.event.TrcBaseEvent;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 调用金蝶请求记录
 */
@Data
public class CallKingDeeRequest extends TrcBaseEvent implements Serializable {

    private Long id;

    private Date createTime;

    private Date updateTime;

    /**
     * 重试次数
     */
    private Integer retryCount;

    /**
     * 失败信息
     */
    private String exceptionMsg;

}
