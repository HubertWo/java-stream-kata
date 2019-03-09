# Java Stream Kata

> A code kata is an exercise in programming which helps programmers hone their skills through practice and repetition.
> <cite>https://en.wikipedia.org/wiki/Kata_(programming)</cite>

This repository contains different tasks related to Java Streams. 

## Leave a star :)
If you like the content do not forget to leave a star at the top right corner. Thank you!

## Setup
Minimal setup is required. Tools you will need:
 - Java 9+ 
 - Maven
 - IDE (In my case IntelliJ IDEA)
 
## How to run exercises
Each exercise is an jUnit test. 
You can run test from both Maven or any modern IDE. 

## Where are solutions?
Each task has solution in "Click here to see the answer" block.

<img src="https://github.com/HubertWo/java-stream-kata/blob/master/img/solution.png?raw=true" width="500px">

### Maven
To check *task1* from *Basics* package:
```
mvn surefire:test -Dtest=BasicsTest#task1
```

### IDE
After importing project press "Play" near the test you want to run.

## More
- Java Stream API: https://docs.oracle.com/javase/9/docs/api/java/util/stream/package-summary.html
- How to run single test using Maven : https://maven.apache.org/surefire/maven-surefire-plugin/examples/single-test.html
- How to run single test using IntelliJ IDEA: https://www.jetbrains.com/help/idea/performing-tests.html 