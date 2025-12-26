# Setup & Run

## Prerequisites
- Java 17 or later
- Maven 3.6+

## Build
```bash
mvn clean compile
```

## Run
```bash
mvn exec:java -Dexec.mainClass="com.airtripe.librarymanagement.Main"
```

(If you don't have `exec-maven-plugin` configured, run compiled classes directly via `java`.)

## Test
```bash
mvn test