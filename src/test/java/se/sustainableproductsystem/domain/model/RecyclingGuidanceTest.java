package se.sustainableproductsystem.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RecyclingGuidanceTest {
    @Test
    void constructor_shouldStoreSummary() {
        RecyclingGuidance guidance = new RecyclingGuidance("Recycle in plastic bin.");

        assertEquals("Recycle in plastic bin.", guidance.getSummary());
    }

    @Test
    void constructor_shouldRejectEmptySummary() {
        assertThrows(IllegalArgumentException.class, () -> new RecyclingGuidance(""));
    }
}
