package com.tratif.application.rest.service;

import com.tratif.application.rest.dto.EvaluationResultDto;

public interface SampleEvaluationsService {

    EvaluationResultDto sumOfSampleEvaluations();

    EvaluationResultDto sampleEvaluation(String name);
}
