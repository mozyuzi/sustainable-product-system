package se.sustainableproductsystem.domain.model;

public class RecyclingCategory {
    private final String name;

    public RecyclingCategory(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Recycling category name cannot be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

