package se.sustainableproductsystem.domain.model;

public class Category {
    private final String name;

    public Category(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Category name cannot be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
