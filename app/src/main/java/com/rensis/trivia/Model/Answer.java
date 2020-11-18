package com.rensis.trivia.Model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Answer extends RealmObject {
    String question;
    String answer;
    String correctAnswer;
    int position;
    boolean isCorrect;

    public Answer() {
    }

    public Answer(String question, String answer, String correctAnswer, int position, boolean isCorrect) {
        this.answer = answer;
        this.position = position;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.isCorrect = isCorrect;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
