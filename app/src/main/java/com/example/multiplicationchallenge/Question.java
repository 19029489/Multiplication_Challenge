package com.example.multiplicationchallenge;

public class Question {
    private String question;
    private String answer;
    private int multiple;

    public Question(String question, String answer, int multiple) {
        this.question = question;
        this.answer = answer;
        this.multiple = multiple;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getMultiple() {
        return multiple;
    }
}