
<div align=right>
  
[![Java Version](https://img.shields.io/badge/Java-21%2B-orange)](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
</div>

# User service SECP
This is a e comerce platform using microservices architecture in Springboot and Java 21. This proyect handle various aspects of an online store, such as product catalog management, user authentication, 
shopping cart, payment processing, and order management.

> [!NOTE]
> Proyect requirements from <a href="https://roadmap.sh/projects/scalable-ecommerce-platform"> roadmap.sh </a>.

## How to use 

### Prerequisites

- Java 21+ (or the version required by the project)
- Maven 3.6+
- PostgreSQL (or the database used by the project) running and accessible
- Environment variables or application.properties configured with the correct database credentials

1. Clone the repository 
```bash
git clone <repository-url>
cd <project-name>
```

2. Configure the database 
Edit the file `src/main/resources/application.properties with your database connection details.
```yml 
spring.datasource.url=jdbc:postgresql://localhost:5432/database_name
spring.datasource.username=db_user
spring.datasource.password=db_password
spring.datasource.driver-class-name=org.postgresql.Driver
```

3. Clean and install the proyect dependencies 
```bash 
mvn clean install 
```

4. Run the application
```bash 
mvn spring-boot:run
```
5. Open the API doc
```bash 
http://localhost:8080/swagger-ui/index.html#/
```


> [!NOTE]
> This proyect uses this data base:  <a href="https://github.com/untalbry/scalable-e-commerce-db"> Scalable E commerce platform Data base </a>.
