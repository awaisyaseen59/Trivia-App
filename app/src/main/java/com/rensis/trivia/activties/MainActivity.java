package com.rensis.trivia.activties;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rensis.trivia.Adapters.QuestionsAdapter;
import com.rensis.trivia.Model.Answer;
import com.rensis.trivia.Model.SolvedQuestions;
import com.rensis.trivia.R;
import com.rensis.trivia.callBacks.AnswerListCallBack;
import com.rensis.trivia.network.Network;
import com.rensis.trivia.network.NetworkCall;
import com.rensis.trivia.network.OnNetworkResponse;
import com.rensis.trivia.network.serializers.BaseResponse;
import com.rensis.trivia.network.serializers.response.Question;
import com.rensis.trivia.network.serializers.response.QuestionsResponse;
import com.rensis.trivia.utils.RequestCodes;
import com.rensis.trivia.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import retrofit2.Call;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements OnNetworkResponse, AnswerListCallBack, View.OnClickListener {
    private TextView answersCount;
    private TextView countDownTV;
    private Button submit;
    private RecyclerView questionsRv;
    private QuestionsAdapter questionsAdapter;
    private List<Question> questionList = new ArrayList<>();
    private RealmList<Answer> answerList = new RealmList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getQuestions();
        initViews();
        setClickListners();
    }

    private void initViews() {
        questionsRv = findViewById(R.id.questionsRV);
        answersCount = findViewById(R.id.text_view_question_count);
        countDownTV = findViewById(R.id.text_view_countdown);
        submit = findViewById(R.id.submit);
    }

    private void setClickListners() {
        submit.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onSelect(Answer answer) {
        for (Answer currentAnwer : answerList) {
            if (currentAnwer.getPosition() == answer.getPosition()) {
                answerList.remove(currentAnwer);
                break;
            }
        }
        answerList.add(answer);
        answersCount.setText(answerList.size() + "/" + questionList.size());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit:
                checkAnswer();
                break;
            default:
                break;
        }
    }

    private void setQuestionsAdapter(List<Question> questions) {
        if (!questionList.isEmpty())
            questionList.clear();
        questionList.addAll(questions);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        questionsAdapter = new QuestionsAdapter(this, questions, this);
        questionsRv.setLayoutManager(linearLayoutManager);
        questionsRv.setAdapter(questionsAdapter);
    }

    private void getQuestions() {
        NetworkCall.make()
                .setCallback(this)
                .setTag(RequestCodes.API.GET_QUESTIONS)
                .autoLoadigCancel(Utils.getLoading(this))
                .enque(Network.apis().getQuestions(10))
                .execute();
    }

    @Override
    public void onSuccess(Call call, Response response, Object tag) {
        QuestionsResponse res = (QuestionsResponse) response.body();
        if (res != null) {
            answersCount.setText("0/" + res.getQuestions().size());
            setQuestionsAdapter(res.getQuestions());
            setCountDown();
        }
    }

    @Override
    public void onFailure(Call call, BaseResponse response, Object tag) {
        Toast.makeText(this, response.getMessage(), Toast.LENGTH_LONG).show();
    }

    private void setCountDown() {
        new CountDownTimer(300000, 1000) {
            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                countDownTV.setText(String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            public void onFinish() {
                Toast.makeText(getApplicationContext(), "Time Finish", Toast.LENGTH_LONG).show();
                checkAnswer();
            }

        }.start();
    }

    private void checkAnswer() {
        int scores = 0;
        int correctAnswers = 0;
        for (Answer answer : answerList) {
            if (questionList.get(answer.getPosition()).getCorrectAnswer().equals(answer.getAnswer())) {
                if (questionList.get(answer.getPosition()).getDifficulty().equalsIgnoreCase("easy")) {
                    scores = scores + 1;
                    correctAnswers++;
                } else if (questionList.get(answer.getPosition()).getDifficulty().equalsIgnoreCase("medium")) {
                    scores = scores + 2;
                    correctAnswers++;
                } else if (questionList.get(answer.getPosition()).getDifficulty().equalsIgnoreCase("hard")) {
                    scores = scores + 3;
                    correctAnswers++;
                }
            }
        }
        SolvedQuestions solvedQuestions = SolvedQuestions.init();  //saving result in local storage(REALM)
        solvedQuestions.setAnswers(answerList);
        solvedQuestions.save();
        startActivity(new Intent(this, ScoreActivity.class).putExtra("score", String.valueOf(scores))
                .putExtra("correctAnswers", String.valueOf(correctAnswers))
                .putExtra("incorrectAnswers", String.valueOf(answerList.size() - correctAnswers)));
        finish();
    }

}
