package com.tratif.application.functions;

import com.tratif.application.core.value.model.Value;

public class Function3Result extends Value {

    private Float f3Arg;

    public Function3Result(Integer uniqueId, Integer value, Float f3Arg) {
        super(uniqueId, value);
        this.f3Arg = f3Arg;
    }

    public Float getF3Arg() {
        return f3Arg;
    }
}
