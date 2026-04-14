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

## Architecture

The project is organized using layered architecture:

- **Presentation layer**: Handles console input and output
- **Application layer**: Coordinates use cases through services
- **Domain layer**: Contains core entities, value objects, and impact calculation strategies

Dependency direction:
Presentation → Application → Domain

This structure keeps business logic independent from the UI and improves maintainability and testability.
