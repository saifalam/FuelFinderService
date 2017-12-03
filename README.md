How to run
===

1. Start the container using following command:

```
# build the container 

docker build -t java-mysql-server . 

# run the server 

docker run -it -p 9000:8080 -p 3306:3306 -v $(pwd):/appdev --name appserver java-mysql-server  


# dev mode

docker run -it -p 9000:8080 -p 3306:3306 -v $(pwd):/appdev --name appserver java-mysql-server bash 
```
