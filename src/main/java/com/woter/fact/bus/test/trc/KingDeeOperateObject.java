package com.woter.fact.bus.test.trc;

public enum KingDeeOperateObject {

    ITEM(1,"商品"),
    WAREHOUSE(2,"仓库")
    ;

    KingDeeOperateObject( Integer code,String name) {
        this.name = name;
        this.code = code;
    }

    private Integer code;
    private String name;

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
