# Myapi
Simple RESTful Api for getting information about users

## Technologies
* Java - version 11
* Spring Boot - version 2.2.2

## Features
Get data from H2 database by endpoints:
* http://localhost:8080/users - to get information about all users (first name and last name)
* http://localhost:8080/users/{id} - to get information about one user (first name, last name, date of birth and account balance)

## Setup
To run this application, instal it locally:
cd ../myapi
mvnw spring-boot:run
or
mvnw clean install
mvnw -jar target/myapi-0.0.1-SNAPSHOT.jar
