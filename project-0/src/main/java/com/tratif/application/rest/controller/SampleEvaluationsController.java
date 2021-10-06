package com.tratif.application.rest.controller;

import com.tratif.application.rest.dto.EvaluationResultDto;
import com.tratif.application.rest.service.SampleEvaluationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//TODO: add tests:
//       - ideally use Spring MockMVC to implement integration tests
//       - (you can implement it as unit tests if you are not familiar with MockMVC)
public class SampleEvaluationsController {

    @Autowired
    private SampleEvaluationsService evaluationsService;

    @RequestMapping(value = "/api/v1/evaluation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EvaluationResultDto getSumOfEvaluations() {
        return evaluationsService.sumOfSampleEvaluations();
    }

    @RequestMapping(value = "/api/v1/evaluation/functionName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    //TODO: it should work for function names: "F1", "F2", "F3"
    public EvaluationResultDto getEvaluation(String functionName) {
        return evaluationsService.sampleEvaluation(functionName);
    }
}
