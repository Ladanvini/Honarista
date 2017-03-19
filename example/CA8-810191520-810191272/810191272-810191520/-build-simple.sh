#!/bin/bash
rm -rf bin/*
javac -classpath gson-2.6.2.jar -sourcepath src -d bin src/*/*.java

if [ $? -eq 0 ]; then
	#nodejs testGen.js > test
    cd bin
    echo "Starting Server"
    java -cp .:../gson-2.6.2.jar cli.CLI < ../test 
fi
