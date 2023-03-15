# iin-parser

This is a Java-based IIN (Issuer Identification Number) parser that uses Java 8, Lombok, JUnit, and SLF4J. The application allows users to test and verify a PAN (Primary Account Number) against the IIN PAN (Issuer Identification Number Primary Account Number) database.

## Usage

To test this application on your local machine, follow these steps:

1. Clone the repository: `git clone https://github.com/IvanSCap/iin-parser.git`
2. Create a JAR file for the application: `mvn clean package`
3. Test the application using this command: `java -jar iinparser-1.0-SNAPSHOT.jar`
4. To test your own PAN, add it as an argument at the end: `java -jar iinparser-1.0-SNAPSHOT.jar 4444444444444444`

## Test Coverage

The test coverage for this application can be seen in the following image:

![image](https://user-images.githubusercontent.com/124682080/225113186-adb7d1d8-a090-49f1-b915-5d2b7af22d0c.png)

## Running Tests

To run tests for this application, use the following command:

`mvn test`

![image](https://user-images.githubusercontent.com/124682080/225114780-8abe56be-e01b-4fa2-8f20-5ccc527a1e1d.png)

## Online Usage

If you don't want to run the application on your own machine, you can use the following link: http://ec2-54-242-142-182.compute-1.amazonaws.com:9090/format?pan=4242424242424242

You can change 4242424242424242 -> your own PAN.


