# E-Shop Microservices Project / Проект Интернет-Магазин (Микросервисы)

---

## English Version

### Project Overview
This is a sample e-commerce application built using **Spring Boot** microservices architecture. The project consists of three independent services:

1. **Product Service** (`8082`) – manages products (CRUD operations).  
2. **Order Service** (`8083`) – manages orders, communicates with Product and User services via REST.  
3. **User Service** (`8084`) – manages users (CRUD operations).  

Each service is independent and runs on its own port, enabling easy scaling and development.

### Technologies Used
- **Java 17 / 23**  
- **Spring Boot 3**  
- **Spring Data JPA**  
- **PostgreSQL**  
- **REST API**  
- **Lombok**  
- **Maven**  
- **Git**

### How to Run
1. Clone the repository:
```bash
git clone <repository_url>
cd e-shop
Start PostgreSQL and create databases for each service:

productdb

orderdb

userdb

Navigate to each service folder and run:

bash
mvn clean spring-boot:run
Ports:

Product Service: 8082

Order Service: 8083

User Service: 8084

API Examples
User Service:

GET all users: GET http://localhost:8084/users

POST new user: POST http://localhost:8084/users
Body:

json
{
  "name": "John Doe",
  "email": "john@example.com"
}
Product Service:

GET all products: GET http://localhost:8082/products

POST new product: POST http://localhost:8082/products
Body:

json
{
  "name": "Widget",
  "price": 100.0
}
Order Service:

POST new order: POST http://localhost:8083/orders
Body:

json
{
  "userId": 1,
  "productIds": [1]
}
GET all orders: GET http://localhost:8083/orders

Project Structure

e-shop/
├─ product-service/
├─ order-service/
└─ user-service/
