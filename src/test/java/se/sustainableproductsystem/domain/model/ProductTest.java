package se.sustainableproductsystem.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class ProductTest {
    @Test
    void constructor_shouldStoreProductValues() {
        Category category = new Category("Electronics");
        Lifespan lifespan = new Lifespan(4);
        Material plastic = new Material("Plastic", 1.0, new RecyclingCategory("Plastic"), "Recycle as plastic.");

        Product product = new Product("Keyboard", category, lifespan, List.of(plastic));

        assertEquals("Keyboard", product.getName());
        assertEquals(category, product.getCategory());
        assertEquals(lifespan, product.getLifespan());
        assertEquals(List.of(plastic), product.getMaterials());
    }

    @Test
    void getMaterials_shouldReturnUnmodifiableList() {
        Product product = new Product("Keyboard", new Category("Electronics"), new Lifespan(4), List.of());

        assertThrows(UnsupportedOperationException.class, () -> product.getMaterials().add(
                new Material("Plastic", 1.0, new RecyclingCategory("Plastic"), "Recycle as plastic.")
        ));
    }
}
