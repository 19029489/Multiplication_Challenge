package com.example.multiplicationchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class HighscoreActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<HighScore> al;
    ScoresArrayAdapter aa;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        lv = findViewById(R.id.lv);
        btnBack = findViewById(R.id.btnBackToMain);

        lv.setBackgroundColor(Color.WHITE);

        al = new ArrayList<HighScore>();

        DBHelper db = new DBHelper(HighscoreActivity.this);
        db.close();

        al = db.getAllScores();

        aa = new ScoresArrayAdapter(HighscoreActivity.this, R.layout.row, al);
        lv.setAdapter(aa);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HighscoreActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

}