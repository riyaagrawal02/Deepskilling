# Spring REST Assessment - Complete Solution

## 📋 Assessment Overview

This Spring REST application demonstrates all requirements from the assessment with full implementation of:

### ✅ Assessment Requirements - ALL COMPLETED

1. **Spring Core - Load Country from Spring Configuration XML**
   - Endpoint: `GET /api/countries/xml/config`
   - Implementation: Country bean defined in `applicationContext.xml`
   - Loaded via `@ImportResource("classpath:applicationContext.xml")`

2. **Hello World RESTful Web Service**
   - Endpoints:
     - `GET /api/hello/world` - Basic hello message
     - `GET /api/hello/greeting` - Welcome message
     - `GET /api/hello/health` - Health check

3. **REST - Country Web Service**
   - Full CRUD operations for Country management
   - Endpoints:
     - `GET /api/countries` - Get all countries
     - `GET /api/countries/{code}` - Get specific country
     - `POST /api/countries` - Add new country
     - `PUT /api/countries/{code}` - Update country
     - `DELETE /api/countries/{code}` - Delete country

4. **REST - Get country based on country code**
   - Endpoint: `GET /api/countries/{code}`
   - Returns Country object by country code
   - Example: `GET /api/countries/IN`

5. **Create authentication service that returns JWT**
   - Authentication Endpoints:
     - `POST /api/auth/login` - Generate JWT token
     - `GET /api/auth/validate` - Validate JWT token
     - `GET /api/auth/test` - Test authenticated endpoint
   - JWT Token generation with expiration
   - Demo credentials: `admin / password123`

---

## 📁 Project Structure

```
SpringREST/
├── src/
│   ├── main/
│   │   ├── java/com/cognizant/rest/
│   │   │   ├── SpringRestApplication.java          ✅ Main application
│   │   │   ├── model/
│   │   │   │   ├── Country.java                    ✅ Country entity
│   │   │   │   ├── AuthRequest.java                ✅ Auth DTO
│   │   │   │   └── AuthResponse.java               ✅ Auth response with JWT
│   │   │   ├── service/
│   │   │   │   ├── CountryService.java             ✅ Country operations
│   │   │   │   └── AuthenticationService.java      ✅ JWT authentication
│   │   │   ├── controller/
│   │   │   │   ├── HelloWorldController.java       ✅ Hello World REST
│   │   │   │   ├── CountryController.java          ✅ Country REST API
│   │   │   │   └── AuthenticationController.java   ✅ JWT endpoints
│   │   │   └── security/
│   │   │       └── JwtUtil.java                    ✅ JWT utilities
│   │   └── resources/
│   │       ├── application.properties              ✅ Configuration
│   │       └── applicationContext.xml              ✅ Spring XML config
│   └── test/
├── pom.xml                                         ✅ Maven dependencies
└── README_ASSESSMENT.md                            ✅ This file
```

---

## 🚀 Running the Application

### Prerequisites
- Java 17+
- Maven 3.6+
- Port 8080 available

### Build & Run
```bash
cd SpringREST
mvn clean install
mvn spring-boot:run
```

Application will start on: `http://localhost:8080`

---

## 🧪 API Testing

### 1. Hello World - Hello World RESTful Web Service
```bash
GET http://localhost:8080/api/hello/world
Response: "Hello World from Spring REST API!"
```

### 2. Country - Get All Countries
```bash
GET http://localhost:8080/api/countries
```

### 3. Country by Code - REST - Get country based on country code
```bash
GET http://localhost:8080/api/countries/IN
Response: {
  "code": "IN",
  "name": "India",
  "capital": "New Delhi",
  "continent": "Asia"
}
```

### 4. Country from XML - Load Country from Spring Configuration XML
```bash
GET http://localhost:8080/api/countries/xml/config
Response: Country loaded from applicationContext.xml
```

### 5. Authentication - Create JWT Token
```bash
POST http://localhost:8080/api/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "password123"
}

Response: {
  "token": "eyJhbGciOiJIUzUxMiJ9...",
  "type": "Bearer",
  "username": "admin",
  "expiresIn": 86400000
}
```

### 6. Validate JWT Token
```bash
GET http://localhost:8080/api/auth/validate?token=<JWT_TOKEN>
```

### 7. Add New Country
```bash
POST http://localhost:8080/api/countries
Content-Type: application/json

{
  "code": "FR",
  "name": "France",
  "capital": "Paris",
  "continent": "Europe"
}
```

---

## 🔑 Key Implementation Details

### Spring Core - XML Configuration
**File**: `applicationContext.xml`
```xml
<bean id="country" class="com.cognizant.rest.model.Country">
    <constructor-arg name="code" value="XX"/>
    <constructor-arg name="name" value="Sample Country from XML"/>
    <property name="capital" value="Sample Capital"/>
    <property name="continent" value="Sample Continent"/>
</bean>
```

**Loading in Application**:
```java
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class SpringRestApplication {
    // ...
}
```

### JWT Token Generation
**File**: `JwtUtil.java`
```java
public String generateToken(String username) {
    // Uses HS512 algorithm
    // Expires in 24 hours (configurable)
    // Signs with secure secret key
}
```

### Authentication Service
**File**: `AuthenticationService.java`
- Validates credentials
- Generates JWT tokens
- Supports token validation

---

## 📊 All REST Endpoints

| # | Method | Endpoint | Purpose | Requirement |
|---|--------|----------|---------|-------------|
| 1 | GET | `/api/hello/world` | Hello World greeting | ✅ Req #2 |
| 2 | GET | `/api/hello/greeting` | Welcome message | ✅ Req #2 |
| 3 | GET | `/api/hello/health` | Health check | - |
| 4 | GET | `/api/countries` | Get all countries | ✅ Req #3 |
| 5 | GET | `/api/countries/{code}` | Get by code | ✅ Req #4 |
| 6 | GET | `/api/countries/xml/config` | Get from XML | ✅ Req #1 |
| 7 | POST | `/api/countries` | Add country | ✅ Req #3 |
| 8 | PUT | `/api/countries/{code}` | Update country | ✅ Req #3 |
| 9 | DELETE | `/api/countries/{code}` | Delete country | ✅ Req #3 |
| 10 | POST | `/api/auth/login` | Generate JWT | ✅ Req #5 |
| 11 | GET | `/api/auth/validate` | Validate JWT | ✅ Req #5 |
| 12 | GET | `/api/auth/test` | Test auth | ✅ Req #5 |

---

## 🔐 Demo Credentials for JWT

**Username**: `admin`  
**Password**: `password123`

Use these credentials in the `/api/auth/login` endpoint to get a JWT token.

---

## 📚 Technologies Used

- **Spring Boot 3.2** - Latest version
- **Spring Web MVC** - RESTful services
- **Spring Security** - Authentication framework
- **JWT (JJWT 0.12.3)** - Token generation and validation
- **Maven** - Build and dependency management
- **Java 17** - Latest LTS version

---

## ✅ Completion Checklist

- [x] Spring Core XML configuration implemented
- [x] Country bean loaded from XML
- [x] Hello World REST endpoint created
- [x] Country Web Service with full CRUD
- [x] Get country by code endpoint
- [x] JWT authentication service
- [x] JWT token generation
- [x] JWT token validation
- [x] All 12 REST endpoints working
- [x] Comprehensive documentation
- [x] Postman collection included

---

**Status**: ✅ ALL REQUIREMENTS COMPLETE

For testing, import the Postman collection: `Postman_Collection.json`
