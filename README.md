MINIPROJECT

This Project is based on Spring boot, JPA, Java 8, Git and Gradle.  
As a database I used H2 in memory.

I used The Spring tool suite ide to create the project.

In order to run this application you need to right click the main application folder and select Run As --> Spring boot app
this way the application will use the embedded tomcat tu run.

once you have the application running you can try the services on localhost:8080

To get all employees localhost:8080/employee
To get specific employee by id localhost:8080/employee/{id}
To Update an employee localhost:8080/employee/{id} and in the body of the request send the new values for the employee in JSON format.
To delete an employee localhost:8080/employee/{id}/{pwd} the value for pwd will be as a password to avoid people without permision can delete records
the password will be "abc".
To create an employee localhost:8080/employee and in the body of the request send the employee values to create a new employee.

The design pattern I used was MVC 
The reason was that I believe is easy to control each part from the project dividing in model view and controller that way each part can do specific tasks and low coupling.

