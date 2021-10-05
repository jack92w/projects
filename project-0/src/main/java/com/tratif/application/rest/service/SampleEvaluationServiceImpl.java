package com.tratif.application.rest.service;

import com.tratif.application.core.value.model.Value;
import com.tratif.application.core.value.service.ValueEvaluationService;
import com.tratif.application.functions.Function1Result;
import com.tratif.application.functions.Function2Result;
import com.tratif.application.functions.Function3Result;
import com.tratif.application.rest.dto.EvaluationResultDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SampleEvaluationServiceImpl implements SampleEvaluationsService {

    @Autowired
    private ValueEvaluationService evaluationService;

    @Override
    public EvaluationResultDto sumOfSampleEvaluations() {
        List<Value> results = new ArrayList<>();
        results.add(getSampleForFunctionName("F1"));
        results.add(getSampleForFunctionName("F2"));
        results.add(getSampleForFunctionName("F3"));
        return new EvaluationResultDto(evaluationService.evaluateAndSum(results));
    }

    @Override
    public EvaluationResultDto sampleEvaluation(String name) {
        return new EvaluationResultDto(evaluationService.evaluate(getSampleForFunctionName(name)));
    }

    private Value getSampleForFunctionName(String name) {
        Value result;
        switch (name) {
            case "F1":
                result = new Function1Result(1, 7, 22);
                break;
            case "F2":
                result = new Function2Result(2, 7, 4);
                break;
            case "F3":
                result = new Function3Result(3, 7, 3.2f);
                break;
            default:
                throw new IllegalArgumentException("Unsupported function: " + name);
        }
        return result;
    }
}
