---

## Overview

This week focuses on refining the domain model into a more detailed design model. The goal is to introduce clearer structure, improve responsibility distribution, and prepare the system for implementation without adding full business logic.

The design now begins to separate concerns and prepare for interaction between components.

---

## Updated UML Class Diagram

<img width="1138" height="791" alt="UML (v3)" src="https://github.com/user-attachments/assets/ab761369-66a7-438b-986a-27e2c2bfa3a5" />


## Responsibility Descriptions

### Product

Product represents a product in the system. It owns its category, lifespan, and associated materials. It does not perform calculations or external operations.

---

### Material

Material represents a reusable material definition. It stores environmental impact data and recycling-related information. It can be shared between multiple products.

---

### Category

Category classifies products into logical groups. It provides structure for organizing products within the domain.

---
### Lifespan

Lifespan represents the expected duration of a product. It improves clarity compared to using a primitive value.

---

### RecyclingCategory

RecyclingCategory represents how a material should be handled during recycling. It standardizes recycling classification.

---

### RecyclingGuidance

RecyclingGuidance represents the result of recycling decisions for a product. It provides a structured output of recycling logic.

---

### ImpactCalculationStrategy

ImpactCalculationStrategy defines the role of calculating environmental impact. It allows multiple interchangeable calculation methods.

---

### SimpleImpactCalculation

SimpleImpactCalculation provides a basic way to calculate environmental impact. It represents one possible strategy.

---

### AdvancedImpactCalculation

AdvancedImpactCalculation provides a more detailed calculation method. It allows the system to support more complex impact evaluation.

---

### ProductService

ProductService coordinates operations related to products. It delegates calculations to strategies and gathers results such as recycling guidance. It should not store data itself.

---

## Design Changes from Week 2

- Introduced ProductService to handle coordination logic
- Introduced strategy pattern for impact calculation
- Separated calculation responsibility from Product
- Improved extensibility for future features

---

## Design Principles Applied

- Separation of concerns
- Single Responsibility Principle
- Strategy pattern for flexible calculations
- Avoiding logic inside entities

---

## Notes

- Still no full implementation
- Focus is on structure and responsibilities
- Design prepares for Week 4 (implementation)

---

## Summary

Week 3 builds on Week 2 by:

- Expanding the model with service and strategy concepts
- Improving responsibility distribution
- Preparing the system for implementation
