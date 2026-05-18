# Sustainable Product & Recycling Management System

---

## Description

This project focuses on designing a system for managing products, materials, and their environmental impact. The system also provides recycling guidance based on product composition.

---

## Purpose

The goal of this project is to practice object-oriented design by transforming requirements into a structured domain model and refining it into a design model.

---
## Project Structure

- week1.md – Requirements and analysis  
- week2.md – Domain model (UML + responsibilities)  
- week3.md – Design model and services
- week4.md – Layered Architecture Implementation
- week5.md – Console UI implementation
- week6.md – Code review and design refinement
- week7.md – Strategy pattern implementation
- week8.md – Unit testing and CI integration
- week9.md – Refactoring with Safety Net

## Architecture

The project is organized using layered architecture:

- **Presentation layer**: Handles console input and output
- **Application layer**: Coordinates use cases through services
- **Domain layer**: Contains core entities, value objects, and impact calculation strategies

Dependency direction:
Presentation → Application → Domain

This structure keeps business logic independent from the UI and improves maintainability and testability.

## Build, Run, and Test

The project uses Maven and JUnit 5.

Run tests:

```bash
mvn test
```

Run the console application:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="se.sustainableproductsystem.Main"
```

If the Maven exec plugin is not available locally, the application can also be run from an IDE by starting `se.sustainableproductsystem.Main`.

## Strategy Pattern

Environmental impact calculation is handled through the `ImpactCalculationStrategy` interface. `ProductService` depends on this interface instead of a concrete calculation class, which means the calculation method can change without changing `Product` or the core service flow.

Two strategies are currently implemented:

- `SimpleImpactCalculation`: sums the impact values of all materials in a product.
- `AdvancedImpactCalculation`: sums the impact values and applies a multiplier for mixed-material products.

The console UI allows the active strategy to be changed at runtime. This solves the design problem where impact calculation rules may change or expand without forcing changes into the `Product` entity.

