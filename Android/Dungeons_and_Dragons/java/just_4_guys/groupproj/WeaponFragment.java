package just_4_guys.groupproj;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WeaponFragment extends Fragment {
    RelativeLayout relativeLayout;
    View view;
    Bundle bundle;
    int position;
    TextView header, cost, damage, weight, properties, description;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.weapon_relativelayout);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bundle = getArguments();
        position = bundle.getInt("Position");

        view = inflater.inflate(R.layout.weapon_linearlayout, container, false);

        header = (TextView) view.findViewById(R.id.weapon_header);
        cost = (TextView) view.findViewById(R.id.weapon_cost);
        damage = (TextView) view.findViewById(R.id.weapon_damage);
        weight = (TextView) view.findViewById(R.id.weapon_weight);
        description = (TextView) view.findViewById(R.id.weapon_description);
        properties = (TextView) view.findViewById(R.id.weapon_properties);
        description.setMovementMethod(new ScrollingMovementMethod());
        switch (position) {
            case 0:
                header.setText("Club");
                cost.setText("Cost: 1 sp");
                damage.setText("Damage: 1d4 bludgeoning");
                weight.setText("Weight: 2 lb.");
                properties.setText("Properties: Light");
                description.setText("Simple primative wooden club.");
                break;

            case 1:
                header.setText("Dagger");
                cost.setText("Cost: 2 gp");
                damage.setText("Damage: 1d4 piercing");
                weight.setText("Weight: 1 lb.");
                properties.setText("Properties: Finesse, Light,"+" Thrown(range 20/60)");
                description.setText("A long knife perfectly suited for thrusting or throwing.");
                break;

            case 2:
                header.setText("Greatclub");
                cost.setText("Cost: 2 sp");
                damage.setText("Damage: 1d8 bludgeoning");
                weight.setText("Weight: 10 lb.");
                properties.setText("Properties: Two-handed");
                description.setText("A large two-handed club made of heavy wood");
                break;

            case 3:
                header.setText("Handaxe");
                cost.setText("Cost: 5 gp");
                damage.setText("Damage: 1d6 slashing");
                weight.setText("Weight: 2 lb.");
                properties.setText("Properties: Light, Thrown(range 20/60)");
                description.setText("A short handeled axe frequently used by woodsmen and explorers.+");
                break;

            case 4:
                header.setText("Javelin");
                cost.setText("Cost: 5 sp");
                damage.setText("Damage: 1d6 piercing");
                weight.setText("Weight: 2 lb.");
                properties.setText("Properties: Thrown(range 30/120)");
                description.setText("A light spear designed primarily to be thrown");
                break;

            case 5:
                header.setText("Light Hammer");
                cost.setText("Cost: 2 gp");
                damage.setText("Damage: 1d4 bludgeoning");
                weight.setText("Weight: 2 lb.");
                properties.setText("Properties: Light, Thrown(range 20/60)");
                description.setText("A small short handled hammer perfect for cracking rocks or skulls.");
                break;

            case 6:
                header.setText("Mace");
                cost.setText("Cost: 5 gp");
                damage.setText("Damage: 1d6 bludgeoning");
                weight.setText("Weight: 4 lb.");
                properties.setText("Properties:");
                description.setText("A blunt weapon consisting of a heavy metal head on the end of handle.");
                break;

            case 7:
                header.setText("Quarterstaff");
                cost.setText("Cost: 2 sp");
                damage.setText("Damage: 1d6 bludgeoning");
                weight.setText("Weight: 4 lb.");
                properties.setText("Properties: Versatile (1d8)");
                description.setText("A long wooden pole suited for use as a walking stick or blunt weapon.");
                break;

            case 8:
                header.setText("Sickle");
                cost.setText("Cost: 1 gp");
                damage.setText("Damage: 1d4 slashing");
                weight.setText("Weight: 2 lb.");
                properties.setText("Properties: Light");
                description.setText("A one handed weapon consisting of a curved blade on the end of a short handle.");
                break;

            case 9:
                header.setText("Spear");
                cost.setText("Cost: 1 gp");
                damage.setText("Damage: 1d6 slashing");
                weight.setText("Weight: 3 lb.");
                properties.setText("Properties: Thrown (range 20/60), Versatile (1d8)");
                description.setText("a classic weapon made from a long wooden shaft tipped by a metal point.");
                break;

            case 10:
                header.setText("Unarmed Strike");
                cost.setText("Cost:");
                damage.setText("Damage: 1 bludgeoning");
                weight.setText("Weight:");
                description.setText("literaly just your fists.");
                break;

            case 11:
                header.setText("Crossbow, Light");
                cost.setText("Cost: 25 gp");
                damage.setText("Damage: 1d8 piercing");
                weight.setText("Weight: 5 lb.");
                properties.setText("Properties: Ammunition (range 80/320), Loading, Two-Handed");
                description.setText("A projectile weapon consisting of a horizontal bow-like assembly mounted on a stock");
                break;

            case 12:
                header.setText("Dart");
                cost.setText("Cost: 5 cp");
                damage.setText("Damage: 1d4 piercing");
                weight.setText("Weight: 1/4 lb.");
                properties.setText("Properties: Finesse, thrown (range 20/60)");
                description.setText("Small pointed darts made for throwing, deadly in the right hands.");
            break;

            case 13:
                header.setText("Shortbow");
                cost.setText("Cost: 25 gp");
                damage.setText("Damage: 1d6 piercing");
                weight.setText("Weight: 2 lb.");
                properties.setText("Properties: Ammunition (range 80/320), Two-handed");
                description.setText("The more compact form of the longbow. used to fire arrows great distances.");
                break;

            case 14:
                header.setText("Sling");
                cost.setText("Cost: 1 sp");
                damage.setText("Damage: 1d4 bludgeoning");
                weight.setText("Weight:");
                properties.setText("Properties: Ammunition (range 80/320), Two-handed");
                description.setText("A cloth or rope used to fling rocks at higher speeds and distances than otherwise possible");
                break;

            case 15:
                header.setText("Battleaxe");
                cost.setText("Cost: 10 gp");
                damage.setText("Damage: 1d8 slashing");
                weight.setText("Weight: 4 lb.");
                properties.setText("Properties: Versatile (1d10)");
                description.setText("A large broad-bladed axe");
                break;

            case 16:
                header.setText("Flail");
                cost.setText("Cost: 10 gp");
                damage.setText("Damage: 1d8 bludgeoning");
                weight.setText("Weight: 2 lb.");
                properties.setText("Properties:");
                description.setText("A blunt weapon cosisting of a heavy metal weight connected to a handle by a short chain.");
                break;

            case 17:
                header.setText("Glaive");
                cost.setText("Cost: 20 gp");
                damage.setText("Damage: 1d10 slashing");
                weight.setText("Weight: 6 lb.");
                properties.setText("Properties: Heavy, Reach, Two-handed");
                description.setText("A weapon consisting of a single edged sword like blade on the end of a long pole.");
                break;

            case 18:
                header.setText("Greataxe");
                cost.setText("Cost: 30 gp");
                damage.setText("Damage: 1d12 slashing");
                weight.setText("Weight: 7 lb.");
                properties.setText("Properties: Heavy, Two-handed");
                description.setText("The heavier longer handled version of the Battleaxe.");
                break;

            case 19:
                header.setText("Greatsword");
                cost.setText("Cost: 50 gp");
                damage.setText("Damage: 2d6 slashing");
                weight.setText("Weight: 6 lb.");
                properties.setText("Properties: Heavy, Two-handed");
                description.setText("A massive sword too heavy to be held in one hand.");
                break;

            case 20:
                header.setText("Halberd");
                cost.setText("Cost: 20 gp");
                damage.setText("Damage: 1d10 slashing");
                weight.setText("Weight: 6 lb.");
                properties.setText("Properties: Heavy, Reach, Two-handed");
                description.setText("A polearm featuring an axe-head on a long spear shaft.");
                break;

            case 21:
                header.setText("Lance");
                cost.setText("Cost: 10 gp");
                damage.setText("Damage: 1d12 piercing");
                weight.setText("Weight: 6 lb.");
                properties.setText("Properties: Reach, Special");
                description.setText("(Special:  You have disadvantage when you use a lance\n" +
                        "to attack a target within 5 feet of you. Also, a lance\n" +
                        "requires two hands to wield when you aren’t mounted.)\n\n"+
                        "a long weapon for thrusting, having a wooden shaft and a pointed steel head, used by a horseman in charging");
                break;

            case 22:
                header.setText("Longsword");
                cost.setText("Cost: 15 gp");
                damage.setText("Damage: 1d8 slashing");
                weight.setText("Weight: 3 lb.");
                properties.setText("Properties: Versatile (1d10)");
                description.setText("A long bladed sword standard fair for knights and warriors af all varieties.");
                break;

            case 23:
                header.setText("Maul");
                cost.setText("Cost: 10 gp");
                damage.setText("Damage: 2d6 bludgeoning");
                weight.setText("Weight: 10 lb.");
                properties.setText("Properties: Heavy, Two-handed");
                description.setText("A heavy hammer head on a long pole.");
                break;

            case 24:
                header.setText("Morningstar");
                cost.setText("Cost: 15 gp");
                damage.setText("Damage: 1d8 piercing");
                weight.setText("Weight: 4 lb.");
                properties.setText("Properties:");
                description.setText("A weapon similar to a mace but featuring sharp spikes on the head for added damage.");
                break;

            case 25:
                header.setText("Pike");
                cost.setText("Cost: 5 gp");
                damage.setText("Damage: 1d10 piercing");
                weight.setText("Weight: 18 lb.");
                properties.setText("Properties: Heavy, Reach, Two-handed");
                description.setText("An extreamly long spear. Useful for keeping foes at a distance.");
                break;

            case 26:
                header.setText("Rapier");
                cost.setText("Cost: 25 gp");
                damage.setText("Damage: 1d8 piercing");
                weight.setText("Weight: 2 lb.");
                properties.setText("Properties: Finesse");
                description.setText("A light sword made more for thrusting then slashing");
                break;

            case 27:
                header.setText("Scimitar");
                cost.setText("Cost: 25 gp");
                damage.setText("Damage: 1d6 slashing");
                weight.setText("Weight: 3 lb.");
                properties.setText("Properties:  Finesse, Light");
                description.setText("A short sword with a curving blade that broadens near the point.");
                break;

            case 28:
                header.setText("Shortsword");
                cost.setText("Cost: 10 gp");
                damage.setText("Damage: 1d6 piercing");
                weight.setText("Weight: 2 lb.");
                properties.setText("Properties:  Finesse, Light");
                description.setText("A simple sword. Small enough to duel wield if one were so inclined.");
                break;

            case 29:
                header.setText("Trident");
                cost.setText("Cost: 5 gp");
                damage.setText("Damage: 1d6 piercing");
                weight.setText("Weight: 4 lb.");
                properties.setText("Properties:  Thrown (range 20/60), Versatile (1d8)");
                description.setText("A spear with three points, if one is good then three must be even better.");
                break;

            case 30:
                header.setText("War Pick");
                cost.setText("Cost: 5 gp");
                damage.setText("Damage: 1d8 piercing");
                weight.setText("Weight: 2 lb.");
                properties.setText("Properties: ");
                description.setText("A mining tool repurposed as a weapon.");
                break;

            case 31:
                header.setText("Warhammer");
                cost.setText("Cost: 15 gp");
                damage.setText("Damage: 1d8 bludgeoning");
                weight.setText("Weight: 2 lb.");
                properties.setText("Properties: Versatile(1d10)");
                description.setText("A massive hammer.");
                break;

            case 32:
                header.setText("Whip");
                cost.setText("Cost: 2 gp");
                damage.setText("Damage: 1d4 slashing");
                weight.setText("Weight: 3 lb.");
                properties.setText("Properties:  Finesse, Reach");
                description.setText("A strip of leather or length of cord fastened to a handle capable of inflicting painfull lashes.");
                break;

            case 33:
                header.setText("Blowgun");
                cost.setText("Cost: 10 gp");
                damage.setText("Damage: 1 piercing");
                weight.setText("Weight: 1 lb.");
                properties.setText("Properties: Ammunition (range 25/100), Loading");
                description.setText("A thin tube used to launch small darts by blowing.");
                break;

            case 34:
                header.setText("Crossbow, Hand");
                cost.setText("Cost: 75 gp");
                damage.setText("Damage: 1d6 piercing");
                weight.setText("Weight: 3 lb.");
                properties.setText("Properties: Ammunition (range 30/120), Light, Loading");
                description.setText("A more compact version of the crossbow, made to be fired from one hand. Makes a great backup weapon.");
                break;

            case 35:
                header.setText("Crossbow, Heavy");
                cost.setText("Cost: 50 gp");
                damage.setText("Damage: 1d10 piercing");
                weight.setText("Weight: 18 lb.");
                properties.setText("Properties: Ammunition (range 100/400), Heavy, Loading, Two-handed");
                description.setText("A larger crossbow with a higher draw weight meaning more power and distance.");
                break;

            case 36:
                header.setText("Longbow");
                cost.setText("Cost: 50 gp");
                damage.setText("Damage: 1d8 piercing");
                weight.setText("Weight: 2 lb.");
                properties.setText("Properties: Ammunition (range 150/600), Heavy, Two-handed");
                description.setText("A bow around 6 feet in length only for the most well trained of archers.");
                break;
            case 37:
                header.setText("Net");
                cost.setText("Cost: 1 gp");
                damage.setText("Damage:");
                weight.setText("Weight: 3 lb.");
                properties.setText("Properties: Special, Thrown (range 5/15)");
                description.setText("(Special: A Large or smaller creature hit by a net is" +
                        "restrained until it is freed. A net has no effect on" +
                        "creatures that are form less, or creatures that are Huge" +
                        "or larger. A creature can use its action to make a DC 10" +
                        "Strength check, freeing itself or another creature within" +
                        "its reach on a success. Dealing 5 slashing damage to the" +
                        "net (AC 10) also frees the creature without harming it," +
                        "ending the effect and destroying the net." +
                        "When you use an action, bonus action, or reaction " +
                        "to attack with a net, you can make only one attack" +
                        "regardless of the number of attacks you can" +
                        "normally make.)\n"+
                        "A mesh of rope used to entrap and entagle.");
                break;
        }
        return view;
    }
}