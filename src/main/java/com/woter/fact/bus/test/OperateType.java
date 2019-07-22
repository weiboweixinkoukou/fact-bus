package com.woter.fact.bus.test;

public enum OperateType {
    SAVE("保存",0),
    UPDATE("更新",1)
    ;

    OperateType(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
