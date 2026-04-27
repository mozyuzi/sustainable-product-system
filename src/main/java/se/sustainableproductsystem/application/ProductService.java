package se.sustainableproductsystem.application;

import se.sustainableproductsystem.domain.model.Product;
import se.sustainableproductsystem.domain.model.RecyclingGuidance;
import se.sustainableproductsystem.domain.strategy.ImpactCalculationStrategy;

public class ProductService {
    private ImpactCalculationStrategy impactCalculationStrategy;

    public ProductService(ImpactCalculationStrategy impactCalculationStrategy) {
        this.impactCalculationStrategy = impactCalculationStrategy;
    }

    public double calculateImpact(Product product) {
        return impactCalculationStrategy.calculateImpact(product);
    }

    public RecyclingGuidance getRecyclingGuidance(Product product) {
        return new RecyclingGuidance();
    }
}

