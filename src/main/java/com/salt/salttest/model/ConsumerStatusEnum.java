package com.salt.salttest.model;

public enum ConsumerStatusEnum {
    ACTIVE("aktif"),
    NONACTIVE("non-aktif");
    private final String action;

    public String getAction()
    {
        return this.action;
    }
    ConsumerStatusEnum(String action) {
        this.action = action;
    }
}
