# Spring REST Assessment - Quick Start Guide

## ✅ All Assessment Requirements - IMPLEMENTED

| # | Requirement | Implementation | Status |
|---|-------------|-----------------|--------|
| 1 | Spring Core - Load Country from Spring Configuration XML | `applicationContext.xml` + `@ImportResource` | ✅ |
| 2 | Hello World RESTful Web Service | `HelloWorldController.java` | ✅ |
| 3 | REST - Country Web Service | `CountryController.java` (CRUD) | ✅ |
| 4 | REST - Get country based on country code | `GET /api/countries/{code}` | ✅ |
| 5 | Create authentication service that returns JWT | `AuthenticationService.java` + `JwtUtil.java` | ✅ |

---

## 🚀 Quick Start (5 minutes)

### Step 1: Build Project
```bash
cd SpringREST
mvn clean install
```

### Step 2: Run Application
```bash
mvn spring-boot:run
```

Application starts on: `http://localhost:8080`

### Step 3: Test Hello World
```bash
curl http://localhost:8080/api/hello/world
```

Expected Response: `"Hello World from Spring REST API!"`

---

## 🧪 Testing All Requirements

### Requirement 1: Spring Core - Load Country from XML
```bash
curl http://localhost:8080/api/countries/xml/config
```
Returns Country bean loaded from `applicationContext.xml`

### Requirement 2: Hello World REST
```bash
curl http://localhost:8080/api/hello/world
```

### Requirement 3 & 4: Country Web Service & Get by Code
```bash
# Get all countries
curl http://localhost:8080/api/countries

# Get specific country
curl http://localhost:8080/api/countries/IN
```

### Requirement 5: JWT Authentication
```bash
# 1. Login and get JWT token
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"password123"}'

# Response: JWT token

# 2. Validate token
curl "http://localhost:8080/api/auth/validate?token=<JWT_TOKEN>"
```

---

## 📁 Project Structure

```
SpringREST/
├── src/main/java/com/cognizant/rest/
│   ├── SpringRestApplication.java          # Main application
│   ├── model/
│   │   ├── Country.java
│   │   ├── AuthRequest.java
│   │   └── AuthResponse.java
│   ├── service/
│   │   ├── CountryService.java
│   │   └── AuthenticationService.java
│   ├── controller/
│   │   ├── HelloWorldController.java
│   │   ├── CountryController.java
│   │   └── AuthenticationController.java
│   └── security/
│       └── JwtUtil.java
├── src/main/resources/
│   ├── application.properties
│   └── applicationContext.xml              # Spring XML Config
├── pom.xml
├── README_ASSESSMENT.md
├── QUICK_START.md                          # This file
└── Postman_Collection.json
```

---

## 🔑 Demo Credentials

**Username**: `admin`  
**Password**: `password123`

---

## 📊 12 REST Endpoints

### Hello World (3 endpoints)
```
GET /api/hello/world       - Hello greeting
GET /api/hello/greeting    - Welcome message
GET /api/hello/health      - Health check
```

### Country Management (6 endpoints)
```
GET    /api/countries          - Get all
GET    /api/countries/{code}   - Get by code
GET    /api/countries/xml/config - From XML
POST   /api/countries          - Add
PUT    /api/countries/{code}   - Update
DELETE /api/countries/{code}   - Delete
```

### Authentication (3 endpoints)
```
POST /api/auth/login           - Generate JWT
GET  /api/auth/validate        - Validate JWT
GET  /api/auth/test            - Test auth
```

---

## 🔗 Using Postman

1. **Open Postman**
2. **Click Import** → Select `Postman_Collection.json`
3. **Set variable** `base_url` to `http://localhost:8080`
4. **Start testing** endpoints in order

---

## 📚 Key Technologies

- **Spring Boot 3.2** - Latest framework
- **JWT (JJWT 0.12.3)** - Token generation
- **Spring Security** - Authentication
- **Spring Web MVC** - REST services
- **Maven** - Build tool
- **Java 17** - Latest LTS

---

## ✅ Verification Checklist

Before submission:
- [ ] Application starts without errors: `mvn spring-boot:run`
- [ ] Hello World endpoint works: `GET /api/hello/world`
- [ ] Get all countries works: `GET /api/countries`
- [ ] Get by code works: `GET /api/countries/IN`
- [ ] XML config loads: `GET /api/countries/xml/config`
- [ ] JWT login works: `POST /api/auth/login`
- [ ] JWT validation works: `GET /api/auth/validate`
- [ ] All 12 endpoints respond correctly

---

## 📝 Sample cURL Commands

```bash
# Get all countries
curl http://localhost:8080/api/countries

# Get country by code
curl http://localhost:8080/api/countries/IN

# Get from XML
curl http://localhost:8080/api/countries/xml/config

# Login (get JWT)
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"password123"}'

# Add country
curl -X POST http://localhost:8080/api/countries \
  -H "Content-Type: application/json" \
  -d '{"code":"FR","name":"France","capital":"Paris","continent":"Europe"}'

# Update country
curl -X PUT http://localhost:8080/api/countries/FR \
  -H "Content-Type: application/json" \
  -d '{"code":"FR","name":"French Republic","capital":"Paris","continent":"Europe"}'

# Delete country
curl -X DELETE http://localhost:8080/api/countries/FR
```

---

**Status**: ✅ ALL 5 REQUIREMENTS COMPLETE

See `README_ASSESSMENT.md` for detailed documentation.
