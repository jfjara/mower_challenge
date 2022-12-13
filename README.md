# Mower challenge

to run application:

execute the attached .bat  -> run.bat. This command compile, tested and execute the jar.

If you want you can use maven commands to compile, to test or to run the application

mvn clean package  / mvn clean install
mvn test
mvn exec:java

# Instructions

Input data to the program:

You must follow the rules in format input data.

Board size: Number Space Number  / example: 5 5
Set mower position: Number Space Number CardinalDirection (N,S,E,W) / Example: 1 1 N
Set list of commands: list of commands (LRM) without spaces. No size restrictions. / Example: LLMMMRLMMRM

If the entry does not satisfy the format you must enter the data again.