package se.sustainableproductsystem.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import se.sustainableproductsystem.domain.model.Category;
import se.sustainableproductsystem.domain.model.Lifespan;
import se.sustainableproductsystem.domain.model.Material;
import se.sustainableproductsystem.domain.model.Product;
import se.sustainableproductsystem.domain.model.RecyclingCategory;
import se.sustainableproductsystem.domain.model.RecyclingGuidance;
import se.sustainableproductsystem.domain.strategy.ImpactCalculationStrategy;

public class ProductService {
    private ImpactCalculationStrategy impactCalculationStrategy;
    private final List<Product> products = new ArrayList<>();
    private final List<Material> materials = new ArrayList<>();

    public ProductService(ImpactCalculationStrategy impactCalculationStrategy) {
        this.impactCalculationStrategy = impactCalculationStrategy;
    }

    public void setImpactCalculationStrategy(ImpactCalculationStrategy impactCalculationStrategy) {
        if (impactCalculationStrategy == null) {
            throw new IllegalArgumentException("Impact calculation strategy is required.");
        }
        this.impactCalculationStrategy = impactCalculationStrategy;
    }

    public Material createMaterial(String name, double impactValue, String recyclingCategoryName, String recyclingInstruction) {
        Material material = new Material(
                name,
                impactValue,
                new RecyclingCategory(recyclingCategoryName),
                recyclingInstruction
        );
        materials.add(material);
        return material;
    }

    public Product createProduct(String name, String categoryName, int lifespanYears, List<Material> productMaterials) {
        Product product = new Product(
                name,
                new Category(categoryName),
                new Lifespan(lifespanYears),
                productMaterials
        );
        products.add(product);
        return product;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Material> getMaterials() {
        return materials;
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
        if (product.getMaterials().isEmpty()) {
            return new RecyclingGuidance("No material information available.");
        }

        if (product.getMaterials().size() == 1) {
            Material material = product.getMaterials().get(0);
            return new RecyclingGuidance(material.getRecyclingInstruction());
        }

        String instructions = product.getMaterials().stream()
                .map(material -> material.getName() + ": " + material.getRecyclingInstruction())
                .collect(Collectors.joining("; "));

        return new RecyclingGuidance("Mixed-material product. Separate materials if possible. " + instructions);
    }
}
