package just_4_guys.groupproj;

public class Race {
    private String name;
    private String ability;
    private String speed;
    private String size;
    private String weapon;
    private String languages;

    @Override
    public String toString() {
        return name;
    }

    public String getAbility() {
        return ability;
    }

    public String getSpeed() {
        return speed;
    }

    public String getSize() {
        return size;
    }

    public String getWeapon() {
        return weapon;
    }

    public String getLanguages() {
        return languages;
    }
}