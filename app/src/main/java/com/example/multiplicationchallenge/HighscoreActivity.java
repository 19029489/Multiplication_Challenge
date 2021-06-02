package com.example.multiplicationchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HighscoreActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<HighScore> al;
    ScoresArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        lv = findViewById(R.id.lv);

        al = new ArrayList<HighScore>();

        DBHelper db = new DBHelper(HighscoreActivity.this);
        al.addAll(db.getAllScores());
        db.close();

        aa = new ScoresArrayAdapter(HighscoreActivity.this, R.layout.row, al);
        lv.setAdapter(aa);

    }

}