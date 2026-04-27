package se.sustainableproductsystem.domain.model;

import java.util.List;

public class Product {
    private String name;
    private Category category;
    private Lifespan lifespan;
    private List<Material> materials;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
