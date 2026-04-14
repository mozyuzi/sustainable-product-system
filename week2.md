# Week 2 – Domain Model v1

---

## Overview

This week focuses on creating CRC cards for the candidate concepts and converting them to the first version of the domain model (UML v1) and assigning clear responsibilities to each class. The goal is to model the problem domain using the language of the requirements, without implementation details, UI concerns, or database concerns.

---

## CRC Cards

---

### 🟦 Product (Entity)

**Responsibilities**
- Represent a product in the system  
- Know its name, category, and lifespan  
- Hold its list of materials (1..*)  

**Collaborators**
- Category  
- Material  
- Lifespan  

---

### 🟪 Material (Entity)

**Responsibilities**
- Represent a material used in products  
- Know its name and environmental impact value  
- Know how it should be recycled  

**Collaborators**
- RecyclingCategory  

---

### 🟩 Category (Entity)

**Responsibilities**
- Represent the classification of a product  
- Know the name of the category  

**Collaborators**
- Product  

---

### 🟨 RecyclingCategory (Entity)

**Responsibilities**
- Represent how a material is recycled  
- Know the name of the recycling category  

**Collaborators**
- Material  

---

### 🟧 Lifespan (Value Object)

**Responsibilities**
- Represent the expected lifespan of a product  
- Know its value in years  

**Collaborators**
- Product  

---

### 🟥 RecyclingGuidance (Entity)

**Responsibilities**
- Represent recycling information for a product  
- Summarize how its materials should be handled  

**Collaborators**
- Product  
- Material  

---

## UML Class Diagram v1
<img width="1277" height="842" alt="image" src="https://github.com/user-attachments/assets/2bbd636f-930e-49df-a6d8-7ad26bc6e231" />




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

## Summary

The model focuses on the core domain concepts:

- Product  
- Material  
- Category  
- Lifespan  
- Recycling  
- Impact calculation




