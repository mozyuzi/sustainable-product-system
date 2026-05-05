package se.sustainableproductsystem.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product {
    private final String name;
    private final Category category;
    private final Lifespan lifespan;
    private final List<Material> materials;

    public Product(String name, Category category, Lifespan lifespan, List<Material> materials) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        if (category == null) {
            throw new IllegalArgumentException("Category is required.");
        }
        if (lifespan == null) {
            throw new IllegalArgumentException("Lifespan is required.");
        }
        if (materials == null) {
            throw new IllegalArgumentException("Materials list is required.");
        }
        this.name = name;
        this.category = category;
        this.lifespan = lifespan;
        this.materials = new ArrayList<>(materials);
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Lifespan getLifespan() {
        return lifespan;
    }

    public List<Material> getMaterials() {
        return Collections.unmodifiableList(materials);
    }
}
