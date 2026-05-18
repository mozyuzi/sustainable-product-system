# Week 9 – Refactoring with a Safety Net

## Overview

This week focused on refactoring and improving code structure while keeping all tests green.

## Refactored Area

The `ConsoleUI` class was refactored to improve readability and separation of concerns.

## Changes

Large methods were split into smaller methods with clearer responsibilities.

Examples:
- `printMenu()`
- `readInput()`
- `showMessage()`
- `handleMenuChoice()`
- `printProductDetails()`

Duplicated console output and input handling were reduced by extracting reusable methods.

## Safety Net

All existing JUnit tests were run before and after the refactoring to verify that the system behaviour remained unchanged.

## Result

The code is now easier to read, maintain, and extend while preserving the same external behaviour.
