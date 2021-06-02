package com.example.multiplicationchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnSettings, btnHS;
    ArrayList<Integer> selected = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnSettings = (Button) findViewById(R.id.btnSettings);
        btnHS = (Button) findViewById(R.id.btnHS);

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                i.putExtra("set", selected);
                startActivityForResult(i, 1);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, GameActivity.class);
                i.putExtra("selected", selected);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if (data != null) {
                selected = data.getIntegerArrayListExtra("selected");

                if(requestCode == 1){
                    Toast.makeText(MainActivity.this, "Multiples Applied",
                            Toast.LENGTH_SHORT).show();
                }

            }
        }
    }
}