package se.sustainableproductsystem.domain.model;

public class Material {
    private final String name;
    private final double impactValue;
    private final RecyclingCategory recyclingCategory;
    private final String recyclingInstruction;

    public Material(String name, double impactValue, RecyclingCategory recyclingCategory, String recyclingInstruction) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Material name cannot be empty.");
        }
        if (impactValue < 0) {
            throw new IllegalArgumentException("Impact value cannot be negative.");
        }
        if (recyclingCategory == null) {
            throw new IllegalArgumentException("Recycling category is required.");
        }
        if (recyclingInstruction == null || recyclingInstruction.isBlank()) {
            throw new IllegalArgumentException("Recycling instruction cannot be empty.");
        }

        this.name = name;
        this.impactValue = impactValue;
        this.recyclingCategory = recyclingCategory;
        this.recyclingInstruction = recyclingInstruction;
    }

    public String getName() {
        return name;
    }

    public double getImpactValue() {
        return impactValue;
    }

    public RecyclingCategory getRecyclingCategory() {
        return recyclingCategory;
    }

    public String getRecyclingInstruction() {
        return recyclingInstruction;
    }
}
