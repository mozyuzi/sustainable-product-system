# Week 2 – Domain Model v1

---

## Overview

This week focuses on creating the first version of the domain model (UML v1) and assigning clear responsibilities to each class. The goal is to model the problem domain using the language of the requirements, without implementation details, UI concerns, or database concerns.

---

## UML Class Diagram v1



---

## Responsibility Descriptions



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
