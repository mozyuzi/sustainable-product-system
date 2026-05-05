package se.sustainableproductsystem.domain.model;

public class RecyclingGuidance {
    private final String summary;

    public RecyclingGuidance(String summary) {
        if (summary == null || summary.isBlank()) {
            throw new IllegalArgumentException("Recycling guidance summary cannot be empty.");
        }
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }
}
