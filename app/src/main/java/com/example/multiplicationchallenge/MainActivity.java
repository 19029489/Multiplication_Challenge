package com.example.multiplicationchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnSettings, btnHS;
    ArrayList<Integer> selected = new ArrayList<Integer>();
    String multiples = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("Multiples", Context.MODE_PRIVATE);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnSettings = (Button) findViewById(R.id.btnSettings);
        btnHS = (Button) findViewById(R.id.btnHS);

        selected.add(1);

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                i.putExtra("set", selected);
                startActivityForResult(i, 1);
            }
        });

        String storedPreference = preferences.getString("Multiples", "");
        Log.i("storedPreference", storedPreference);
        if (!storedPreference.equals("")){

            selected.clear();

            String[] multiple = storedPreference.split(" ");

            for (int i = 0; i < multiple.length; i++){
                Log.i("current selected", "" + selected);
                int number = Integer.parseInt(multiple[i]);
                selected.add(number);
            }

            Log.i("current selected", "" + selected);
        }

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, GameActivity.class);
                i.putExtra("selected", selected);
                startActivity(i);
            }
        });

        btnHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, HighscoreActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if (data != null) {

                selected.clear();
                selected = data.getIntegerArrayListExtra("selected");
                Log.i("new Selected", "" + selected);

                if(requestCode == 1){
                    SharedPreferences preferences = getSharedPreferences("Multiples", Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = preferences.edit();

                    multiples += selected.get(0);

                    for (int i = 1; i < selected.size(); i ++) {
                        multiples += " " + selected.get(i);
                    }

                    editor.putString("Multiples", multiples);
                    editor.commit();

                }

            }
        }
    }
}