# jersey-service-client

## Build the server
_____
    cd jersey-server
    mvn clean install

## Deploy the sever
____
    copy the war file from target/jersey-helloworld-server.war to tomcat/webapps

## Run the server
    Run the tomcat, by default it runs at port 8080

## Target URL:
___
    Default target url is: http://localhost:8080/jersey-helloworld-server/rest/resource

## REST Endpoints:
___
    /add-student
    /get-student
    /update-student
    /delete-student
    /add-subject
    /get-subject
    /update-subject
    /delete-subject
    /add-group
    /get-group
    /update-group
    /delete-group
    /add-student-group
    /remove-student-group
    /add-group-subjects
    /remove-group-subjects
    /add-student-subject-note
    /update-student-subject-note
    /delete-student-subject-note
    /show-results

## Build the REST Client
_____
    cd jersey-client
    mvn clean install
