package se.sustainableproductsystem.domain.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import se.sustainableproductsystem.domain.model.Category;
import se.sustainableproductsystem.domain.model.Lifespan;
import se.sustainableproductsystem.domain.model.Material;
import se.sustainableproductsystem.domain.model.Product;
import se.sustainableproductsystem.domain.model.RecyclingCategory;

class SimpleImpactCalculationTest {
    @Test
    void calculateImpact_shouldReturnSumOfMaterialImpactValues() {
        Product product = productWithMaterials(
                material("Plastic", 1.5),
                material("Metal", 2.5)
        );
        SimpleImpactCalculation calculation = new SimpleImpactCalculation();

        double impact = calculation.calculateImpact(product);

        assertEquals(4.0, impact);
    }

    @Test
    void calculateImpact_shouldReturnZeroWhenProductHasNoMaterials() {
        Product product = new Product("Notebook", new Category("Office"), new Lifespan(2), List.of());
        SimpleImpactCalculation calculation = new SimpleImpactCalculation();

        double impact = calculation.calculateImpact(product);

        assertEquals(0.0, impact);
    }

    private Product productWithMaterials(Material... materials) {
        return new Product("Bottle", new Category("Kitchen"), new Lifespan(3), List.of(materials));
    }

    private Material material(String name, double impactValue) {
        return new Material(name, impactValue, new RecyclingCategory(name), "Recycle as " + name + ".");
    }
}
