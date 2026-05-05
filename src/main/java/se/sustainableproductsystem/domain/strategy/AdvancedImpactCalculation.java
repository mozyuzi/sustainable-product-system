package se.sustainableproductsystem.domain.strategy;

import se.sustainableproductsystem.domain.model.Material;
import se.sustainableproductsystem.domain.model.Product;

public class AdvancedImpactCalculation implements ImpactCalculationStrategy {
    private static final double MIXED_MATERIAL_MULTIPLIER = 1.2;

    @Override
    public double calculateImpact(Product product) {
        double baseImpact = 0;
        for (Material material : product.getMaterials()) {
            baseImpact += material.getImpactValue();
        }

        if (product.getMaterials().size() > 1) {
            return baseImpact * MIXED_MATERIAL_MULTIPLIER;
        }

        return baseImpact;
    }
}
