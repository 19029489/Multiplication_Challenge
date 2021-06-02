package com.example.multiplicationchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CompletedActivity extends AppCompatActivity {

    EditText etName;
    TextView tvScore;
    Button btnSubmit, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed);

        etName = (EditText) findViewById(R.id.etName);
        tvScore = (TextView) findViewById(R.id.tvScore2);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnSubmit = (Button) findViewById(R.id.btnSubmitScore);

        Intent i = getIntent();
        int points = i.getIntExtra("score", 0);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().trim().equalsIgnoreCase("")) {
                    etName.setError("Name cannot be blank to submit score");
                } else {
                    DBHelper db = new DBHelper(CompletedActivity.this);
                    db.insertScore(etName.getText().toString(), points);
                    db.close();

                    Intent i = new Intent(CompletedActivity.this, HighscoreActivity.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CompletedActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}