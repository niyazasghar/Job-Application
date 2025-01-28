# Job Application Microservices - Version 1

## 📚 **Table of Contents**
- [Description](#description)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Architecture Diagram](#architecture-diagram)
- [Installation Instructions](#installation-instructions)
  - [Prerequisites](#prerequisites)
  - [Clone the Repository](#clone-the-repository)
  - [Setup the Database](#setup-the-database)
  - [Create Virtual Environments and Install Dependencies](#create-virtual-environments-and-install-dependencies)
  - [Apply Database Migrations](#apply-database-migrations)
  - [Run Services](#run-services)
- [Accessing the APIs](#accessing-the-apis)
- [API Documentation](#api-documentation)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## 📝 **Description**
Version 1 of the Job Application is built using a microservices architecture, comprising three core services:
- **Job Service:** Manages job listings.
- **Company Service:** Handles company information.
- **Reviews Service:** Manages reviews related to jobs and companies.

Each service provides complete CRUD (Create, Read, Update, Delete) operations, enabling modular development and scalability.

## ✨ **Features**
- **Job Service:**
  - Create, read, update, and delete job listings.
- **Company Service:**
  - Create, read, update, and delete company information.
- **Reviews Service:**
  - Create, read, update, and delete reviews associated with jobs and companies.

## 🛠 **Technologies Used**
- **Backend Framework:** FastAPI (Python)
- **Database:** PostgreSQL
- **ORM:** SQLAlchemy (asynchronous support with `asyncpg`)
- **API Documentation:** Swagger/OpenAPI
- **Version Control:** Git

## 🖼 **Architecture Diagram**
*(Include an architecture diagram here if available)*

## 🚀 **Installation Instructions**

### 🔧 **Prerequisites**
- **Python 3.8+**
- **PostgreSQL Database**
- **Git**
- **Virtual Environment Tool:** `venv` or `virtualenv`

### 📥 **Clone the Repository**
```bash
git clone https://github.com/your-username/job-application-microservices.git
cd job-application-microservices/version1
