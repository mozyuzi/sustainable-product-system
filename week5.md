# Week 5 – Console UI and Separation of Concerns

## Overview

During Week 5, we implemented a working console-based user interface for the Sustainable Product & Recycling Management System. The focus was on creating a structured menu and ensuring a clear separation between presentation, application, and domain layers.

## Implementation

We developed a menu-driven console interface in `ConsoleUI` that allows the user to:

- Add a product
- List all products
- Calculate environmental impact
- Exit the program

The menu runs in a loop and handles user input using a `Scanner`.

## Separation of Concerns

A key goal of this week was to ensure that the presentation layer does not contain any business logic.

- **ConsoleUI (Presentation Layer)**  
  Handles user input and output only. It does not perform calculations or manage data directly.

- **ProductService (Application Layer)**  
  Contains the application logic. It is responsible for:
  - Creating products
  - Storing products in a list
  - Retrieving products
  - Delegating impact calculation to a strategy

- **Domain Layer**  
  Contains core classes such as `Product` and the `ImpactCalculationStrategy` interface. These classes represent the core data and rules of the system.

## Strategy Pattern Usage

We used the Strategy pattern to support interchangeable impact calculations:

- `ImpactCalculationStrategy` (interface)
- `SimpleImpactCalculation`
- `AdvancedImpactCalculation`

The strategy is injected into `ProductService`, which ensures that the system follows the Dependency Inversion Principle.

Currently, both strategies return a placeholder value (`0`) and will be fully implemented in Week 7.

## Result

At the end of Week 5, the system is able to:

- Start from a main entry point (`Main.java`)
- Display a menu and accept user input
- Create and store products
- List stored products
- Call the impact calculation through the application layer

The layered architecture is now functional and clearly separates responsibilities between UI, application logic, and domain.

## Reflection

The implementation confirms that:

- The console UI is independent of business logic
- The application layer coordinates all operations
- The domain layer remains clean and reusable

This provides a solid foundation for further development, especially for implementing real impact calculations and unit testing in upcoming weeks.
