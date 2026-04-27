package se.sustainableproductsystem.presentation;

import se.sustainableproductsystem.application.ProductService;

public class ConsoleUI {
    private ProductService productService;

    public ConsoleUI(ProductService productService) {
        this.productService = productService;
    }

    public void start() {
        System.out.println("Sustainable Product & Recycling Management System");
    }
}
