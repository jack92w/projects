package com.tratif.application.core.value.model;

public abstract class Value {

    private Integer uniqueId;
    private Integer value;

    public Value(Integer uniqueId, Integer value) {
        this.uniqueId = uniqueId;
        this.value = value;
    }

    public Integer getUniqueId() {
        return uniqueId;
    }

    public Integer getValue() {
        return value;
    }

}
