Income calculator application - recruitment task

1. Purpose:
a) calculation of income including ZUS and PIT
b) return the last calculations (quntity of how many is given as a parameter)
2. Launch:
a) Run CalculatorApplication.java
b) Make http request through Endpoints (you can use Postman for testing) 
	Endpoint 1.a) POST "/income/{rawIncome}"
	PathVariable (rawIncome): input raw income to be calculated
	ResponseBody: value of calculated income

	Endpoint 1.b) GET "/income/{lastNumber}"
	PathVariable (lastNumber): number of last calculated incomes quantity to be returned
	ResponseBody: list of calculated incomes
