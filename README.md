# Getting Started

### Spring Boot + Spring MVC Java Practical by Adiel Isaacs 

* Spring Boot / H2 Database - Loads defaulted users into a Users Table.The database is stored on local windows c:/data
* Spring Boot / Spring Security / Spring MVC - In-Memory Authentication happens by configuring the application context in the resource folder and uses Repository design pattern to retrieve data from the database. 
* Spring REST - configures all uri's which starts with /api/* and each service is exposed as JSON format   
* Spring MVC - uses a Controller which acts as a Rest Client to utilize the api. The Home controller Processes all data that is retrieved via Rest Template and JAVA core. 
* JSTL/Bootstrap is used to display and design each page accordingly 
* the application is built with MAVEN and Spring boot

## How to Run the Application

* Use Spring Tools Suite for eclipse OR eclipse STS  
* unzip the application in your workspace 
* import the the project into your workspace 
* The project was compiled with JDK/JRE 1.8.0 131 (setup first)
* run a Maven install cmd (Maven Has to be Installed on your computer)
* right click the application and run as Spring Boot application or run the JAR file build by maven 
* open a browser within eclipse and access the application on the following URl
* http://localhost:8080/login    

## Rest Api urls

* http://localhost:8080/api/adduser
* http://localhost:8080//api/users
* http://localhost:8080/api/usersByName (used as the login url)
* http://localhost:8080//api/usersDummy
