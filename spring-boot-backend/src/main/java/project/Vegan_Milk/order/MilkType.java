package project.Vegan_Milk.order;

public enum MilkType {
    ALMOND("Almond Milk"),
    OAT("Oat Milk"),
    COCONUT("Coconut Milk"),
    SOY("Soy Milk");

    private final String label;

    MilkType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
