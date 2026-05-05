package se.sustainableproductsystem.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RecyclingCategoryTest {
    @Test
    void constructor_shouldStoreName() {
        RecyclingCategory category = new RecyclingCategory("Plastic");

        assertEquals("Plastic", category.getName());
    }

    @Test
    void constructor_shouldRejectEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new RecyclingCategory(" "));
    }
}
