package com.woter.fact.bus.test.domain;

import com.woter.fact.bus.test.trc.TrcOperateObject;
import com.woter.fact.bus.test.trc.TrcOperateType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 调用金蝶更新失败操作 记录重试次数和最新的一次重试流程哪一步操作出现了异常  最新的异常信息
 */
@Data
public class CallKingDeeUpdateRetryRequest implements Serializable {

    private Long id;

    private Date createTime;

    private Date updateTime;

    /**
     * 重试次数
     */
    private Integer retryCount;


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
    private TrcOperateType trcOperateType = TrcOperateType.UPDATE;

    /**
     * 关联的最新一次顺序执行更新的时候哪一个操作出现异常的id
     */
    private Long relateCallKingDeeRequestId;

    /**
     * 关联的最新一次顺序执行更新的时候哪一个操作出现异常的
     */
    private String exceptionMsg;
}
