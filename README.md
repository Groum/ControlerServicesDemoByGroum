# Demo of using controlers Ser-
This Java Spring Boot application demonstrates implementation of Controllers services
and JPA. 
It also includes embedded Swagger to do API Tests
It includes REST endpoints to calculate monthly reward points for users
based on their Purchase.

The application utilizes an embedded H2 database for testing purposes and includes 
a method to populate the database with monthly payments for three users.

When the API is called with the specified month and user ID, 
the application returns the reward points for that particular month.

Additionally, the application includes two unit tests. 
One utilizes the embedded H2 database, 
while the other uses Mockito for mocking dependencies.

The application also incorporates Spring Boot Security with 
a SecurityFilterChain. To access the endpoints,
#Access
you can use the username _"Administrator"_ and the associated password.
Username: Administrator
Password: [pass]
These details are hardcoded within the user details service 
for testing purposes.

Please note that without specific code or further information, 
this description provides a general understanding of the application's features.

#Swager

Swagger is integrated into the application to test the endpoints. 
Use the url http://localhost:8080/swagger-ui.html

However, please note that you need to access the endpoints from your browser 
in order to populate the data into the database. 
example you can request 
http://localhost:8080/rewardPoints/1/5
The testing logic involves populating dummy data through code using H2 database.