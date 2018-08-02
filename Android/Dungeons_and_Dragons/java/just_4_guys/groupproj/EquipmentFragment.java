package just_4_guys.groupproj;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EquipmentFragment extends Fragment {
    RelativeLayout relativeLayout;
    View view;
    Bundle bundle;
    int position;
    TextView header, cost, weight, description;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.equipment_relativelayout);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bundle = getArguments();
        position = bundle.getInt("Position");

        view = inflater.inflate(R.layout.equipment_relativelayout, container, false);

        header = (TextView) view.findViewById(R.id.equipment_header);
        cost = (TextView) view.findViewById(R.id.equipment_cost);
        weight = (TextView) view.findViewById(R.id.equipment_weight);
        description = (TextView) view.findViewById(R.id.equipment_description);

        switch (position) {
            case 0:
                header.setText("Abacus");
                cost.setText("Cost: 2 gp");
                weight.setText("Weight: 2 lb.");
                description.setText("Simple counting tool.");
                break;

            case 1:
                header.setText("Acid (vial)");
                cost.setText("Cost: 25 gp");
                weight.setText("Weight: 1 lb.");
                description.setText("As an action, you can splash the contents of" +
                        " this vial onto a creature within 5 feet of you or throw" +
                        " the vial up to 20 feet, shattering it on impact. In either" +
                        " case, make a ranged attack against a creature or object," +
                        " treating the acid as an improvised weapon. On a hit, the" +
                        " target takes 2d6 acid damage.");
                break;

            case 2:
                header.setText("Alchemist's fire (flask)");
                cost.setText("Cost: 50 gp");
                weight.setText("Weight: 1 lb.");
                description.setText("This sticky, adhesive fluid ignites" +
                        " when exposed to air. As an action, you can throw this" +
                        " flask up to 20 feet, shattering it on impact. Make a" +
                        " ranged attack against a creature or object, treating" +
                        " the alchemist's fire as an improvised weapon. On a" +
                        " hit, the target takes 1d4 fire damage at the start of" +
                        " each of its turns. A creature can end this dam age by" +
                        " using its action to make a DC 10 Dexterity check to" +
                        " extinguish the flames.");
                break;

            case 3:
                header.setText("Ammunition");
                cost.setText("");
                weight.setText("");
                description.setTextSize(15);
                description.setText("Arrows (20) | Cost: 1 gp | Weight: 1 lb.\n\n" +
                        "Blowgun needles (50) | Cost: 1 gp | Weight: 1 lb.\n\n" +
                        "Crossbow bolts (20) | Cost: 1 gp | Weight: 1.5 lb.\n\n" +
                        "Sling bullets (20) | Cost: 4 cp | Weight: 1.5 lb.");
                break;

            case 4:
                header.setText("Antitoxin (vial)");
                cost.setText("Cost: 50 gp");
                weight.setText("Weight: -");
                description.setText("A creature that drinks this vial of liquid" +
                        " gains advantage on saving throws against poison for 1" +
                        " hour. It confers no benefit to undead or constructs.");
                break;

            case 5:
                header.setText("Arcane focus");
                cost.setText("");
                weight.setText("");
                description.setTextSize(15);
                description.setText("Crystal | Cost: 10 gp | Weight: 1 lb.\n\n" +
                        "Orb | Cost: 20 gp | Weight: 3 lb.\n\n" +
                        "Rod | Cost: 10 gp | Weight: 2 lb.\n\n" +
                        "Staff | Cost: 5 gp | Weight: 4 lb.\n\n" +
                        "Wand | Cost: 10 gp | Weight: 1 lb.");
                break;

            case 6:
                header.setText("Backpack");
                cost.setText("Cost: 2 gp");
                weight.setText("Weight: 5 lb.");
                description.setText("A simple place to store items");
                break;

            case 7:
                header.setText("Ball bearings (bag of 1,000)");
                cost.setText("Cost: 1 gp");
                weight.setText("Weight: 2 lb.");
                description.setText("As an action, you can spill these tiny" +
                        " metal balls from their pouch to cover a level area 10" +
                        " feet square. A creature moving across the covered area" +
                        " must succeed on a DC 10 Dexterity saving throw or fall" +
                        " prone. A creature moving through the area at half speed" +
                        " doesn’t need to make the saving throw.");
                break;

            case 8:
                header.setText("Barrel");
                cost.setText("Cost: 2 gp");
                weight.setText("Weight: 70 lb.");
                description.setText("A simple barrel, can be used to store a large" +
                        " amount of liquids.");
                break;

            case 9:
                header.setText("Basket");
                cost.setText("Cost: 4 sp");
                weight.setText("Weight: 2 lb.");
                description.setText("A simple basket.");
                break;

            case 10:
                header.setText("Bedroll");
                cost.setText("Cost: 1 gp");
                weight.setText("Weight: 7 lb.");
                description.setText("A nice place to sleep when camping out in the wilderness.");
                break;

            case 11:
                header.setText("Bell");
                cost.setText("Cost: 1 gp");
                weight.setText("Weight: -");
                description.setText("Ring, ring, ring!");
                break;

            case 12:
                header.setText("Blanket");
                cost.setText("Cost: 5 sp");
                weight.setText("Weight: 3 lb.");
                description.setText("Keeps a being warm and cozy at night.");
                break;

            case 13:
                header.setText("Block and tackle");
                cost.setText("Cost: 1 gp");
                weight.setText("Weight: 5 lb.");
                description.setText("");
                break;

            case 14:
                header.setText("Book");
                cost.setText("Cost: 25 gp");
                weight.setText("Weight: 5 lb.");
                description.setText("A set of pulleys with a cable" +
                        " threaded through them and a hook to attach to objects, a" +
                        " block and tackle allows you to hoist up to four tim es the" +
                        " weight you can normally lift.");
                break;

            case 15:
                header.setText("Bottle, glass");
                cost.setText("Cost: 2 gp");
                weight.setText("Weight: 2 lb.");
                description.setText("A simple glass bottle - reusable.");
                break;

            case 16:
                header.setText("Bucket");
                cost.setText("Cost: 5 cp");
                weight.setText("Weight: 2 lb.");
                description.setText("A simple bucket.");
                break;

            case 17:
                header.setText("Caltrops (bag of 20)");
                cost.setText("Cost: 1 gp");
                weight.setText("Weight: 2 lb.");
                description.setText("As an action, you can spread a single bag" +
                        " of caltrops to cover a 5-foot-square area. Any creature" +
                        " that enters the area must succeed on a DC 15 Dexterity" +
                        " saving throw or stop moving and take 1 piercing" +
                        " damage. Until the creature regains at least 1 hit point," +
                        " its walking speed is reduced by 10 feet. A creature" +
                        " moving through the area at half speed doesn’t need to" +
                        " make the saving throw.");
                break;

            case 18:
                header.setText("Chain (10 feet)");
                cost.setText("Cost: 5 gp");
                weight.setText("Weight: 10 lb.");
                description.setText("A chain has 10 hit points. It can be burst with a" +
                        " successful DC 20 Strength check.");
                break;

            case 19:
                header.setText("Chest");
                cost.setText("Cost: 5 gp");
                weight.setText("Weight: 25 lb.");
                description.setText("Used to store large quantities of items.");
                break;

            case 20:
                header.setText("Climber's kit");
                cost.setText("Cost: 25 gp");
                weight.setText("Weight: 12 lb.");
                description.setText("A clim ber’s kit includes special pitons," +
                        " boot tips, gloves, and a harness. You can use the" +
                        " clim ber’s kit as an action to anchor yourself; when you" +
                        " do, you can’t fall m ore than 25 feet from the point where" +
                        " you anchored yourself, and you can't climb m ore than 25" +
                        " feet away from that point without undoing the anchor.");
                break;

            case 21:
                header.setText("Component pouch");
                cost.setText("Cost: 25 gp");
                weight.setText("Weight: 2 lb.");
                description.setText("A component pouch is a small," +
                        " watertight leather belt pouch that has compartments" +
                        " to hold all the material components and other special" +
                        " items you need to cast your spells, except for those" +
                        " components that have a specific cost (as indicated in a" +
                        " spell's description).");
                break;

            case 22:
                header.setText("Crowbar");
                cost.setText("Cost: 2 gp");
                weight.setText("Weight: 5 lb.");
                description.setText("Using a crowbar grants advantage" +
                        " to Strength checks where the crow bar’s leverage" +
                        " can be applied.");
                break;

            case 23:
                header.setText("Druidic focus");
                cost.setText("");
                weight.setText("");
                description.setTextSize(15);
                description.setText("Sprig of mistletoe | Cost: 1 gp | Weight: -\n\n" +
                        "Totem | Cost: 1 gp | Weight: -\n\n" +
                        "Wooden staff | Cost: 5 gp | Weight: 4 lb.\n\n" +
                        "Yew wand | Cost: 10 gp | Weight: 1 lb.");
                break;

            case 24:
                header.setText("Fishing tackle");
                cost.setText("Cost: 1 gp");
                weight.setText("Weight: 4 lb.");
                description.setText("This kit includes a wooden rod, silken" +
                        " line, corkwood bobbers, steel hooks, lead sinkers, velvet" +
                        " lures, and narrow netting.");
                break;

            case 25:
                header.setText("Flask or tankard");
                cost.setText("Cost: 2 cp");
                weight.setText("Weight: 1 lb.");
                description.setText("Used to hold drink.");
                break;

            case 26:
                header.setText("Grappling hook");
                cost.setText("Cost: 2 gp");
                weight.setText("Weight: 4 lb.");
                description.setText("Using a grappling hook grants advantage to Strength checks" +
                    " when climbing steep cliffs and other areas of the sort.");
                break;

            case 27:
                header.setText("Hammer");
                cost.setText("Cost: 1 gp");
                weight.setText("Weight: 3 lb.");
                description.setText("A simple hammer, can be used as an improvised weapon.");
                break;

            case 28:
                header.setText("Healer's kit");
                cost.setText("Cost: 5 gp");
                weight.setText("Weight: 3 lb.");
                description.setText("This kit is a leather pouch containing" +
                        " bandages, salves, and splints. The kit has ten uses. As" +
                        " an action, you can expend one use of the kit to stabilize" +
                        " a creature that has 0 hit points, without needing to make" +
                        " a Wisdom (Medicine) check.");
                break;

            case 29:
                header.setText("Holy Symbol");
                cost.setText("");
                weight.setText("");
                description.setTextSize(15);
                description.setText("Amulet | Cost: 5 gp | Weight: 1 lb.\n\n" +
                        "Emblem | Cost: 5 gp | Weight: -\n\n" +
                        "Reliquary | Cost: 5 gp | Weight: 2 lb.");
                break;

            case 30:
                header.setText("Hourglass");
                cost.setText("Cost: 25 gp");
                weight.setText("Weight: 1 lb.");
                description.setText("Makes it easier to tell time.");
                break;

            case 31:
                header.setText("Hunting trap");
                cost.setText("Cost: 5 gp");
                weight.setText("Weight: 25 lb.");
                description.setText("W hen you use your action to set it," +
                        " this trap form s a saw-toothed steel ring that snaps shut" +
                        " when a creature steps on a pressure plate in the center." +
                        " The trap is affixed by a heavy chain to an immobile" +
                        " object, such as a tree or a spike driven into the ground." +
                        " A creature that steps on the plate must succeed on a DC" +
                        " 13 Dexterity saving throw or take 1d4 piercing damage" +
                        " and stop moving. Thereafter, until the creature breaks" +
                        " free of the trap, its movement is limited by the length" +
                        " of the chain (typically 3 feet long). A creature can use" +
                        " its action to make a DC 13 Strength check, freeing" +
                        " itself or another creature within its reach on a success." +
                        " Each failed check deals 1 piercing damage to the" +
                        " trapped creature.");
                break;

            case 32:
                header.setText("Ink (1 ounce bottle)");
                cost.setText("Cost: 10 gp");
                weight.setText("Weight: -");
                description.setText("Used with an ink pen to write on paper or parchment.");
                break;

            case 33:
                header.setText("Ink pen");
                cost.setText("Cost: 2 cp");
                weight.setText("Weight: -");
                description.setText("Used with ink to write on paper or parchment.");
                break;

            case 34:
                header.setText("Ladder (10-foot)");
                cost.setText("Cost: 1 sp");
                weight.setText("Weight: 25 lb.");
                description.setText("Comes in handy when needing to reach high places.");
                break;

            case 35:
                header.setText("Lamp");
                cost.setText("Cost: 5 sp");
                weight.setText("Weight: 1 lb.");
                description.setText("A lamp casts bright light in a 15-foot radius" +
                        " and dim light for an additional 30 feet. Once lit, it burns" +
                        " for 6 hours on a flask (1 pint) of oil.");
                break;

            case 36:
                header.setText("Lock");
                cost.setText("Cost: 10 gp");
                weight.setText("Weight: 1 lb.");
                description.setText("A key is provided with the lock. Without the" +
                        " key, a creature proficient with thieves’ tools can pick" +
                        " this lock with a successful DC 15 Dexterity check." +
                        " Your DM may decide that better locks are available" +
                        " for higher prices.");
                break;

            case 37:
                header.setText("Magnifying glass");
                cost.setText("Cost: 100 gp");
                weight.setText("Weight: -");
                description.setText("This lens allows a closer look at" +
                        " small objects. It is also useful as a substitute for flint" +
                        " and steel when starting fires. Lighting a fire with a" +
                        " magnifying glass requires light as bright as sunlight to" +
                        " focus, tinder to ignite, and about 5 minutes for the fire" +
                        " to ignite. A m agnifying glass grants advantage on any" +
                        " ability check made to appraise or inspect an item that is" +
                        " small or highly detailed.");
                break;

            case 38:
                header.setText("Mess kit");
                cost.setText("Cost: 2 sp");
                weight.setText("Weight: 6 lb.");
                description.setText("This tin box contains a cup and simple" +
                        " cutlery. The box clam ps together, and one side can" +
                        " be used as a cooking pan and the other as a plate or" +
                        " shallow bowl.");
                break;

            case 39:
                header.setText("Mining pick");
                cost.setText("Cost: 2 gp");
                weight.setText("Weight: 10 lb.");
                description.setText("Used to obtain ore from veins.");
                break;

            case 40:
                header.setText("Paper (one sheet)");
                cost.setText("Cost: 2 sp");
                weight.setText("Weight: -");
                description.setText("Can be written on with ink and an ink pen.");
                break;

            case 41:
                header.setText("Poison, basic (vial)");
                cost.setText("Cost: 100 gp");
                weight.setText("Weight: -");
                description.setText("You can use the poison in this vial" +
                        " to coat one slashing or piercing weapon or up to three" +
                        " pieces of ammunition. Applying the poison takes" +
                        " an action. A creature hit by the poisoned weapon or" +
                        " ammunition must make a DC 10 Constitution saving" +
                        " throw or take 1d4 poison damage. Once applied, the" +
                        " poison retains potency for 1 minute before drying.");
                break;

            case 42:
                header.setText("Potion of healing");
                cost.setText("Cost: 50 gp");
                weight.setText("Weight: 1/2 lb.");
                description.setText("A character w ho drinks the magical" +
                        " red fluid in this vial regains 2d4 + 2 hit points. Drinking" +
                        " or administering a potion takes an action.");
                break;

            case 43:
                header.setText("Pouch");
                cost.setText("Cost: 5 sp");
                weight.setText("Weight: 1 lb.");
                description.setText("A cloth or leather pouch can hold up to 20" +
                        " sling bullets or 50 blowgun needles, among other" +
                        " things. A compartmentalized pouch for holding spell" +
                        " components is called a component pouch (described" +
                        " earlier in this section)");
                break;

            case 44:
                header.setText("Quiver");
                cost.setText("Cost: 1 gp");
                weight.setText("Weight: 1 lb.");
                description.setText("A quiver can hold up to 20 arrows.");
                break;

            case 45:
                header.setText("Rations (1 day)");
                cost.setText("Cost: 5 sp");
                weight.setText("Weight: 2 lb.");
                description.setText("Rations consist of dry foods suitable" +
                        " for extended travel, including jerky, dried fruit," +
                        " hardtack, and nuts.");
                break;

            case 46:
                header.setText("Rope, hempen (50 feet)");
                cost.setText("Cost: 1 gp");
                weight.setText("Weight: 10 lb.");
                description.setText("Rope, whether made of hemp or silk, has 2 hit" +
                        " points and can be burst with a DC 17 Strength check.");
                break;

            case 47:
                header.setText("Sack");
                cost.setText("Cost: 1 cp");
                weight.setText("Weight: 1/2 lb.");
                description.setText("A simple sack, has multiple purposes");
                break;

            case 48:
                header.setText("Scale, merchant's");
                cost.setText("Cost: 5 gp");
                weight.setText("Weight: 3 lb.");
                description.setText(" A scale includes a small balance," +
                        " pans, and a suitable assortment of weights up to 2" +
                        " pounds. W ith it, you can measure the exact weight of" +
                        " small objects, such as raw precious metals or trade" +
                        " goods, to help determine their worth.");
                break;

            case 49:
                header.setText("Sealing wax");
                cost.setText("Cost: 5 sp");
                weight.setText("Weight: -");
                description.setText("Used to keep envelopes and such closed.");
                break;

            case 50:
                header.setText("Shovel");
                cost.setText("Cost: 2 gp");
                weight.setText("Weight: 5 lb.");
                description.setText("Useful for digging up treasure.. Or a grave.");
                break;

            case 51:
                header.setText("Signet ring");
                cost.setText("Cost: 5 gp");
                weight.setText("Weight: -");
                description.setText("Exquisite looking ring.");
                break;

            case 52:
                header.setText("Spellbook");
                cost.setText("Cost: 50 gp");
                weight.setText("Weight: 3 lb.");
                description.setText("Essential for wizards, a spellbook is" +
                        " a leather-bound tome with 100 blank vellum pages" +
                        " suitable for recording spells.");
                break;

            case 53:
                header.setText("Spyglass");
                cost.setText("Cost: 1,000 gp");
                weight.setText("Weight: 1 lb.");
                description.setText("Objects viewed through a spyglass are" +
                        " magnified to tw ice their size.");
                break;

            case 54:
                header.setText("Tent, two-person");
                cost.setText("Cost: 2 gp");
                weight.setText("Weight: 20 lb.");
                description.setText("A simple and portable canvas shelter, a" +
                        " tent sleeps two.");
                break;

            case 55:
                header.setText("Tinderbox");
                cost.setText("Cost: 5 sp");
                weight.setText("Weight: 1 lb.");
                description.setText("This small container holds flint, fire steel," +
                        " and tinder (usually dry cloth soaked in light oil) used to" +
                        " kindle a fire. Using it to light a torch—or anything else" +
                        " with abundant, exposed fuel—takes an action. Lighting" +
                        " any other fire takes 1 minute.");
                break;

            case 56:
                header.setText("Torch");
                cost.setText("Cost: 1 cp");
                weight.setText("Weight: 1 lb.");
                description.setText("A torch burns for 1 hour, providing bright light" +
                        " in a 20-foot radius and dim light for an additional 20" +
                        " feet. If you make a melee attack with a burning torch" +
                        " and hit, it deals 1 fire damage.");
                break;

            case 57:
                header.setText("Vial");
                cost.setText("Cost: 1 gp");
                weight.setText("Weight: -");
                description.setText("Holds a small amount of liquid.");
                break;

            case 58:
                header.setText("Waterskin");
                cost.setText("Cost: 2 sp");
                weight.setText("Weight: 5 lb. (full)");
                description.setText("Holds about 4 pints of liquid.");
                break;

            case 59:
                header.setText("Whetstone");
                cost.setText("Cost: 1 cp");
                weight.setText("Weight: 1 lb.");
                description.setText("Used to keep tools and weapons sharp and in good shape.");
                break;

            default:
                header.setText("Error occurred, try again");
                cost.setText("");
                weight.setText("");
                description.setText("");
                break;
        }

        return view;
    }
}