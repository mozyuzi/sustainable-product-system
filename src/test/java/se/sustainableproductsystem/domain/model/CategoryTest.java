package se.sustainableproductsystem.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CategoryTest {
    @Test
    void constructor_shouldStoreName() {
        Category category = new Category("Electronics");

        assertEquals("Electronics", category.getName());
    }

    @Test
    void constructor_shouldRejectEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Category(""));
    }
}
