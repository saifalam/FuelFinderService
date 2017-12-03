#!/usr/bin/env bash

echo Starting mysql server 
service mysql restart 
sleep 3 


echo Starting web server 
#java -jar target/fuelfinder-0.0.1-SNAPSHOT.jar
mvn spring-boot:run


