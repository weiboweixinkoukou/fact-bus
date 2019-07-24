package com.woter.fact.bus.test.trc;

public enum KingDeeOperateType {
    SAVE(0, "保存"),
    UN_AUDIT(1, "反审核"),
    DELETE(2, "删除");

    KingDeeOperateType(Integer code, String name) {
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
