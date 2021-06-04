package com.example.multiplicationchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {

    Button btnApply;
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnApply = (Button) findViewById(R.id.btnApply);
        cb1 = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        cb5 = (CheckBox) findViewById(R.id.checkBox5);
        cb6 = (CheckBox) findViewById(R.id.checkBox6);
        cb7 = (CheckBox) findViewById(R.id.checkBox7);
        cb8 = (CheckBox) findViewById(R.id.checkBox8);
        cb9 = (CheckBox) findViewById(R.id.checkBox9);
        cb10 = (CheckBox) findViewById(R.id.checkBox10);
        cb11 = (CheckBox) findViewById(R.id.checkBox11);
        cb12 = (CheckBox) findViewById(R.id.checkBox12);

        ArrayList<Integer> checked = new ArrayList<Integer>();
        CheckBox checkBoxes[] = {cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12};

        Intent i = getIntent();

        ArrayList<Integer> setChecked = i.getIntegerArrayListExtra("set");

        for (int e = 0; e < checkBoxes.length; e++){
            checkBoxes[e].setChecked(false);
        }

        if (setChecked.size() != 0){
            for (int a = 0; a < setChecked.size(); a++){
                for (int b = 1; b < 13; b++){
                    if (setChecked.get(a) == b){
                        checkBoxes[b-1].setChecked(true);
                    }
                }
            }
        } else {
            cb1.setChecked(true);
        }

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int o = 0; o < checkBoxes.length; o++){
                    if (checkBoxes[o].isChecked()){
                        checked.add(o+1);
                        checkBoxes[o].setChecked(true);
                    } else {
                        checkBoxes[o].setChecked(false);
                    }
                }

                if(checked.size() == 0){
                    Toast.makeText(SettingsActivity.this, "Please select at least one multiple.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SettingsActivity.this, "Multiples Applied",
                            Toast.LENGTH_LONG).show();
                    Intent i = new Intent();
                    i.putExtra("selected", checked);
                    setResult(RESULT_OK, i);
                    finish();
                }

            }
        });
    }
}