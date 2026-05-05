# Week 8 - Unit Testing and CI Integration

## Overview

Week 8 focused on adding automated tests and a continuous integration pipeline. The goal was to create a safety net for the domain logic without testing console input or output.

## Unit Tests

JUnit 5 tests were added under `src/test/java`.

The tests cover:

- Domain objects: `Product`, `Material`, `Category`, `Lifespan`, `RecyclingCategory`, and `RecyclingGuidance`
- Strategy implementations: `SimpleImpactCalculation` and `AdvancedImpactCalculation`
- Application coordination: `ProductService`

The strategy tests include:

- Normal cases with multiple materials
- Edge cases with empty material lists
- Formula verification for the advanced mixed-material multiplier

## CI Pipeline

A GitHub Actions workflow was added at `.github/workflows/ci.yml`.

The pipeline runs on:

- Every push
- Every pull request

The pipeline checks out the repository, installs Java 17, and runs:

```bash
mvn test
```

## Result

The project now has a build system, automated tests, and a CI configuration for the current Week 8 requirements.
