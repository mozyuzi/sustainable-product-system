package se.sustainableproductsystem.application;

import java.util.ArrayList;
import java.util.List;
import se.sustainableproductsystem.domain.model.Product;
import se.sustainableproductsystem.domain.model.RecyclingGuidance;
import se.sustainableproductsystem.domain.strategy.ImpactCalculationStrategy;

public class ProductService {
    private final ImpactCalculationStrategy impactCalculationStrategy;
    private final List<Product> products = new ArrayList<>();

    public ProductService(ImpactCalculationStrategy impactCalculationStrategy) {
        this.impactCalculationStrategy = impactCalculationStrategy;
    }

    public void createProduct(String name) {
        products.add(new Product(name));
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateImpact(Product product) {
        return impactCalculationStrategy.calculateImpact(product);
    }

    public double calculateImpactByName(String name) {
    for (Product product : products) {
        if (product.getName().equalsIgnoreCase(name)) {
            return calculateImpact(product);
        }
    }
    throw new IllegalArgumentException("Product not found: " + name);
}

    public RecyclingGuidance getRecyclingGuidance(Product product) {
        return new RecyclingGuidance();
    }
}
