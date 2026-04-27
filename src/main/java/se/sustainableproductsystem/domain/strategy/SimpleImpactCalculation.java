package se.sustainableproductsystem.domain.strategy;

import se.sustainableproductsystem.domain.model.Product;

public class SimpleImpactCalculation implements ImpactCalculationStrategy {
    @Override
    public double calculateImpact(Product product) {
        return 0;
    }
}
