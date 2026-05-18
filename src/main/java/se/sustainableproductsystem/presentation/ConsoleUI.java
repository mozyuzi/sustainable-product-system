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
            printMenu();
            String choice = readInput("Choose option: ");
            running = handleMenuChoice(choice);
        }
    }

    private void printMenu() {
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
    }

    private boolean handleMenuChoice(String choice) {
        switch (choice) {
            case "1":
                addMaterial();
                return true;
            case "2":
                addProduct();
                return true;
            case "3":
                listProducts();
                return true;
            case "4":
                viewProductDetails();
                return true;
            case "5":
                calculateImpact();
                return true;
            case "6":
                showRecyclingGuidance();
                return true;
            case "7":
                changeCalculationMethod();
                return true;
            case "0":
                return false;
            default:
                showMessage("Invalid option.");
                return true;
        }
    }

    private void addMaterial() {
        String name = readInput("Enter material name: ");
        double impactValue = readDouble("Enter environmental impact value: ");
        String recyclingCategory = readInput("Enter recycling category: ");
        String recyclingInstruction = readInput("Enter recycling instruction: ");

        productService.createMaterial(name, impactValue, recyclingCategory, recyclingInstruction);
        showMessage("Material added.");
    }

    private void addProduct() {
        if (productService.getMaterials().isEmpty()) {
            showMessage("Add at least one material before creating a product.");
            return;
        }

        String name = readInput("Enter product name: ");
        String category = readInput("Enter category: ");
        int lifespanYears = readInt("Enter estimated lifespan in years: ");

        List<Material> selectedMaterials = selectMaterials();
        productService.createProduct(name, category, lifespanYears, selectedMaterials);

        showMessage("Product added.");
    }

    private List<Material> selectMaterials() {
        List<Material> selectedMaterials = new ArrayList<>();
        List<Material> availableMaterials = productService.getMaterials();

        showMessage("Available materials:");

        for (int i = 0; i < availableMaterials.size(); i++) {
            Material material = availableMaterials.get(i);
            System.out.println((i + 1) + ". " + material.getName());
        }

        String input = readInput("Enter material numbers separated by comma: ");
        String[] selectedIndexes = input.split(",");

        for (String indexText : selectedIndexes) {
            int index = Integer.parseInt(indexText.trim()) - 1;

            if (index >= 0 && index < availableMaterials.size()) {
                selectedMaterials.add(availableMaterials.get(index));
            }
        }

        return selectedMaterials;
    }

    private void listProducts() {
        if (productService.getProducts().isEmpty()) {
            showMessage("No products registered.");
            return;
        }

        for (Product product : productService.getProducts()) {
            showMessage(product.getName());
        }
    }

    private void viewProductDetails() {
        Product product = findProductByName();

        if (product == null) {
            return;
        }

        printProductDetails(product);
    }

    private void printProductDetails(Product product) {
        System.out.println("Name: " + product.getName());
        System.out.println("Category: " + product.getCategory().getName());
        System.out.println("Lifespan: " + product.getLifespan().getYears() + " years");
        printMaterials(product);
    }

    private void printMaterials(Product product) {
        System.out.println("Materials:");

        for (Material material : product.getMaterials()) {
            System.out.println("- " + material.getName()
                    + " (impact " + material.getImpactValue()
                    + ", " + material.getRecyclingCategory().getName() + ")");
        }
    }

    private void calculateImpact() {
        String name = readInput("Enter product name: ");

        try {
            double impact = productService.calculateImpactByName(name);
            showMessage("Impact: " + impact);
        } catch (IllegalArgumentException exception) {
            showMessage(exception.getMessage());
        }
    }

    private void showRecyclingGuidance() {
        Product product = findProductByName();

        if (product == null) {
            return;
        }

        RecyclingGuidance guidance = productService.getRecyclingGuidance(product);
        showMessage(guidance.getSummary());
    }

    private void changeCalculationMethod() {
        showMessage("1. Simple impact calculation");
        showMessage("2. Advanced impact calculation");

        String choice = readInput("Choose calculation method: ");

        switch (choice) {
            case "1":
                productService.setImpactCalculationStrategy(new SimpleImpactCalculation());
                showMessage("Simple impact calculation selected.");
                break;
            case "2":
                productService.setImpactCalculationStrategy(new AdvancedImpactCalculation());
                showMessage("Advanced impact calculation selected.");
                break;
            default:
                showMessage("Invalid calculation method.");
        }
    }

    private Product findProductByName() {
        String name = readInput("Enter product name: ");

        for (Product product : productService.getProducts()) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }

        showMessage("Product not found: " + name);
        return null;
    }

    private String readInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private int readInt(String prompt) {
        return Integer.parseInt(readInput(prompt));
    }

    private double readDouble(String prompt) {
        return Double.parseDouble(readInput(prompt));
    }

    private void showMessage(String message) {
        System.out.println(message);
    }
}
