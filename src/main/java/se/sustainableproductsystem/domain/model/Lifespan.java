package se.sustainableproductsystem.domain.model;

public class Lifespan {
    private final int years;

    public Lifespan(int years) {
        if (years < 0) {
            throw new IllegalArgumentException("Lifespan cannot be negative.");
        }
        this.years = years;
    }

    public int getYears() {
        return years;
    }
}
