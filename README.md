#Writing a README for NagarroApp Project 
To view bank account statement based on the input parameter

#PORT
KINDLY USE PORT : 8081

#Session
Session out time set for 5 mins

#Users USED 
How the code and test can be run: 
USER ROLES 
1. username : user 
   password : user 
   
2.ADMIN 
    username  : admin
	password : admin
	
#Database
Used the provided access DB as a file in project. So the file path is from local system. Kindly change the path in application.properties prior torunning the application.

# How to Run Application: 

1. Clone the Project With command : git clone from url https://github.com/sameekshapande/ViewBankstatement

2. Open the project in STS/Eclipse.

3. Right click on the project Run As -> Spring Boot App


# How to test Application from browser through Swagger: 

Steps to Run : 

Go to Swagger :  http://localhost:8081/swagger-ui.html

1. For parameterized request : that is with specific Date range and Amount Range having accountId as mandate field and if no parameters are mentioned three months of payslip will be visible(For testing purpose made it to 20 as there was no data for 3 months) 
	API : /api/rest/accountstatement/statementByAccId 
	Accessible to Only : ADMIN
	Sample Request :
			 {
			  "accountId": 3,
			  "fromAmt": "",
			  "fromdate": "02.09.2020",
			  "role": "",
			  "toAmt": "",
			  "todate": "04.02.2021"
			 }

	Validation are handled such as :
	1.From date should not be greater than to date
	2.Date Format should be always : DD.MM.YYYY
	3.To Amount should be greater than from date



	Sample Response : 
	{
	  "status": "Success",
	  "responseMessage": "Retrieved Statement for given Criteria",
	  "accountStatementDetailList": [
		{
		  "accountType": "current",
		  "accountNumber": "a1c7a6c39da4203dda813bc911e85d0f9ecd614ffbea28574432c7660587ead3",
		  "datefield": "24.01.2021",
		  "amount": "564.982890505824"
		}
	  ]
	}

2. For Requests having only Account ID 3 months bank statement will be fetched (For test purpose given 20 months for now)
	API :  /api/rest/accountstatement/statementByUser
	Accessible to  : ADMIN	and USER both
	Sample Request :
			 {
			  "accountId": 3,
			  "fromAmt": "",
			  "fromdate": "",
			  "role": "",
			  "toAmt": "",
			  "todate": ""
			 }

	Sample Response :
	{
  "status": "Success",
  "responseMessage": "Retrieved Statement for given Criteria",
  "accountStatementDetailList": [
    {
      "accountType": "current",
      "accountNumber": "a1c7a6c39da4203dda813bc911e85d0f9ecd614ffbea28574432c7660587ead3",
      "datefield": "09.08.2020",
      "amount": "535.197875027054"
    },
    {
      "accountType": "current",
      "accountNumber": "a1c7a6c39da4203dda813bc911e85d0f9ecd614ffbea28574432c7660587ead3",
      "datefield": "03.09.2020",
      "amount": "623.461804295262"
    },
    {
      "accountType": "current",
      "accountNumber": "a1c7a6c39da4203dda813bc911e85d0f9ecd614ffbea28574432c7660587ead3",
      "datefield": "03.02.2020",
      "amount": "330.455004587924"
    },
    {
      "accountType": "current",
      "accountNumber": "a1c7a6c39da4203dda813bc911e85d0f9ecd614ffbea28574432c7660587ead3",
      "datefield": "19.05.2020",
      "amount": "125.51573044332"
    },
    {
      "accountType": "current",
      "accountNumber": "a1c7a6c39da4203dda813bc911e85d0f9ecd614ffbea28574432c7660587ead3",
      "datefield": "15.09.2020",
      "amount": "87.8901139771573"
    }

  ]
}


# How to run JUNIT Coverage For Application :

1. Right Click on the project on STS/Eclipse .

2. Choose the coverage As -> JUnit Test 