package com.example.multiplicationchallenge;

public class HighScore {
    private int _id;
    private String name;
    private int score;

    public HighScore(int _id, String name, int score) {
        this._id = _id;
        this.name = name;
        this.score = score;
    }

    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}