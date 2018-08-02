package just_4_guys.groupproj;

public class Equipment {
    private String equipmentName;
    private String equipmentCost;
    private String equipmentWeight;

    @Override
    public String toString() {
        return equipmentName;
    }

    public String getEquipmentCost() {
        return equipmentCost;
    }

    public String getEquipmentWeight() {
        return equipmentWeight;
    }
}