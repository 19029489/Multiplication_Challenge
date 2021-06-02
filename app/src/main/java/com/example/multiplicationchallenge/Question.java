package com.example.multiplicationchallenge;

public class Question {
    private String question;
    private Integer answer;

    public Question(String question, Integer answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public Integer getAnswer() {
        return answer;
    }

}