# Week 4 – Layered Architecture

---

## Overview

This week focuses on structuring the system using a layered architecture.  
The goal is to separate responsibilities and prepare the system for implementation.

---

## Architecture

The system is divided into three layers:

- **Presentation layer**
  - Handles user input and output (console UI)

- **Application layer**
  - Coordinates use cases and system behavior
  - Delegates work to domain objects

- **Domain layer**
  - Contains core entities, value objects, and business logic
  - Includes impact calculation strategies

---
## Dependency Direction

The dependencies follow this direction:

Presentation → Application → Domain

- The presentation layer depends on the application layer
- The application layer depends on the domain layer
- The domain layer does not depend on other layers
## Design Decisions

- Introduced layered architecture to separate concerns
- Kept business logic inside the domain layer
- Used the application layer to coordinate operations
- Ensured the UI does not contain business logic

---

## Summary

The system is now structured for implementation with clear separation between UI, application logic, and domain logic.
week4.md.txt
2 KB
