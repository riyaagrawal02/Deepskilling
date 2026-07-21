# Microservices Architecture

This folder contains a complete microservices ecosystem with service discovery and API gateway.

## Architecture Overview

```
┌─────────────────────────────────────────────────────────────┐
│                    API Gateway (9090)                       │
│         (Spring Cloud Gateway with LogFilter)               │
└────────────────────┬────────────────────────────────────────┘
                     │
        ┌────────────┼────────────┬──────────────┐
        │            │            │              │
   ┌────▼────┐ ┌────▼───┐ ┌─────▼────┐  ┌──────▼──────┐
   │ Account  │ │ Loan   │ │   Greet  │  │   Eureka    │
   │ Service  │ │Service │ │ Service  │  │   Server    │
   │ (8080)   │ │ (8081) │ │ (8082)   │  │   (8761)    │
   └──────────┘ └────────┘ └──────────┘  └─────────────┘
```

## Services

### 1. Eureka Discovery Server (Port 8761)
- Centralized service registry
- All microservices register with Eureka on startup
- Access dashboard at `http://localhost:8761`

**Configuration:**
- `server.port=8761`
- `eureka.client.register-with-eureka=false`
- `eureka.client.fetch-registry=false`

### 2. Account Service (Port 8080)
- Microservice for account management
- **Endpoint:** `GET /accounts/{number}`
- **Response:** `{"number": "00987987973432", "type": "savings", "balance": 234343}`
- Registers with Eureka as `account-service`

### 3. Loan Service (Port 8081)
- Microservice for loan management
- **Endpoint:** `GET /loans/{number}`
- **Response:** `{"number": "H00987987972342", "type": "car", "loan": 400000, "emi": 3258, "tenure": 18}`
- Registers with Eureka as `loan-service`

### 4. Greet Service (Port 8082)
- Simple microservice for greeting
- **Endpoint:** `GET /greet-service/greet`
- **Response:** `"Hello World!!"`
- Registers with Eureka as `greet-service`

### 5. API Gateway (Port 9090)
- Spring Cloud Gateway for routing requests to microservices
- Routes requests based on service name
- **Features:**
  - Global LogFilter logs all request URLs
  - Discovery locator enabled for dynamic routing
  - Routes to services via their registered names
  - Lowercase service IDs for URL routing

## Running the Microservices

### Prerequisites
- Java 21
- Maven 3.6+
- MySQL (for future enhancements)

### Build All Services
```bash
# In eureka-discovery-server directory
mvn clean package

# In account directory
mvn clean package

# In loan directory
mvn clean package

# In greet-service directory
mvn clean package

# In api-gateway directory
mvn clean package
```

### Start Services (in this order)
```bash
# 1. Start Eureka Server first (required for service registration)
cd eureka-discovery-server
java -jar target/eureka-discovery-server-0.0.1-SNAPSHOT.jar

# 2. Start Account Service (in another terminal)
cd account
java -jar target/account-0.0.1-SNAPSHOT.jar

# 3. Start Loan Service (in another terminal)
cd loan
java -jar target/loan-0.0.1-SNAPSHOT.jar

# 4. Start Greet Service (in another terminal)
cd greet-service
java -jar target/greet-service-0.0.1-SNAPSHOT.jar

# 5. Start API Gateway (in another terminal)
cd api-gateway
java -jar target/api-gateway-0.0.1-SNAPSHOT.jar
```

## Testing Endpoints

### Direct Service Calls
```bash
# Account Service (Direct)
GET http://localhost:8080/accounts/00987987973432

# Loan Service (Direct)
GET http://localhost:8081/loans/H00987987972342

# Greet Service (Direct)
GET http://localhost:8082/greet-service/greet
```

### Via API Gateway
```bash
# Account Service via Gateway
GET http://localhost:9090/account-service/accounts/00987987973432

# Loan Service via Gateway
GET http://localhost:9090/loan-service/loans/H00987987972342

# Greet Service via Gateway
GET http://localhost:9090/greet-service/greet
```

### Service Registry
Access Eureka Dashboard: `http://localhost:8761`

You should see:
- account-service registered
- loan-service registered
- greet-service registered
- api-gateway registered

## Key Technologies

- **Spring Boot 3.2** - Latest LTS version
- **Spring Cloud 2023.0.0** - Microservices framework
- **Netflix Eureka** - Service discovery
- **Spring Cloud Gateway** - API Gateway
- **Java 21** - Programming language

## Project Structure

```
Microservices/
├── eureka-discovery-server/     # Service registry
│   ├── pom.xml
│   └── src/main/java/com/cognizant/eureka/
│       └── EurekaDiscoveryServerApplication.java
│
├── account/                      # Account Microservice
│   ├── pom.xml
│   └── src/main/java/com/cognizant/account/
│       ├── AccountApplication.java
│       ├── controller/
│       │   └── AccountController.java
│       └── model/
│           └── Account.java
│
├── loan/                         # Loan Microservice
│   ├── pom.xml
│   └── src/main/java/com/cognizant/loan/
│       ├── LoanApplication.java
│       ├── controller/
│       │   └── LoanController.java
│       └── model/
│           └── Loan.java
│
├── greet-service/               # Greet Microservice
│   ├── pom.xml
│   └── src/main/java/com/cognizant/greet/
│       ├── GreetServiceApplication.java
│       └── controller/
│           └── GreetController.java
│
├── api-gateway/                 # API Gateway
│   ├── pom.xml
│   └── src/main/java/com/cognizant/gateway/
│       ├── ApiGatewayApplication.java
│       └── filter/
│           └── LogFilter.java
│
└── README.md                     # This file
```

## Features

✅ **Service Discovery** - Automatic service registration and discovery via Eureka
✅ **API Gateway** - Single entry point for all microservices
✅ **Request Logging** - Global filter logs all incoming requests
✅ **Fault Isolation** - Each service runs independently
✅ **Scalability** - Services can be scaled independently
✅ **Spring Boot 3.2** - Latest LTS framework
✅ **Spring Cloud 2023.0.0** - Modern microservices stack

## Benefits of This Architecture

1. **Fault Isolation** - A failure in one service doesn't affect others
2. **Independent Scaling** - Services can be scaled based on demand
3. **Technology Flexibility** - Different technologies for different services
4. **Team Autonomy** - Teams can develop and deploy services independently
5. **API Gateway** - Unified interface for clients
6. **Service Discovery** - Dynamic service location without hardcoding URLs
