# Difference Between JPA, Hibernate, and Spring Data JPA

## 1. JPA (Java Persistence API)

JPA (Java Persistence API) is a **Java specification** that defines a standard way to map Java objects to relational databases. It provides interfaces and annotations for performing database operations but does not contain any implementation.

### Features
- It is a specification, not a framework.
- Provides standard APIs for persistence.
- Uses `EntityManager` for database operations.
- Requires an implementation such as Hibernate.
- Supports annotations like `@Entity`, `@Table`, `@Id`, etc.

### Example
```java
EntityManager entityManager = entityManagerFactory.createEntityManager();
entityManager.persist(country);
```

---

## 2. Hibernate

Hibernate is an **Object Relational Mapping (ORM) framework** and one of the most popular implementations of JPA. It converts Java objects into database records and generates SQL automatically.

### Features
- ORM framework.
- Implements JPA specification.
- Automatically generates SQL queries.
- Supports HQL (Hibernate Query Language).
- Provides caching, lazy loading, and transaction management.

### Example
```java
Session session = sessionFactory.openSession();
session.save(country);
```

---

## 3. Spring Data JPA

Spring Data JPA is a Spring Framework module built on top of JPA. It reduces boilerplate code by providing ready-made repository interfaces for database operations.

### Features
- Built on top of JPA.
- Uses Hibernate (or another JPA provider) internally.
- Provides built-in CRUD operations.
- Supports query methods, pagination, and sorting.
- Eliminates the need to write DAO implementations.

### Example
```java
public interface CountryRepository extends JpaRepository<Country, String> {

}
```

```java
countryRepository.save(country);
countryRepository.findAll();
countryRepository.findById("IN");
```

---

# Relationship

```
Application
      │
      ▼
Spring Data JPA
      │
      ▼
JPA
      │
      ▼
Hibernate
      │
      ▼
MySQL Database
```

- **JPA** defines the rules for persistence.
- **Hibernate** implements those rules.
- **Spring Data JPA** simplifies using JPA by providing repository interfaces.

---

# Key Differences

### JPA
- It is a specification.
- Defines standard persistence APIs.
- Cannot work without an implementation.
- Uses `EntityManager`.

### Hibernate
- It is an ORM framework.
- Implements JPA.
- Can work independently or with JPA.
- Uses `Session` and `SessionFactory`.

### Spring Data JPA
- It is a Spring module.
- Built on top of JPA.
- Uses `JpaRepository`.
- Provides automatic CRUD methods.
- Requires JPA and a provider such as Hibernate.

---

# One-Line Summary

- **JPA** = Specification (defines persistence rules).
- **Hibernate** = ORM framework that implements JPA.
- **Spring Data JPA** = Spring module that simplifies JPA by providing repository-based data access.

---