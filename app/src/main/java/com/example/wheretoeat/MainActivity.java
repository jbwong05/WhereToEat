package com.example.wheretoeat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView resultText;
    private SparseArray<String> selectedPlaces;
    private SparseArray<String> map;
    private CheckBox[] checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.resultText);
        resultText.setText("");

        selectedPlaces = new SparseArray<>();
        map = new SparseArray<>();
        checkBoxes = new CheckBox[10];

        setupSparseArray();
        setupCheckboxArray();
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

    private void setupCheckboxArray() {
        checkBoxes[0] = findViewById(R.id.bistro);
        checkBoxes[1] = findViewById(R.id.sixtyFour);
        checkBoxes[2] = findViewById(R.id.pines);
        checkBoxes[3] = findViewById(R.id.ovt);
        checkBoxes[4] = findViewById(R.id.goodies);
        checkBoxes[5] = findViewById(R.id.ventanas);
        checkBoxes[6] = findViewById(R.id.cv);
        checkBoxes[7] = findViewById(R.id.foodworx);
        checkBoxes[8] = findViewById(R.id.pc);
        checkBoxes[9] = findViewById(R.id.sixtyFourNorth);
    }

    public void onCheckboxClicked(View view) {
        if(((CheckBox) view).isChecked()){
            selectedPlaces.put(view.getId(), map.get(view.getId()));
        } else {
            selectedPlaces.remove(view.getId());
        }
    }

    public void onSelectAll(View view) {
        boolean newStatus = (((CheckBox) view).isChecked());

        for(CheckBox checkBox : checkBoxes) {
            checkBox.setChecked(newStatus);

            if(newStatus) {
                selectedPlaces.put(checkBox.getId(), map.get(checkBox.getId()));
            } else {
                selectedPlaces.remove(checkBox.getId());
            }
        }
    }

    public void onButtonPress(View view) {
        if(selectedPlaces.size() == 0) {
            resultText.setText(getResources().getString(R.string.no_places_selected));
        } else {
            int randomIndex = (int) (Math.random() * selectedPlaces.size());
            resultText.setText(selectedPlaces.get(selectedPlaces.keyAt(randomIndex)));

            // Scrolls to result if necessary
            resultText.requestFocus();
        }
    }

}
