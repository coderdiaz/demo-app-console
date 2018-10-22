#!/bin/bash
# Compile Java files
docker run --rm -v $PWD:/app -w /app java:8 javac com/master/schoolcontrol/*.java

# Exec docker container for Java8
docker run -it -v $PWD:/app -w /app java:8 bash

# Compile the project
javac com/master/schoolcontrol/*.java

# Run the application
java com/master/schoolcontrol/Main