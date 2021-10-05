package com.tratif.application.functions;

import com.tratif.application.core.value.model.Value;

public class Function1Result extends Value {

    private Integer f1Arg;

    public Function1Result(Integer uniqueId, Integer value, Integer f1Arg) {
        this.f1Arg = f1Arg;
    }

    public Integer getF1Arg() {
        return f1Arg;
    }
}
