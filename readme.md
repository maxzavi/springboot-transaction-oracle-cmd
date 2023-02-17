# Java Spring Boot Sample transactions in Oracle database using maven

Create Spring Boot project with maven, using dependencies:

- Oracle Driver
- JDBC API

Implements **CommandLineRunner** and add **run** method

```java
public class DemotransactionbdApplication implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
```

Add logging using **slf4j**

```java
public class DemotransactionbdApplication implements CommandLineRunner {
    //Add Logger
	private static Logger LOG = LoggerFactory.getLogger(DemotransactionbdApplication.class);
```

## Setting Connection Parameters

Use application.properties **Exclude from control version for Security**
```properties
spring.datasource.url=jdbc:oracle:thin:@{host}:{port}:{sid}
spring.datasource.username={username}
spring.datasource.password={password}
```

Container use environment variables: **SPRING__DATASOURCE__URL** **SPRING__DATASOURCE__USERNAME** **SPRING__DATASOURCE__PASSWORD** 

