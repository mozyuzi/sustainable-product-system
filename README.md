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
- week10.md - Sequence Diagram
- week11.md - CI Stability and Git Quality
- week12.md - Design Reflection

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

## Design Reflection

### Introduction
The goal of this project was to develop a Sustainable Product and Recycling Management
System while applying object-oriented design principles and software engineering practices.
Throughout the project, we focused on creating a system that is maintainable, testable, and
easy to extend.

### Architecture
One of the most important decisions was using a layered architecture with Presentation,
Application, and Domain layers. We chose this approach to keep the user interface separate
from the business logic.
This separation made the code easier to understand and maintain. It also improved
testability because the domain logic could be tested without involving the console interface.

### Design Principles and Strategy Pattern
The project was strongly influenced by the principles SRP, OCP, and DIP.
SRP helped us keep responsibilities separated between classes. Product stores product
information, Material stores material information, and services coordinate application
workflows.
OCP became important when implementing environmental impact calculations. Instead of
modifying existing classes whenever a new calculation method is needed, we used the
Strategy pattern.
The Strategy pattern allowed us to create multiple calculation methods through the
ImpactCalculationStrategy interface. This made the system more flexible and easier to
extend. Looking back, the pattern solved a real design problem and was not only added to
satisfy a project requirement.
DIP was applied by letting services depend on the strategy interface rather than concrete
implementations. This reduced coupling and improved flexibility

### Testing and Refactoring
Testing became increasingly valuable as the project grew. Unit tests allowed us to verify that
calculations worked correctly and gave us confidence when making changes.
During refactoring, the tests acted as a safety net and helped us improve the structure of the
code without breaking existing functionality.

### Future Improvements
If the project were continued, one improvement would be adding persistent storage so
products and materials are saved between program runs.
Another improvement would be stronger input validation and more comprehensive testing of
edge cases.

### Conclusion
This project helped us understand how design principles, testing, and design patterns work
together in practice. The layered architecture and Strategy pattern created a system that is
easier to maintain and extend. Overall, the project provided valuable experience in designing
and implementing a structured object-oriented application.

## Documentation

### UML Diagrams
- [Class Diagram](docs/class_diagram.png)
- [Sequence Diagram](docs/sequence_diagram.png)
