package com.example.multiplicationchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BonusActivity extends AppCompatActivity {

    TextView tvScore;
    Button btnYes, btnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus);

        btnYes = (Button) findViewById(R.id.btnYes);
        btnNo = (Button) findViewById(R.id.btnNo);

        Intent intent = getIntent();

        int points = intent.getIntExtra("score", 0);

        tvScore.setText("" + points);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                setResult(RESULT_OK, i);
                finish();
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BonusActivity.this, CompletedActivity.class);
                i.putExtra("score", points);
                startActivity(i);
            }
        });
    }
}