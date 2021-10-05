package com.tratif.application.core.value.service;

import java.util.Collection;

import com.tratif.application.core.value.model.Value;

public interface ValueEvaluationService {

    //TODO: provide implementation that:
	//       - provides a sum of all values provided in the argument (hint: notice, that Value class is abstract, look at the entire project before you start implementing)
	//       - if a function (FUNCTION_1, FUNCTION_2... - see Function enum) is enabled, the value should be evaluated, before it's summed up
	//            (hint: see classes that extend Value class; also see Function1Evaluator, Function2Evaluator etc. -- they should be somehow used in this service)
	//       - if a function is disabled, value should not be evaluated (use its raw value, without applying function logic)
	//       - it's up to you how to model the feature disabling/enabling. 
	//            Sample implementation is provided in FunctionServiceImpl, but you can propose a solution that would allow changing it at runtime (optional)
    //TODO: add unit tests for this functionality
	//       - example scenario 1: evaluateAndSum(Arrays.asList(new Function1Result(1, 1, 1))) should return 1, when FUNCTION_1 is disabled (see Function1Result and Function1Evaluator classes and comments in their code)
	//       - example scenario 2: evaluateAndSum(Arrays.asList(new Function1Result(1, 1, 2))) should return 3, when FUNCTION_1 is enabled (see Function1Result and Function1Evaluator classes and comments in their code)
	//       - (propose other scenarios to fully test this method)
    Integer evaluateAndSum(Collection<Value> values);

    //TODO: implement this method to return int from result provided in the arg
    //TODO: value should be evaluated only if the related function is enabled -- the rules are the same as in the comments above
    //TODO: add unit tests
    //TODO: (bonus, optional) add cache
    Integer evaluate(Value value);
}
