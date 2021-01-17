# FizzBuzz
## Introducting the project
### How does FizzBuzz game works?
Numbers must be said in ascending order starting from a given integer no smaller than 1. If the upcoming number is divisible by 3 then "fizz" must be said instead, if it is divisible by 5 then "buzz" replaces the number and if it is divisible by both then the result is "fizzbuzz".
### Main objective
Designing a WebAPI or WebService RESTful that is able to return a list of strings representing the succession of numbers and "fizz"/"buzz"/"fizzbuzz" words according to the rules previously described. The service can take an integer as a parameter to determine the starting number for the game. The last number to be played is specified in a properties file consumed by the service. Moreover, the list of strings returned by the service has to be printed in a plain text file with the corresponding timestamp. This method must be able to handle up to 100 calls per second, avoiding bottlenecks and keeping consistency in the format of the messages being printed.
### Additional technical requisites
1. Separate responsibilities in separate layers: distributed services, application and domain.
2. Print errors in a log file defining tracking levels in a configuration file.
3. Manage exceptions throughout the whole code (every function must have try/catch). 
4. Create and handle at least one custom exception that extends Exception and includes possible null values control.
5. Implement unit tests and at least one integration test that can cover the whole application.
6. Proper naming convections and SOLID principles. Don't include helper or utils classes.
7. Create properties file that contain the main configuration of the app.
8. Take advantage of multithreading to boost the application performance or justify its absence.
9. Use any Dependency Injection, Unit Testing, Mocking frameworks or any other that are considered necessary.
## Explaining my solution
### Algorithm for FizzBuzz
First some labels that will be used:
- **maxNum**: the integer number that closes the game, so it's the last one to be played in FizzBuzz.
- **initNum**: the integer number that will be sent by the user and represents the first number to be played in FizzBuzz.
- **curNum**: the current integer number that will be either typed straight or translated into one of the three possible words.
- **curStr**: the string representing every turn in the game that can either have the number itself or one of the three possible words as value.
- **wholeStr**: the list of strings representing the whole game.
FizzBuzz does not seem too challenging to code based on the rules. There may be more optimal solutions but here's what I've come with written in metacode:
```
wholeStr = empty list of strings
loop (curNum = initNum; as long as curNum < maxNum; every iteration adds 1 to curNum) {
    curStr = null
    if (curNum divided by 3 returns 0 as remainder)
        curStr = "fizz"
    if (curNum divided by 5 returns 0 as remainder)
        curStr = curStr + "buzz"
    if (curStr is still null)
        curStr = curNum as string
    add curStr to wholeStr
}
```
### Technologies used
I will go for a WebService RESTful written in Java since it is the language I am more familiar with. Some of the tools, frameworks or libraries that will be used in the project:
- Maven: great for managing packages, versions, etc.
- Log4j: makes the logging process way easier.
- JUnit: really useful for unit testing in Java.
### How will we meet every requirement?
This section will be written on the way, as I find ways to meet every requirement:
- **SOLID architecture**:
    - **S (Single Responsibility Principle)**: Classes have been created for a single purpose. There is an Application class that runs the program and all the necessary Spring initialization, a REST Controller that handles requests and forward them to the business logic, a GameProcessor responsible of validating the input data and then solving the FizzBuzz game with our own algorithm and finally a Game class that holds the data representation.
