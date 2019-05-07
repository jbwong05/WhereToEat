package com.example.wheretoeat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView resultText;
    private ArrayList<String> selectedPlaces;
    private SparseArray<String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.resultText);
        resultText.setText("");

        selectedPlaces = new ArrayList<>();
        map = new SparseArray<>();

        setupSparseArray();
    }

    private void setupSparseArray() {
        map.append(R.id.bistro, getResources().getString(R.string.bistro));
        map.append(R.id.sixtyFour, getResources().getString(R.string.sixty_four));
        map.append(R.id.pines, getResources().getString(R.string.pines));
        map.append(R.id.ovt, getResources().getString(R.string.ovt));
        map.append(R.id.goodies, getResources().getString(R.string.goodies));
        map.append(R.id.ventanas, getResources().getString(R.string.cafe_v));
        map.append(R.id.cv, getResources().getString(R.string.cv));
        map.append(R.id.foodworx, getResources().getString(R.string.foodworx));
        map.append(R.id.pc, getResources().getString(R.string.pc));
        map.append(R.id.sixtyFourNorth, getResources().getString(R.string.sixty_four_north));
    }

    public void onCheckboxClicked(View view) {
        if(((CheckBox) view).isChecked()){
            selectedPlaces.add(map.get(view.getId()));
        } else {
            selectedPlaces.remove(map.get(view.getId()));
        }
    }

    public void onButtonPress(View view) {
        if(selectedPlaces.size() == 0) {
            resultText.setText(getResources().getString(R.string.no_places_selected));
        } else {
            int randomIndex = (int) (Math.random() * selectedPlaces.size());
            resultText.setText(selectedPlaces.get(randomIndex));
        }
    }

}
