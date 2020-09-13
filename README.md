###############################################################################################
########################### Java Backed APIs for Feature Request App ##########################

#Technology Stack
1. Java 8
2. Spring Boot
3. Maven
4. Rest API
5. Hibernate
6. H2 Database
7. JUnit
8. Logging

# APIs  Descriptions

1. Accepts the requests from Client App and Create the new Feature Request and Stores in Database 

# Request Format

URL: http://localhost:8080/feature/request/newRequest

{
    "title": "String",
    "description": "String",
    "client":"String",
    "priority": Int,
    "targetDate": Date,
    "parea": "String"
}


2. Provides the all feature requests from all the Client

# Request Format 

URL: http://localhost:8080/feature/request/getAllClients

GET request directly consumes all the requests by {http://localhost:8080/feature/request/getAllClients} if there is no requests records in DB it returns empty response


3. Provides the all feature requests for specific Client

# Request Format 

URL: http://localhost:8080/feature/request/getByClient?client={client}

Request must contains Request Param "client" name then api will provide the all the requests made for that client


# Enhancements

1. Can be Develop another API to Delete previously requested based on Client name or Request ID
2. Can be add more Request/Response validations for each APIs and return proper error messages accordingly
3. Can be add more logging for debugging
4. Can be add more tests for code coverage and Unit tests using Junit and Mockito
5. Can be add tests for Data base schema
6. Can be Provide the feature request records by Product area also by adding another api which accepts the Product are field




