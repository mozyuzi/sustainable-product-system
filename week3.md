Week 3 – Applying Design Principles (SRP, OCP, DIP)

This week focuses on improving the domain model using core design principles.

Identified Design Weakness

The Week 2 model connected Product directly to Material, which made it too simple and unclear for handling products with multiple materials. It also risked giving Product too many responsibilities.

Additionally, the model did not support extending behavior like environmental impact calculation without modifying existing classes.

Design Improvement

Introduced ProductMaterial to represent the relationship between Product and Material.
Introduced EnvironmentalImpactStrategy as an interface for impact calculation.

Added two implementations:

StandardImpactStrategy
WeightedImpactStrategy
