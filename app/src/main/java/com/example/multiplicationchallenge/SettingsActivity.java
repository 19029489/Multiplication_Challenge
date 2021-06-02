package com.example.multiplicationchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

        for (int a = 0; a < checked.size(); a++){
            for (int b = 1; b < 13; b++){
                if (checked.get(a) == b){
                    if (b == 1){
                        cb1.setChecked(true);
                    } else {
                        cb1.setChecked(false);
                    }
                    if (b == 2){
                        cb2.setChecked(true);
                    } else {
                        cb2.setChecked(false);
                    }
                    if (b == 3){
                        cb3.setChecked(true);
                    } else {
                        cb3.setChecked(false);
                    }
                    if (b == 4){
                        cb4.setChecked(true);
                    } else {
                        cb4.setChecked(false);
                    }
                    if (b == 5){
                        cb5.setChecked(true);
                    } else {
                        cb5.setChecked(false);
                    }
                    if (b == 6){
                        cb6.setChecked(true);
                    } else {
                        cb6.setChecked(false);
                    }
                    if (b == 7){
                        cb7.setChecked(true);
                    } else {
                        cb7.setChecked(false);
                    }
                    if (b == 8){
                        cb8.setChecked(true);
                    } else {
                        cb8.setChecked(false);
                    }if (b == 9){
                        cb9.setChecked(true);
                    } else {
                        cb9.setChecked(false);
                    }if (b == 10){
                        cb10.setChecked(true);
                    } else {
                        cb10.setChecked(false);
                    }
                    if (b == 11){
                        cb11.setChecked(true);
                    } else {
                        cb11.setChecked(false);
                    }
                    if (b == 12){
                        cb12.setChecked(true);
                    } else {
                        cb12.setChecked(false);
                    }
                }
            }
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

//                if (cb1.isChecked()){
//                    checked.add(1);
//                } else if (cb2.isChecked()){
//                    checked.add(2);
//                    cb2.setChecked(true);
//                } else if (cb3.isChecked()) {
//                    checked.add(3);
//                } else if (cb4.isChecked()) {
//                    checked.add(4);
//                } else if (cb5.isChecked()) {
//                    checked.add(5);
//                } else if (cb6.isChecked()) {
//                    checked.add(6);
//                } else if (cb7.isChecked()) {
//                    checked.add(7);
//                } else if (cb8.isChecked()) {
//                    checked.add(8);
//                } else if (cb9.isChecked()) {
//                    checked.add(9);
//                } else if (cb10.isChecked()) {
//                    checked.add(10);
//                } else if (cb11.isChecked()) {
//                    checked.add(11);
//                } else if (cb12.isChecked()) {
//                    checked.add(12);
//                }

                if(checked.size() == 0){
                    Toast.makeText(SettingsActivity.this, "Please select at least one multiple.", Toast.LENGTH_SHORT).show();
                } else {
                    Log.i("selected", "" + checked);
                    Intent i = new Intent(SettingsActivity.this, MainActivity.class);
                    i.putExtra("selected", checked);
                    startActivity(i);
                }

            }
        });
    }
}