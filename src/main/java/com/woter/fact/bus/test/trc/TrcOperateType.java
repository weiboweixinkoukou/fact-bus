package com.woter.fact.bus.test.trc;

public enum TrcOperateType {
    SAVE(0, "保存"),
    AUDIT(1, "审核通过"),
    UPDATE(2, "更新"),
    ZUO_FEI(3, "作废"),
    DELETE(4, "删除");

    TrcOperateType(Integer code, String name) {
        this.code = code;
        this.name = name;
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
