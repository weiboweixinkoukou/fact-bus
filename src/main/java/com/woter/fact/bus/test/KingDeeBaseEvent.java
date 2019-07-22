package com.woter.fact.bus.test;

import com.woter.fact.bus.event.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class KingDeeBaseEvent implements Serializable, BaseEvent {

    private String businessOrderNo;

    private OperateObject operateObject;

    private OperateType operateType;

    private String request;


}
