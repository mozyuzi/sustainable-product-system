package se.sustainableproductsystem.domain.strategy;

import se.sustainableproductsystem.domain.model.Product;

public interface ImpactCalculationStrategy {
    double calculateImpact(Product product);
}
