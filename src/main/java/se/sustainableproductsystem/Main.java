package se.sustainableproductsystem;

import se.sustainableproductsystem.application.ProductService;
import se.sustainableproductsystem.domain.strategy.SimpleImpactCalculation;
import se.sustainableproductsystem.presentation.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService(new SimpleImpactCalculation());
        ConsoleUI consoleUI = new ConsoleUI(productService);
        consoleUI.start();
    }
}
package se.sustainableproductsystem.domain.model;

import java.util.List;

public class Product {
    private String name;
    private Category category;
    private Lifespan lifespan;
    private List<Material> materials;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
