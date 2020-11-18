package com.rensis.trivia.Adapters.ViewHolders;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rensis.trivia.Model.Answer;
import com.rensis.trivia.R;
import com.rensis.trivia.callBacks.AnswerListCallBack;
import com.rensis.trivia.network.serializers.response.Question;


public class QuestionsViewHolder extends RecyclerView.ViewHolder {

    private TextView questionTV, answer;

    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;


    public View parent;

    public QuestionsViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;
        questionTV = itemView.findViewById(R.id.question);
        answer = itemView.findViewById(R.id.answer);
        radioGroup = itemView.findViewById(R.id.radio_group);
        radioButton1 = itemView.findViewById(R.id.radio_button1);
        radioButton2 = itemView.findViewById(R.id.radio_button2);
        radioButton3 = itemView.findViewById(R.id.radio_button3);
        radioButton4 = itemView.findViewById(R.id.radio_button4);
    }

    public void setData(Question question, RecyclerView.ViewHolder viewHolder, int position, AnswerListCallBack callBack) {
        if (question.getType().equalsIgnoreCase("multiple")) {
            questionTV.setText((position + 1) + ". " + question.getQuestion());
            radioButton1.setVisibility(View.VISIBLE);
            radioButton2.setVisibility(View.VISIBLE);
            radioButton3.setVisibility(View.VISIBLE);
            radioButton4.setVisibility(View.VISIBLE);
            radioButton3.setText(question.getCorrectAnswer());
            radioButton1.setText(question.getIncorrectAnswers().get(0));
            radioButton2.setText(question.getIncorrectAnswers().get(1));
            radioButton4.setText(question.getIncorrectAnswers().get(2));
        } else {
            radioButton1.setVisibility(View.VISIBLE);
            radioButton2.setVisibility(View.VISIBLE);
            radioButton1.setText("True");
            radioButton2.setText("False");
            questionTV.setText((position + 1) + ". " + question.getQuestion());
        }

        if (question.getSelectedId() != null)
            radioGroup.check(question.getSelectedId());
        radioGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            question.setSelectedId(checkedId);
            RadioButton radio_Button = itemView.findViewById(checkedId);
            this.answer.setText(radio_Button.getText().toString());
            String selectedAnswer = radio_Button.getText().toString();
            boolean isCorrect = selectedAnswer.equalsIgnoreCase(question.getCorrectAnswer()) ? true : false;
            Answer answer = new Answer(question.getQuestion(), selectedAnswer, question.getCorrectAnswer(), position, isCorrect);
            callBack.onSelect(answer);
        });
    }
}
