package se.sustainableproductsystem.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import se.sustainableproductsystem.application.ProductService;
import se.sustainableproductsystem.domain.model.Material;
import se.sustainableproductsystem.domain.model.Product;
import se.sustainableproductsystem.domain.model.RecyclingGuidance;
import se.sustainableproductsystem.domain.strategy.AdvancedImpactCalculation;
import se.sustainableproductsystem.domain.strategy.SimpleImpactCalculation;

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
            System.out.println("1. Add material");
            System.out.println("2. Add product");
            System.out.println("3. List products");
            System.out.println("4. View product details");
            System.out.println("5. Calculate impact");
            System.out.println("6. Show recycling guidance");
            System.out.println("7. Change impact calculation method");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addMaterial();
                    break;
                case "2":
                    addProduct();
                    break;
                case "3":
                    listProducts();
                    break;
                case "4":
                    viewProductDetails();
                    break;
                case "5":
                    calculateImpact();
                    break;
                case "6":
                    showRecyclingGuidance();
                    break;
                case "7":
                    changeCalculationMethod();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void addMaterial() {
        System.out.print("Enter material name: ");
        String name = scanner.nextLine();

        System.out.print("Enter environmental impact value: ");
        double impactValue = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter recycling category: ");
        String recyclingCategory = scanner.nextLine();

        System.out.print("Enter recycling instruction: ");
        String recyclingInstruction = scanner.nextLine();

        productService.createMaterial(name, impactValue, recyclingCategory, recyclingInstruction);
        System.out.println("Material added.");
    }

    private void addProduct() {
        if (productService.getMaterials().isEmpty()) {
            System.out.println("Add at least one material before creating a product.");
            return;
        }

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter estimated lifespan in years: ");
        int lifespanYears = Integer.parseInt(scanner.nextLine());

        List<Material> selectedMaterials = selectMaterials();
        productService.createProduct(name, category, lifespanYears, selectedMaterials);

        System.out.println("Product added.");
    }

    private void listProducts() {
        if (productService.getProducts().isEmpty()) {
            System.out.println("No products registered.");
            return;
        }

        for (Product product : productService.getProducts()) {
            System.out.println(product.getName());
        }
    }

    private void viewProductDetails() {
        Product product = findProductByName();
        if (product == null) {
            return;
        }

        System.out.println("Name: " + product.getName());
        System.out.println("Category: " + product.getCategory().getName());
        System.out.println("Lifespan: " + product.getLifespan().getYears() + " years");
        System.out.println("Materials:");
        for (Material material : product.getMaterials()) {
            System.out.println("- " + material.getName()
                    + " (impact " + material.getImpactValue()
                    + ", " + material.getRecyclingCategory().getName() + ")");
        }
        System.out.println("Impact: " + productService.calculateImpact(product));
    }

    private void calculateImpact() {
        Product product = findProductByName();
        if (product == null) {
            return;
        }

        double impact = productService.calculateImpact(product);
        System.out.println("Impact: " + impact);
    }

    private void showRecyclingGuidance() {
        Product product = findProductByName();
        if (product == null) {
            return;
        }

        RecyclingGuidance guidance = productService.getRecyclingGuidance(product);
        System.out.println(guidance.getSummary());
    }

    private void changeCalculationMethod() {
        System.out.println("1. Simple calculation");
        System.out.println("2. Advanced calculation");
        System.out.print("Choose method: ");
        String choice = scanner.nextLine();

        if ("1".equals(choice)) {
            productService.setImpactCalculationStrategy(new SimpleImpactCalculation());
            System.out.println("Simple calculation selected.");
        } else if ("2".equals(choice)) {
            productService.setImpactCalculationStrategy(new AdvancedImpactCalculation());
            System.out.println("Advanced calculation selected.");
        } else {
            System.out.println("Invalid calculation method.");
        }
    }

    private Product findProductByName() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        for (Product product : productService.getProducts()) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }

        System.out.println("Product not found: " + name);
        return null;
    }

    private List<Material> selectMaterials() {
        List<Material> selectedMaterials = new ArrayList<>();
        boolean selecting = true;

        while (selecting) {
            System.out.println("Available materials:");
            for (int i = 0; i < productService.getMaterials().size(); i++) {
                Material material = productService.getMaterials().get(i);
                System.out.println((i + 1) + ". " + material.getName());
            }

            System.out.print("Choose material number, or 0 when done: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 0) {
                if (selectedMaterials.isEmpty()) {
                    System.out.println("Select at least one material.");
                } else {
                    selecting = false;
                }
            } else if (choice > 0 && choice <= productService.getMaterials().size()) {
                selectedMaterials.add(productService.getMaterials().get(choice - 1));
                System.out.println("Material selected.");
            } else {
                System.out.println("Invalid material number.");
            }
        }

        return selectedMaterials;
    }
}
