package se.sustainableproductsystem.presentation;

import java.util.Scanner;
import se.sustainableproductsystem.application.ProductService;
import se.sustainableproductsystem.domain.model.Product;

public class ConsoleUI {
    private final ProductService productService;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(ProductService productService) {
        this.productService = productService;
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("Sustainable Product & Recycling Management System");
            System.out.println("1. Add product");
            System.out.println("2. List products");
            System.out.println("3. Calculate impact");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    listProducts();
                    break;
                case "3":
                    calculateImpact();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        productService.createProduct(name);

        System.out.println("Product added.");
    }

    private void listProducts() {
        for (Product product : productService.getProducts()) {
            System.out.println(product.getName());
        }
    }

    private void calculateImpact() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        double impact = productService.calculateImpactByName(name);

        System.out.println("Impact: " + impact);
    }
}
