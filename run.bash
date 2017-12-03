#!/usr/bin/env bash

echo Starting mysql server 
service mysql start 
sleep 3 

echo 
echo Starting web server 
#java -jar target/fuelfinder-0.0.1-SNAPSHOT.jar
mvn spring-boot:run


