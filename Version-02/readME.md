# Job Application Microservices - Version 2

## 📚 **Table of Contents**
- [Description](#description)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Architecture Diagram](#architecture-diagram)
- [Installation Instructions](#installation-instructions)
  - [Prerequisites](#prerequisites)
  - [Clone the Repository](#clone-the-repository)
  - [Setup Config Server](#setup-config-server)
  - [Setup Eureka Server](#setup-eureka-server)
  - [Configure and Run Microservices](#configure-and-run-microservices)
- [Accessing the Services](#accessing-the-services)
- [API Documentation](#api-documentation)
- [Configuration Management](#configuration-management)
- [Service Discovery](#service-discovery)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## 📝 **Description**
Version 2 of the Job Application microservices project enhances the architecture by introducing a **Config Server** for centralized external configuration management and a **Eureka Server** for service registry and discovery. These additions promote scalability, maintainability, and dynamic inter-service communication, building upon the foundational **Job**, **Company**, and **Reviews** services established in Version 1.

## ✨ **Features**
- **Config Server:**
  - Centralizes configuration for all microservices.
  - Enables dynamic configuration updates without redeploying services.
  - Supports multiple environments (e.g., development, production) through configuration profiles.
  
- **Eureka Server:**
  - Acts as a service registry for all microservices.
  - Facilitates dynamic discovery of services, enabling seamless inter-service communication.
  - Supports service load balancing and failover.

- **Updated Microservices:**
  - **Job Service:** Now integrates with Config and Eureka servers for configuration management and service discovery.
  - **Company Service:** Enhanced to utilize centralized configurations and register with the Eureka server.
  - **Reviews Service:** Updated to fetch configurations from the Config Server and discover other services via Eureka.

## 🛠 **Technologies Used**
- **Backend Framework:** FastAPI (Python)
- **Configuration Management:** Config Server using FastAPI
- **Service Discovery:** Eureka Server (Java-based)
- **Database:** PostgreSQL
- **ORM:** SQLAlchemy (asynchronous support with `asyncpg`)
- **API Documentation:** Swagger/OpenAPI
- **Containerization:** Docker (Optional)
- **Version Control:** Git

## 🖼 **Architecture Diagram**
*(Include an architecture diagram here to visualize the interactions between services, Config Server, and Eureka Server.)*

## 🚀 **Installation Instructions**

### 🔧 **Prerequisites**
- **Python 3.8+**
- **PostgreSQL Database**
- **Java 11+** *(Required for Eureka Server)*
- **Git**
- **Virtual Environment Tool:** `venv` or `virtualenv`
- **Docker** *(Optional, for containerization)*
- **Docker Compose** *(Optional, for orchestrating multiple containers)*

### 📥 **Clone the Repository**
```bash
git clone https://github.com/your-username/job-application-microservices.git
cd job-application-microservices/version2
