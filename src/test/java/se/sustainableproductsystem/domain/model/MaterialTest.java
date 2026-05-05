package se.sustainableproductsystem.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MaterialTest {
    @Test
    void constructor_shouldStoreMaterialValues() {
        RecyclingCategory recyclingCategory = new RecyclingCategory("Metal");
        Material material = new Material("Aluminium", 2.5, recyclingCategory, "Recycle as metal.");

        assertEquals("Aluminium", material.getName());
        assertEquals(2.5, material.getImpactValue());
        assertEquals(recyclingCategory, material.getRecyclingCategory());
        assertEquals("Recycle as metal.", material.getRecyclingInstruction());
    }

    @Test
    void constructor_shouldRejectNegativeImpactValue() {
        RecyclingCategory recyclingCategory = new RecyclingCategory("Metal");

        assertThrows(
                IllegalArgumentException.class,
                () -> new Material("Aluminium", -0.1, recyclingCategory, "Recycle as metal.")
        );
    }
}
