---

## Overview

This week focuses on refining the domain model into a more detailed design model. The goal is to introduce clearer structure, improve responsibility distribution, and prepare the system for implementation without adding full business logic.

The design now begins to separate concerns and prepare for interaction between components.

---

## Updated UML Class Diagram

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

