package just_4_guys.groupproj;

public class Armor {
    private String armorName;
    private String armorCost;
    private String armorAC;
    private String armorWeight;

    @Override
    public String toString() {
        return armorName;
    }

    public String getArmorCost() {
        return armorCost;
    }

    public String getArmorAC() {
        return armorAC;
    }

    public String getArmorWeight() {
        return armorWeight;
    }
}