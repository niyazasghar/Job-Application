# Job Application Microservices - Version 3

## 📚 **Table of Contents**
- [Description](#description)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Architecture Diagram](#architecture-diagram)
- [Installation Instructions](#installation-instructions)
  - [Prerequisites](#prerequisites)
  - [Clone the Repository](#clone-the-repository)
  - [Setup Keycloak](#setup-keycloak)
  - [Setup Eureka Server](#setup-eureka-server)
  - [Setup Config Server](#setup-config-server)
  - [Setup Gateway Server](#setup-gateway-server)
  - [Configure and Run Microservices with Resiliency](#configure-and-run-microservices-with-resiliency)
- [Accessing the Services](#accessing-the-services)
- [API Documentation](#api-documentation)
- [Authentication & Authorization](#authentication--authorization)
- [Resiliency & Circuit Breaker Implementation](#resiliency--circuit-breaker-implementation)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## 📝 **Description**
Version 3 of the Job Application microservices project enhances the architecture by introducing a **Gateway Server** for routing and load balancing, implementing **Authentication and Authorization** using **Keycloak**, and integrating **Resiliency** features such as **Circuit Breakers**. These additions bolster security, streamline client interactions, and ensure robust communication between services, building upon the foundational **Job**, **Company**, and **Reviews** services established in Versions 1 and 2.

## ✨ **Features**
- **Gateway Server:**
  - Acts as a single entry point for all client requests.
  - Handles routing, load balancing, and cross-cutting concerns like authentication.
  
- **Authentication & Authorization:**
  - Secured using **Keycloak**, providing robust identity and access management.
  - Supports role-based access control (e.g., `USER`, `ADMIN`).
  
- **Resiliency & Circuit Breakers:**
  - Ensures fault tolerance and prevents cascading failures using circuit breaker patterns.
  - Utilizes the `pybreaker` library for implementing circuit breakers.
  
- **Enhanced Microservices:**
  - **Job Service:** Integrates with Gateway, Keycloak, and resiliency mechanisms.
  - **Company Service:** Enhanced to utilize centralized configurations, register with Eureka, and incorporate resiliency features.
  - **Reviews Service:** Updated to fetch configurations from Config Server, discover other services via Eureka, and implement resiliency patterns.

## 🛠 **Technologies Used**
- **API Gateway:** FastAPI-based Gateway
- **Authentication & Authorization:** Keycloak
- **Service Discovery:** Eureka Server
- **Configuration Management:** Config Server using FastAPI
- **Resiliency:** `pybreaker` (Circuit Breakers)
- **Backend Framework:** FastAPI (Python)
- **Database:** PostgreSQL
- **ORM:** SQLAlchemy (asynchronous support with `asyncpg`)
- **API Documentation:** Swagger/OpenAPI
- **Containerization:** Docker (Recommended)
- **Version Control:** Git

## 🖼 **Architecture Diagram**
*(Include an updated architecture diagram here to visualize the interactions between services, Gateway Server, Keycloak, Config Server, and Eureka Server.)*

## 🚀 **Installation Instructions**

### 🔧 **Prerequisites**
- **Python 3.8+**
- **PostgreSQL Database**
- **Git**
- **Virtual Environment Tool:** `venv` or `virtualenv`
- **Docker** *(Recommended for Keycloak, Eureka Server, and Config Server)*
- **Docker Compose** *(Optional, for orchestrating multiple containers)*

### 📥 **Clone the Repository**
```bash
git clone https://github.com/your-username/job-application-microservices.git
cd job-application-microservices/version3
