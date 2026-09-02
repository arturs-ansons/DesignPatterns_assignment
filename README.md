# Design Patterns Assignment - Online Shop

## Overview

This project was created as part of the Java Design Patterns homework assignment. The goal of the assignment is to demonstrate the practical usage of Gang of Four (GoF) design patterns in a simple Java application.

The application simulates a basic online shop where customers can browse products, add products to a cart, create orders, and perform checkout using different payment methods.

The solution is intentionally kept simple to focus on showcasing design pattern implementations rather than complex business logic.

---

## Technologies

- Java 21
- Spring Boot
- Spring Data JPA
- H2 In-Memory Database
- Gradle
- Postman

---

## Project Features

- Create and retrieve products
- Add products to a shopping cart
- Create orders from customer carts
- Checkout orders
- Multiple payment methods
- Customer notifications
- Product customization through decorators

---

## Implemented GoF Design Patterns

### 1. Factory Method (Creational Pattern)

**Classes:**
- `ProductFactory`
- `ProductFactoryImpl`
- `PaymentFactory`
- `PaymentFactoryImpl`

**Purpose:**

Factories are responsible for creating products and payment strategies without exposing object construction logic to clients.

Example:

```java
Product product = productFactory.createProduct(request);

PaymentStrategy strategy =
        paymentFactory.create(method);
```

---

### 2. Strategy Pattern (Behavioral Pattern)

**Classes:**
- `PaymentStrategy`
- `CardPayment`
- `CashPayment`
- `PayPalPayment`

**Purpose:**

Allows checkout to use different payment algorithms without modifying checkout logic.

Example:

```java
PaymentStrategy strategy =
        paymentFactory.create(method);

strategy.pay(order);
```

---

### 3. Command Pattern (Behavioral Pattern)

**Classes:**
- `Command`
- `Checkout`

**Purpose:**

Encapsulates checkout requests as command objects and separates request execution from invocation.

Example:

```java
Command checkoutCommand =
        new Checkout(...);

checkoutCommand.execute();
```

---

### 4. Observer Pattern (Behavioral Pattern)

**Classes:**
- `Observer`
- `CustomerObserver`

**Purpose:**

Used to notify customers when important events occur, such as successful checkout.

Example:

```java
observer.update("Order paid successfully");
```

---

### 5. Decorator Pattern (Structural Pattern)

**Classes:**
- `ProductDecorator`
- `GiftWrapDecorator`

**Purpose:**

Allows adding extra functionality to products without modifying the original product implementation.

Example:

```java
ProductDecorator decorated =
        new GiftWrapDecorator(product);
```

---

## Database

The application uses an embedded H2 database.

Sample data is automatically inserted on startup through:

```java
DataInitializer
```

Preloaded data includes:

- Customer
- Cart
- Products

---

## API Endpoints

### Products

#### Get All Products

```http
GET /products
```

#### Get Product By ID

```http
GET /products/{id}
```

#### Create Product

```http
POST /products
```

Request Body:

```json
{
  "name": "Monitor",
  "price": 250.0,
  "quantity": 10,
  "type": "ELECTRONICS"
}
```

---

### Cart

#### Add Product To Cart

```http
POST /cart/add
```

Request Body:

```json
{
  "customerId": 1,
  "productId": 1
}
```

#### Get Cart

```http
GET /cart/{customerId}
```

---

### Orders

#### Create Order

```http
POST /orders/{customerId}
```

---

### Checkout

#### Checkout Using Card

```http
POST /checkout
```

```json
{
  "orderId": 1,
  "paymentMethod": "CARD"
}
```

#### Checkout Using Cash

```json
{
  "orderId": 1,
  "paymentMethod": "CASH"
}
```

---

## Running the Application

Clone the repository:

```bash
git clone <repository-url>
```

Navigate to the project directory:

```bash
cd shop
```

Run the application:

```bash
./gradlew bootRun
```

The application will start on:

```text
http://localhost:8080
```

---

## Postman Collection

A ready-to-use Postman collection is included:

```text
postman/Shop_API_Postman_Collection.json
```

Import it into Postman to test all available endpoints.

---

## Assignment Requirements Coverage

| Requirement | Status |
|------------|---------|
| 1 Creational Pattern | ✅ Factory Method |
| 1 Structural Pattern | ✅ Decorator |
| 1 Behavioral Pattern | ✅ Strategy |
| At least 4 Non-Creational Patterns | ✅ Strategy, Observer, Command, Decorator |
| GitHub Repository | ✅ |
| Java Implementation | ✅ |

---

## Author

Artūrs Ansons

Java Design Patterns Assignment
