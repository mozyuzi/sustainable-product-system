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

### Product (Produkt)
Den här klassen håller koll på en vara. Den sparar vad varan heter, vilken kategori den tillhör och vilka material den är gjord av. Man kan säga att det är här all information om en färdig sak samlas..

### Material (Material)
Den här klassen beskriver de olika ämnen som en produkt består av. Den håller reda på vad materialet heter och hur mycket det påverkar miljön. Samma material kan användas i många olika produkter.

### Category (Kategori)
Den här klassen används för att sortera produkterna i olika grupper, till exempel "Elektronik" eller "Kläder". Den sparar namnet på gruppen så att det blir lättare att hålla ordning på och hitta bland alla varor.
