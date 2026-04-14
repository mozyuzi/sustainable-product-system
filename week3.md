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
