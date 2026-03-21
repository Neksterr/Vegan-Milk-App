package project.Vegan_Milk.order;

public enum MilkSize {
    ML_250(250, "250ml"),
    ML_350(350, "350ml"),
    ML_400(400, "400ml");

    private final int ml;
    private final String label;

    MilkSize(int ml, String label) {
        this.ml = ml;
        this.label = label;
    }

    public int getMl() {
        return ml;
    }

    public String getLabel() {
        return label;
    }
}
