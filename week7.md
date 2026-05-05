# Week 7 - Design Pattern Implementation

## Overview

Week 7 focused on implementing the Strategy pattern for environmental impact calculation. The goal was to keep calculation rules separate from the `Product` entity and make the active calculation method replaceable.

## Implementation

The domain layer now contains:

- `ImpactCalculationStrategy`
- `SimpleImpactCalculation`
- `AdvancedImpactCalculation`

`ProductService` receives an `ImpactCalculationStrategy` through constructor injection and exposes a method for changing the strategy at runtime.

## Strategy Responsibilities

`SimpleImpactCalculation` calculates the total impact by summing all material impact values.

`AdvancedImpactCalculation` calculates the same base impact, but applies a multiplier when the product contains more than one material. This represents the extra handling complexity of mixed-material products.

## Design Rationale

The Strategy pattern was introduced because environmental impact rules can vary. Keeping those rules behind an interface means new calculation methods can be added without changing `Product`.

This supports:

- Single Responsibility Principle: products store product data, strategies calculate impact.
- Open/Closed Principle: new strategies can be added without changing existing product code.
- Dependency Inversion Principle: `ProductService` depends on an interface.

## Result

The project now has two interchangeable calculation strategies. The active strategy can be changed from the console menu, and calculations are delegated through the application layer.
