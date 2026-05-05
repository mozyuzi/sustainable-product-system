package se.sustainableproductsystem.domain.strategy;

import se.sustainableproductsystem.domain.model.Material;
import se.sustainableproductsystem.domain.model.Product;

public class SimpleImpactCalculation implements ImpactCalculationStrategy {
    @Override
    public double calculateImpact(Product product) {
        double totalImpact = 0;
        for (Material material : product.getMaterials()) {
            totalImpact += material.getImpactValue();
        }
        return totalImpact;
    }
}
