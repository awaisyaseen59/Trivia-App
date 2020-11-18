package com.rensis.trivia.activties;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.rensis.trivia.Adapters.AnswersAdapter;
import com.rensis.trivia.Adapters.QuestionsAdapter;
import com.rensis.trivia.Model.Answer;
import com.rensis.trivia.Model.SolvedQuestions;
import com.rensis.trivia.R;
import com.rensis.trivia.network.serializers.response.Question;

import java.util.List;

public class ScoreActivity extends AppCompatActivity {
    private TextView score, correctAnswers, wrongAnswers;
    private RecyclerView answersRV;
    private List<Answer> answerList = null;
    private AnswersAdapter answersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        initView();
        setAnswersAdapter(SolvedQuestions.init().getAnswers());
    }

    private void initView() {
        Intent intent = getIntent();
        score = findViewById(R.id.score);
        correctAnswers = findViewById(R.id.correctAnswers);
        wrongAnswers = findViewById(R.id.wrongAnswers);
        answersRV = findViewById(R.id.answersRV);
        score.setText(intent.getExtras().getString("score"));
        correctAnswers.setText(intent.getExtras().getString("correctAnswers"));
        wrongAnswers.setText(intent.getExtras().getString("incorrectAnswers"));
    }

    private void setAnswersAdapter(List<Answer> questions) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        answersAdapter = new AnswersAdapter(this, questions);
        answersRV.setLayoutManager(linearLayoutManager);
        answersRV.setAdapter(answersAdapter);
    }
}