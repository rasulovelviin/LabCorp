Feature: LabCorp UserAPI scenarios


@Test
Scenario: Add new user - End to ENd scenario
 Given User create json request data
 	|createdAt |employee_firstname |employee_lastname |employee_phonenumbe|ademployee_emaildress|citemployee_addressy|stateemployee_dev_level|employee_gender |employee_hire_date     |employee_onleave |
  |1631825833|John							 |Smith					    |264-783-9453				|johnSmith@gmail.com	|Reston							 |Virginia							 |male						|2025-10-31T163545.426Z	| true						|     
 When User submit POST request
 Then User validate statusCode is 201
 And User retrives recordID from response
 And User submits GET request with record ID
 And User validates if user is created and exist
 And User delete the record
 
 
 
 @Test1
 Scenario Outline: Negative scenario "<Scenario Name>"
 Given User create json request data
 	|createdAt  |employee_firstname  |employee_lastname  |employee_phonenumbe  |ademployee_emaildress  |citemployee_addressy  |stateemployee_dev_level  |employee_gender   |employee_hire_date    |employee_onleave  |
  |<createdAt>|<employee_firstname>|<employee_lastname>|<employee_phonenumbe>|<ademployee_emaildress>|<citemployee_addressy>|<stateemployee_dev_level>|<employee_gender >|<employee_hire_date>	|<employee_onleave>|     
 When User submit POST request
 Then User validate statusCode is 201
 And User retrives recordID from response
 And User submits GET request with record ID
 And User validates if user is created and exist
 And User delete the record
 
 Examples:
|Scenario Name  		  				|createdAt |employee_firstname |employee_lastname |employee_phonenumbe|ademployee_emaildress|citemployee_addressy|stateemployee_dev_level|employee_gender |employee_hire_date     |employee_onleave |
|fist name is missing  				|1631825833|									 |Smith					    |264-783-9453				|johnSmith@gmail.com	|Reston							 |Virginia							 |male						|2025-10-31T163545.426Z	| true						|     
|last name is missing 				|1631825833|John							 |					    		|264-783-9453				|johnSmith@gmail.com	|Reston							 |Virginia							 |male						|2025-10-31T163545.426Z	| true						|     
|phone number is missing 			|1631825833|John							 |Smith					    |										|johnSmith@gmail.com	|Reston							 |Virginia							 |male						|2025-10-31T163545.426Z	| true						|     
|email is missing 						|1631825833|John							 |Smith					    |264-783-9453				|											|Reston							 |Virginia							 |male						|2025-10-31T163545.426Z	| true						|     
|city is missing				 			|1631825833|John							 |Smith					    |264-783-9453				|johnSmith@gmail.com	|										 |Virginia							 |male						|2025-10-31T163545.426Z	| true						|     
|state is missing						 	|1631825833|John							 |Smith					    |264-783-9453				|johnSmith@gmail.com	|Reston							 |									 		 |male						|2025-10-31T163545.426Z	| true						|     
|gender is missing 					  |1631825833|John							 |Smith					    |264-783-9453				|johnSmith@gmail.com	|Reston							 |Virginia							 |    						|2025-10-31T163545.426Z	| true						|     
|hire date is missing				 	|1631825833|John							 |Smith					    |264-783-9453				|johnSmith@gmail.com	|Reston							 |Virginia							 |male						|										  	| true						|     
|on leave is missing				 	|1631825833|John							 |Smith					    |264-783-9453				|johnSmith@gmail.com	|Reston							 |Virginia							 |male						|2025-10-31T163545.426Z	| 								|     
 
 


 
 
 
  
 
   
