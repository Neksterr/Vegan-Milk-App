package project.Vegan_Milk.order;

public enum MilkFlavor {
    VANILLA("Vanilla"),
    CHOCOLATE("Chocolate"),
    MATCHA("Matcha"),
    STRAWBERRY("Strawberry");

    private final String label;

    MilkFlavor(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
