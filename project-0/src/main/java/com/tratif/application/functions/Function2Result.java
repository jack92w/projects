package com.tratif.application.functions;

import com.tratif.application.core.value.model.Value;

public class Function2Result extends Value {

    private Integer f2Arg;

    public Function2Result(Integer uniqueId, Integer value, Integer f2Arg) {
        super(uniqueId, value);
        this.f2Arg = f2Arg;
    }

    public Integer getF2Arg() {
        return f2Arg;
    }
}
