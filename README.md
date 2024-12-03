# Microservices Management System

This project is a microservices-based application built with **Spring Boot**, **PostgreSQL**, and **Docker**. It simulates an order management system where each microservice is modularized and communicates via **RestTemplate**.

---

## Technologies Used

- 🌐 **Java 17** with **Spring Boot**
- 📦 **PostgreSQL** for database
- 🐳 **Docker** for containerization
- 🔗 **RestTemplate** for inter-service communication
- 🛠️ **Spring Data JPA** for persistence
- 📖 **Swagger** for API documentation

---

## Microservices Architecture

The system is composed of the following services:

1. **Client**
   - Manages clients (registration, updates, and order history).
   - Default port: `8083`.

2. **Stock**
   - Manages products and inventory.
   - Default port: `8082`.

3. **Order**
   - Handles order creation and checks stock availability.
   - Default port: `8081`.

---

