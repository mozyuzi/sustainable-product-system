package se.sustainableproductsystem.domain.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import se.sustainableproductsystem.domain.model.Category;
import se.sustainableproductsystem.domain.model.Lifespan;
import se.sustainableproductsystem.domain.model.Material;
import se.sustainableproductsystem.domain.model.Product;
import se.sustainableproductsystem.domain.model.RecyclingCategory;

class AdvancedImpactCalculationTest {
    @Test
    void calculateImpact_shouldApplyMixedMaterialMultiplierForMultipleMaterials() {
        Product product = productWithMaterials(
                material("Plastic", 2.0),
                material("Metal", 3.0)
        );
        AdvancedImpactCalculation calculation = new AdvancedImpactCalculation();

        double impact = calculation.calculateImpact(product);

        assertEquals(6.0, impact);
    }

    @Test
    void calculateImpact_shouldNotApplyMultiplierForSingleMaterial() {
        Product product = productWithMaterials(material("Glass", 4.0));
        AdvancedImpactCalculation calculation = new AdvancedImpactCalculation();

        double impact = calculation.calculateImpact(product);

        assertEquals(4.0, impact);
    }

    @Test
    void calculateImpact_shouldReturnZeroWhenProductHasNoMaterials() {
        Product product = new Product("Notebook", new Category("Office"), new Lifespan(2), List.of());
        AdvancedImpactCalculation calculation = new AdvancedImpactCalculation();

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
