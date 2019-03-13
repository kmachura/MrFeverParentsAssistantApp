package Com.MrFever.Model;

public class Medicine {
    private String substance;
    private String type;

    public String getSubstance() {
        return substance;
    }

    public void setSubstance(String substance) {
        this.substance = substance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Medicine() {}

    public Medicine(String substance, String type){
        this.setSubstance(substance);
        this.setType(type);
    }
}
