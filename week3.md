# Week 3 – Applying Design Principles (SRP, OCP, DIP)

This week focuses on improving the domain model using core design principles.

---

## Identified Design Weakness

The Week 2 model connected Product directly to Material, which made it too simple and unclear for handling products with multiple materials. It also risked giving Product too many responsibilities.

Additionally, the model did not support extending behavior like environmental impact calculation without modifying existing classes.

---

## Design Improvement

Introduced ProductMaterial to represent the relationship between Product and Material.
Introduced EnvironmentalImpactStrategy as an interface for impact calculation.

Added two implementations:

* StandardImpactStrategy
* WeightedImpactStrategy

---
## Design Principles Applied

### SRP
Responsibilities are separated:
- Product → product data  
- Material → reusable material data  
- ProductMaterial → material composition  

### OCP
The strategy interface allows new impact calculations to be added without modifying existing classes.

### DIP
The design introduces an abstraction (EnvironmentalImpactStrategy), reducing dependency on concrete implementations.

---

## UML Class Diagram (Version 2)

The updated model includes:

- Product 1 → 1..* ProductMaterial  
- ProductMaterial 1..* → 1 Material  
- Product 1 → 1 Category  

- EnvironmentalImpactStrategy interface  
- StandardImpactStrategy and WeightedImpactStrategy implementations

<img width="1105" height="721" alt="umlv2" src="https://github.com/user-attachments/assets/35b068c2-caec-4807-87ff-b4dbd513549c" />


---

## Notes

- No functional business logic has been implemented.
- The design prepares the system for future extensions.
