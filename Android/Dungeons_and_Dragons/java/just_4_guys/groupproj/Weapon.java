package just_4_guys.groupproj;

public class Weapon {
    public String name;
    public String catagory;
    private String cost;
    private String damage;
    private String weight;
    private String damage_type;
    private String properties;

    @Override
    public String toString() {
        return name;
    }

    public String getCatagory() { return catagory;}

    public String getCost() {
        return cost;
    }

    public String getDamage() {
        return damage;
    }

    public String getWeight() {
        return weight;
    }

    public String getDamage_type() {
        return damage_type;
    }

    public String getProperties() {
        return properties;
    }
}