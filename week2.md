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
This class keeps track of an item. It saves the item's name, which category it belongs to, and what materials it is made of. You could say this is where all the information about a finished product is collected.

### Material
This class describes the different substances that a product consists of. It keeps track of the material's name and how much it affects the environment. The same material can be used in many different products.

### Category
This class is used to sort products into different groups, such as "Electronics" or "Clothing." It saves the name of the group so that it is easier to organize and find among all the items.
