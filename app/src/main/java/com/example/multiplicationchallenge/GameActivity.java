package com.example.multiplicationchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Button btnSubmit;
    TextView tvPoints, tvQn, tvMarking;
    EditText etAns;
    ArrayList<Question> al;
    ArrayList<Question> incorrect;
    ArrayList<Integer> selected;
    static Question question;
    static Integer points;
    static String bonus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        tvPoints = (TextView) findViewById(R.id.tvPoints);
        tvMarking = (TextView) findViewById(R.id.tvMarking);
        tvQn = (TextView) findViewById(R.id.tvQuestion);
        etAns = (EditText) findViewById(R.id.etAnswer);

        points = 0;
        bonus = "no";

        tvPoints.setText("" + points);

        al = new ArrayList<Question>();
        incorrect = new ArrayList<Question>();

        Intent intent = getIntent();

        selected = intent.getIntegerArrayListExtra("selected");

        for (int i = 0; i < selected.size(); i++){
            for (int a = 1; a < 13; a++){
                if (selected.get(i) == a){
                    for (int b = 1; b < 13; b++){
                        al.add(new Question("" + a + " x " + b, (a*b) ));
                    }
                }
            }
        }

        question = randomize(al);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etAns.getText().toString().trim().equalsIgnoreCase("")){
                    etAns.setError("Answer cannot be blank");
                } else {
                    if (bonus.equals("no")){
                        if (Integer.parseInt(etAns.getText().toString()) == question.getAnswer()){
                            tvMarking.setTextColor(Color.parseColor("#008000"));
                            tvMarking.setText("Correct!");

                            points += 10;
                            tvPoints.setText("" + points);

                            al.remove(question);

                            if (al.isEmpty() == true && incorrect.isEmpty() == false){
                                Intent i = new Intent(GameActivity.this, BonusActivity.class);
                                i.putExtra("score", points);
                                startActivityForResult(i, 1);

                            } else {
                                question = randomize(al);
                            }

                        } else {
                            tvMarking.setTextColor(Color.parseColor("#FF0000"));
                            tvMarking.setText("Wrong! Better Luck Next Time");

                            al.remove(question);

                            incorrect.add(question);

                            if (al.isEmpty() == true && incorrect.isEmpty() == false){
                                Intent i = new Intent(GameActivity.this, BonusActivity.class);
                                i.putExtra("score", points);
                                startActivityForResult(i, 1);

                            } else {
                                question = randomize(al);
                            }

                        }
                    } else {
                        if (Integer.parseInt(etAns.getText().toString()) == question.getAnswer()){
                            tvMarking.setTextColor(Color.parseColor("#008000"));
                            tvMarking.setText("Correct!");

                            points += 5;
                            tvPoints.setText("" + points);

                            incorrect.remove(question);

                            if (incorrect.isEmpty() == true){
                                Intent i = new Intent(GameActivity.this, CompletedActivity.class);
                                i.putExtra("score", points);
                                startActivity(i);

                            } else {
                                question = randomize(incorrect);
                            }

                        } else {
                            tvMarking.setTextColor(Color.parseColor("#FF0000"));
                            tvMarking.setText("Wrong! Better Luck Next Time");

                            incorrect.remove(question);

                            if (incorrect.isEmpty() == true){
                                Intent i = new Intent(GameActivity.this, CompletedActivity.class);
                                i.putExtra("score", points);
                                startActivity(i);

                            } else {
                                question = randomize(incorrect);
                            }
                        }
                    }

                }
            }
        });

        tvMarking.setText("");


    }

    private Question randomize(ArrayList<Question> al){
        Random random = new Random();
        Question question = al.get(random.nextInt(al.size()));
        tvQn.setText(question.getQuestion() + " ?");
        return question;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if (data != null) {

                if(requestCode == 1){
                    bonus = "yes";
                    question = randomize(incorrect);
                }

            }
        }
    }
}