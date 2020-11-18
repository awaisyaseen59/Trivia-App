package com.rensis.trivia.Adapters.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rensis.trivia.Model.Answer;
import com.rensis.trivia.R;


public class AnswersViewHolder extends RecyclerView.ViewHolder {

    private TextView question, yourAnswer, correctAnswer;
    private View parent;

    public AnswersViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;
        question = itemView.findViewById(R.id.question);
        yourAnswer = itemView.findViewById(R.id.yourAnswer);
        correctAnswer = itemView.findViewById(R.id.correctAnswer);
    }

    public void setData(Answer answer) {
        question.setText(answer.getQuestion());
        yourAnswer.setText("Your Answer: " + answer.getAnswer());
        correctAnswer.setVisibility(View.GONE);
        yourAnswer.setTextColor(parent.getResources().getColor(R.color.green));
        if (answer.isCorrect()) {
            yourAnswer.setTextColor(parent.getResources().getColor(R.color.green));
        } else {
            yourAnswer.setTextColor(parent.getResources().getColor(R.color.red));
            correctAnswer.setVisibility(View.VISIBLE);
            correctAnswer.setText("Correct Answer: " + answer.getCorrectAnswer());
        }
    }
}
