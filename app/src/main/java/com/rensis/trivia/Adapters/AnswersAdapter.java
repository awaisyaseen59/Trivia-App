package com.rensis.trivia.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rensis.trivia.Adapters.ViewHolders.AnswersViewHolder;
import com.rensis.trivia.Model.Answer;
import com.rensis.trivia.R;

import java.util.List;

public class AnswersAdapter extends RecyclerView.Adapter<AnswersViewHolder> {

    private Context context;
    private List<Answer> answersList;

    public AnswersAdapter(Context context, List<Answer> answersList) {
        this.context = context;
        this.answersList = answersList;
    }

    @NonNull
    @Override
    public AnswersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.answers_list_item, parent, false);
        return new AnswersViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull AnswersViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.setData(answersList.get(position));
    }

    @Override
    public int getItemCount() {
        return answersList.size();
    }


}