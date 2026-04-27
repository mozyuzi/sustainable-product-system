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
