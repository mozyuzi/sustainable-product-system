package se.sustainableproductsystem.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LifespanTest {
    @Test
    void constructor_shouldStoreYears() {
        Lifespan lifespan = new Lifespan(5);

        assertEquals(5, lifespan.getYears());
    }

    @Test
    void constructor_shouldRejectNegativeYears() {
        assertThrows(IllegalArgumentException.class, () -> new Lifespan(-1));
    }
}
