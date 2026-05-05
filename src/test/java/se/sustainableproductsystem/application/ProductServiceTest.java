package se.sustainableproductsystem.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import se.sustainableproductsystem.domain.model.Material;
import se.sustainableproductsystem.domain.model.Product;
import se.sustainableproductsystem.domain.strategy.AdvancedImpactCalculation;
import se.sustainableproductsystem.domain.strategy.SimpleImpactCalculation;

class ProductServiceTest {
    @Test
    void calculateImpactByName_shouldUseCurrentStrategy() {
        ProductService service = new ProductService(new SimpleImpactCalculation());
        Material plastic = service.createMaterial("Plastic", 2.0, "Plastic", "Recycle as plastic.");
        Material metal = service.createMaterial("Metal", 3.0, "Metal", "Recycle as metal.");
        service.createProduct("Bottle", "Kitchen", 3, List.of(plastic, metal));

        service.setImpactCalculationStrategy(new AdvancedImpactCalculation());
        double impact = service.calculateImpactByName("Bottle");

        assertEquals(6.0, impact);
    }

    @Test
    void calculateImpactByName_shouldThrowExceptionWhenProductDoesNotExist() {
        ProductService service = new ProductService(new SimpleImpactCalculation());

        assertThrows(IllegalArgumentException.class, () -> service.calculateImpactByName("Missing"));
    }

    @Test
    void getRecyclingGuidance_shouldDescribeMixedMaterialProducts() {
        ProductService service = new ProductService(new SimpleImpactCalculation());
        Material plastic = service.createMaterial("Plastic", 2.0, "Plastic", "Recycle as plastic.");
        Material metal = service.createMaterial("Metal", 3.0, "Metal", "Recycle as metal.");
        Product product = service.createProduct("Bottle", "Kitchen", 3, List.of(plastic, metal));

        String summary = service.getRecyclingGuidance(product).getSummary();

        assertEquals(
                "Mixed-material product. Separate materials if possible. Plastic: Recycle as plastic.; Metal: Recycle as metal.",
                summary
        );
    }
}
