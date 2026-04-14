# Week 2 – Domain Model v1

---

## Overview

This week focuses on creating the first version of the domain model (UML v1) and assigning clear responsibilities to each class. The goal is to model the problem domain using the language of the requirements, without implementation details, UI concerns, or database concerns.

---

## UML Class Diagram v1



---

## Responsibility Descriptions

### Product

Product is responsible for representing a product that the system manages. It knows the product’s category, lifespan, and associated materials. It must not handle UI or technical infrastructure.

---

### Material

Material is responsible for representing a reusable material in the system. It knows its environmental impact value and recycling information. A material can be used in multiple products.

---

### Category

Category is responsible for classifying products into groups. It provides a clear structure for organizing products in the domain.

---

### Lifespan

Lifespan is responsible for representing the expected duration of a product. It exists as a domain concept instead of a raw number to improve clarity.

---

### RecyclingCategory

RecyclingCategory is responsible for representing how a material should be handled during recycling. It standardizes recycling classification across the system.

---

### RecyclingGuidance

RecyclingGuidance is responsible for representing recycling instructions derived from a product’s materials. It expresses the domain outcome of recycling decisions.

---

### ImpactCalculationStrategy

ImpactCalculationStrategy represents the concept of calculating environmental impact using interchangeable approaches. It is included as a domain concept only.

---

## Design Notes

- This is a domain model, not an implementation
- No UI, database, or framework classes are included
- No business logic is implemented
- Focus is on domain concepts and relationships only

---

## Alternative Design Choice

We considered storing recycling information directly inside the Material class. This approach was rejected because recycling guidance may depend on multiple materials within a product. Therefore, RecyclingGuidance was modeled as a separate concept to allow future flexibility.

---

## Summary

The model focuses on the core domain concepts:

- Product  
- Material  
- Category  
- Lifespan  
- Recycling  
- Impact calculation

<img width="1277" height="842" alt="image" src="https://github.com/user-attachments/assets/9d03b5f7-4340-4567-abd4-defa061d9cc1" />


