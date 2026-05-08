# Social Media Backend System

A scalable backend system built using Spring Boot, PostgreSQL, and Redis.

---

# 🚀 Features

- Create Posts
- Add Comments
- Like Posts
- Trending Posts
- Bot Cooldown Protection
- Maximum Bot Comment Limit
- Redis-based Ranking System

---

# 🛠 Technologies Used

| Technology | Purpose |
|---|---|
| Java 21 | Programming Language |
| Spring Boot | Backend Framework |
| PostgreSQL | Persistent Database |
| Redis | Cache + Counters + Trending |
| JPA/Hibernate | ORM |
| Maven | Dependency Management |

---

# 📁 Project Structure

```text
com.grid07.backend
│
├── controller
├── entity
├── repository
├── service
├── config
```

---

# ⚙️ Setup Instructions

## 1. Clone Repository

```bash
git clone <your-github-url>
```

---

## 2. Configure PostgreSQL

Create database:

```sql
CREATE DATABASE grid07;
```

---

## 3. Update application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/grid07
spring.datasource.username=postgres
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.data.redis.host=localhost
spring.data.redis.port=6379
```

---

## 4. Start Redis

```bash
redis-server.exe
```

---

## 5. Run Spring Boot Application

Run:

```text
BackendApplication.java
```

---

# 📌 Sample API Endpoints

## ✅ Create Post

### POST

```http
POST /api/posts
```

### Body

```json
{
  "authorId": 1,
  "content": "Hello World"
}
```

---

## ✅ Add Comment

### POST

```http
POST /api/posts/1/comments
```

### Body

```json
{
  "authorId": 2,
  "content": "Nice post!",
  "depthLevel": 1
}
```

---

## ✅ Like Post

### POST

```http
POST /api/posts/1/like
```

---

## ✅ Get Trending Posts

### GET

```http
GET /api/posts/trending
```

---

# 🔥 Redis Features Used

- Atomic Counters
- TTL (Cooldown System)
- Sorted Sets (Trending)
- Rate Limiting

---

# 📊 Architecture

```text
Postman
   ↓
Controller
   ↓
Service Layer
   ↓
PostgreSQL / Redis
```

---

# 🎯 Backend Concepts Demonstrated

- REST APIs
- Spring Boot
- PostgreSQL
- Redis
- JPA/Hibernate
- Atomic Operations
- Rate Limiting
- Scalable Architecture

---

# 👨‍💻 Author

R. Shashikanth