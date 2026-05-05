# Week 6 – Code Review and Design Refinement

## Issue Found
The system returned a value of 0 when a product was not found during impact calculation, which could mislead users.
<img width="480" height="167" alt="image" src="https://github.com/user-attachments/assets/22fc9887-b6c1-4de5-be35-3f4d7dd09ae1" />

## Principles Considered

### Single Responsibility Principle

`ProductService` should coordinate product-related use cases, but it should not decide how an error is displayed to the user. The service is responsible for detecting that the product does not exist.

`ConsoleUI` is responsible for showing the error message to the user.

### Open/Closed Principle

The impact calculation itself is still delegated through `ImpactCalculationStrategy`. The change does not modify the strategy classes, so calculation behavior can still be extended separately.

### Dependency Inversion Principle

`ProductService` continues to depend on the `ImpactCalculationStrategy` interface instead of a concrete calculation class. The refinement keeps this dependency direction unchanged.

### Layer Boundaries

The application layer now throws an exception when the product is missing. The presentation layer catches the exception and prints the message. This keeps business coordination away from console output.

### Testability

Throwing an exception is easier to test than returning a silent fallback value. A test can verify that a missing product produces an expected error instead of an unclear result.


## Improvement Implemented

`ProductService.calculateImpactByName` was changed so it throws an `IllegalArgumentException` when no product with the given name exists.

`ConsoleUI.calculateImpact` was updated to catch the exception and display the message to the user.

<img width="555" height="168" alt="image" src="https://github.com/user-attachments/assets/163a962f-9693-4fec-af6c-9048c25b093a" />
<img width="556" height="237" alt="image" src="https://github.com/user-attachments/assets/adc5c821-940a-4f94-9732-c947462442e5" />


## Result
The system now provides clear feedback to the user instead of silently returning incorrect values. This improves correctness while keeping responsibilities separated between the application layer and presentation layer.
