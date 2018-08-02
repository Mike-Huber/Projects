package just_4_guys.groupproj;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ArmorFragment extends Fragment {
    RelativeLayout relativeLayout;
    View view;
    Bundle bundle;
    int position;
    TextView header, cost, weight, ac;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.armor_relativelayout);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bundle = getArguments();
        position = bundle.getInt("Position");

        view = inflater.inflate(R.layout.armor_relativelayout, container, false);

        header = (TextView) view.findViewById(R.id.armor_header);
        cost = (TextView) view.findViewById(R.id.armor_cost);
        weight = (TextView) view.findViewById(R.id.armor_weight);
        ac = (TextView) view.findViewById(R.id.armor_ac);

        switch (position) {
            case 0:
                header.setText("Padded Armor");
                cost.setText("Cost: 5 gp");
                weight.setText("Weight: 8 lb.");
                ac.setText("Armor Class (AC): 11 + Dex Modifier");
                break;
            case 1:
                header.setText("Leather Armor");
                cost.setText("Cost: 10 gp");
                weight.setText("Weight: 10 lb.");
                ac.setText("Armor Class (AC): 11 + Dex Modifier");
                break;
            case 2:
                header.setText("Studded Leather");
                cost.setText("Cost: 45 gp");
                weight.setText("Weight: 13 lb.");
                ac.setText("Armor Class (AC): 12 + Dex Modifier");
                break;
            case 3:
                header.setText("Hide Armor");
                cost.setText("Cost: 10 gp");
                weight.setText("Weight: 12 lb.");
                ac.setText("Armor Class (AC): 12 + Dex Modifier");
                break;
            case 4:
                header.setText("Chain Shirt");
                cost.setText("Cost: 50 gp");
                weight.setText("Weight: 20 lb.");
                ac.setText("Armor Class (AC): 13 + Dex Modifier");
                break;
            case 5:
                header.setText("Scale Mail");
                cost.setText("Cost: 50 gp");
                weight.setText("Weight: 45 lb.");
                ac.setText("Armor Class (AC): 14 + Dex Modifier");
                break;
            case 6:
                header.setText("Breastplate");
                cost.setText("Cost: 400 gp");
                weight.setText("Weight: 20 lb.");
                ac.setText("Armor Class (AC): 14 + Dex Modifier");
                break;
            case 7:
                header.setText("Half Plate");
                cost.setText("Cost: 750 gp");
                weight.setText("Weight: 4 lb.");
                ac.setText("Armor Class (AC): 15 + Dex Modifier");
                break;
            case 8:
                header.setText("Ring Mail");
                cost.setText("Cost: 30 gp");
                weight.setText("Weight: 40 lb.");
                ac.setText("Armor Class (AC): 14");
                break;
            case 9:
                header.setText("Chain Mail");
                cost.setText("Cost: 75 gp");
                weight.setText("Weight: 55 lb.");
                ac.setText("Armor Class (AC): 16");
                break;
            case 10:
                header.setText("Splint");
                cost.setText("Cost: 200 gp");
                weight.setText("Weight: 60 lb.");
                ac.setText("Armor Class (AC): 17");
                break;
            case 11:
                header.setText("Plate");
                cost.setText("Cost: 1,500 gp");
                weight.setText("Weight: 65 lb.");
                ac.setText("Armor Class (AC): 18");
                break;
            case 12:
                header.setText("Shield");
                cost.setText("Cost: 10 gp");
                weight.setText("Weight: 6 lb.");
                ac.setText("Armor Class (AC): +2");
                break;
            default:
                header.setText("Error occurred, try again");
                cost.setText("");
                weight.setText("");
                ac.setText("");
                break;
        }

        return view;
    }
}