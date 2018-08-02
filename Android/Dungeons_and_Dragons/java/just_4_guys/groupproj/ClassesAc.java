package just_4_guys.groupproj;

public class ClassesAc {
    private String name;
    private String hitDice;
    private String proficiencies;
    private String savingThrows;

    @Override
    public String toString() {
        return name;
    }

    public String getHitDice() { return hitDice;}

    public String getSavingThrows() {return savingThrows;}

    public String getProficiencies() {
        return proficiencies;
    }


}