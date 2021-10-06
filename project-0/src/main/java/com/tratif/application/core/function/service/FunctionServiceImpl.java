package com.tratif.application.core.function.service;

import com.tratif.application.core.function.model.Function;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class FunctionServiceImpl implements FunctionService {

    private static final Collection<Function> ENABLED_FEATURES = Arrays.asList(Function.FUNCTION_1, Function.FUNCTION_2);

    @Override
    public boolean isActive(Function feature) {
        return ENABLED_FEATURES.contains(feature);
    }
}
