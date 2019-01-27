About Student-Service

1.	Student-Service perform Create, Read and Delete operation on Student data which is saved in H2 in-memory database
2.	Logger lines are defined in src/main/resources/application.properties
3.	Spring data JPA have used

Use following details to add Student
	URL - http://localhost:8080/student/add
	METHOD - POST
	Request Body-	
		{
			"fName": "Vishal",
			"lName": "Nimbalkar",
			"standard": "B.E. F.Y",
			"totalMarks": "650"
		}
	
	Response Body -		
		{
		    "rollNo": 1,
		    "fName": "Vishal",
		    "lName": "Nimbalkar",
		    "standard": "B.E. F.Y",
		    "totalMarks": "650",
		    "universityName": "Pune Univesity"
		}
		
----------------------------------------------------------------------------------------------------
Use following details to get list of all Students
	URL - http://localhost:8080/student/list
	METHOD - GET 
	Response Body - 
		[
		    {
		        "rollNo": 1,
		        "fName": "Vishal",
		        "lName": "Nimbalkar",
		        "standard": "B.E. F.Y",
		        "totalMarks": "650",
		        "universityName": "Pune Univesity"
		    }
		]

----------------------------------------------------------------------------------------------------	
Use following details to particular student details
	URL - http://localhost:8080/student/detail/1
	METHOD - GET 
	Response Body - 
	    {
	        "rollNo": 1,
	        "fName": "Vishal",
	        "lName": "Nimbalkar",
	        "standard": "B.E. F.Y",
	        "totalMarks": "650",
	        "universityName": "Pune Univesity"
	    }
	
----------------------------------------------------------------------------------------------------
Use following details to remove Student
	URL - http://localhost:8080/student/remove/1
	METHOD - DELETE
	Response Body -
		Student Have removed having RollNo = 1
		
		
----------------------------------------------------------------------------------------------------
Use following details to login and walk-through H2 DB details. You will find login related information in src/main/resources/application.properties file.

URL - http://localhost:8080/h2

<img src="/img/H2_Login_Screen.jpg" alt="H2 login Screen"/>


Use Sql queries to view details from Tables.


----------------------------------------------------------------------------------------------------
Test cases details

Test cases are available under src/test/java with named "StudentServiceImpl.java".

Test class is annotated with following annotations

@RunWith(SpringRunner.class) - It is Runner class. In our case it is SpringRunner class
@SpringBootTest - Annotation that can be specified on a test class that runs Spring Boot based tests.
@TestConfiguration - Bean autowiring is managed. This is static class
