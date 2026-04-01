# Week 2 – Domain Model

## UML Class Diagram (Version 1)
<img width="760" height="582" alt="uml_version1" src="https://github.com/user-attachments/assets/f1b25293-82e5-4f61-9838-398c76b67ea7" />


The system includes three main classes:
- Product
- Material
- Category

Relationships:
- One Product has one Category
- One Product has zero or more Materials

## Class Responsibilities

### Product
Represents a product with a name, category, and list of materials. It connects materials and category.

### Material
Represents a material with a name and environmental impact value. It can be used in multiple products.

### Category
Represents the type of a product. It is used to group products.
