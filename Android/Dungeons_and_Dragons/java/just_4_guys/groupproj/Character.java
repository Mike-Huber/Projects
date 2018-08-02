package just_4_guys.groupproj;

public class Character {
    private String name;
    private int level;
    private String char_class;
    private String race;
    private int str;
    private int str_mod;
    private int dex;
    private int dex_mod;
    private int con;
    private int con_mod;
    private int intel;
    private int intel_mod;
    private int wis;
    private int wis_mod;

    Character(String nm, int lvl, String chrClass, String rc, int s, int sm, int d, int dm, int c, int cm, int i, int im, int w, int wm) {
        name = nm;
        level = lvl;
        char_class = chrClass;
        race = rc;
        str = s;
        str_mod = sm;
        dex = d;
        dex_mod = dm;
        con = c;
        con_mod = cm;
        intel = i;
        intel_mod = im;
        wis = w;
        wis_mod = wm;
    }

    public String getName() { return name; }

    public int getLevel() { return level; }

    public String getChar_class() { return char_class; }

    public String getRace() { return race; }

    public int getStr() { return str; }

    public int getStr_mod() { return str_mod; }

    public int getDex() { return dex; }

    public int getDex_mod() { return dex_mod; }

    public int getCon() {return con; }

    public int getCon_mod() { return con_mod; }

    public int getIntel() { return intel; }

    public int getIntel_mod() { return intel_mod; }

    public int getWis() { return wis; }

    public int getWis_mod() { return wis_mod; }
}
