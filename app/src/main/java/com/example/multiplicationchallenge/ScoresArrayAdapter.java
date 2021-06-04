package com.example.multiplicationchallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ScoresArrayAdapter extends ArrayAdapter<HighScore> {
    Context context;
    ArrayList<HighScore> scores;
    int resource;
    TextView tvNames, tvScores;

    public ScoresArrayAdapter(Context context, int resource, ArrayList<HighScore> scores) {
        super(context, resource, scores);
        this.context = context;
        this.scores = scores;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(resource, parent, false);

        tvNames = (TextView) rowView.findViewById(R.id.tvNames);
        tvScores = (TextView) rowView.findViewById(R.id.tvScores);

        HighScore score = scores.get(position);

        tvNames.setText("" + score.getName());
        tvScores.setText("" + score.getScore());

        return rowView;
    }
}
