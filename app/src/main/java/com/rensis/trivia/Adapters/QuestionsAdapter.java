package com.rensis.trivia.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rensis.trivia.Adapters.ViewHolders.QuestionsViewHolder;
import com.rensis.trivia.R;
import com.rensis.trivia.callBacks.AnswerListCallBack;
import com.rensis.trivia.network.serializers.response.Question;

import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsViewHolder> {

    private Context context;
    private List<Question> questionList;
    private AnswerListCallBack callBack;

    public QuestionsAdapter(Context context, List<Question> questionList, AnswerListCallBack callBack) {
        this.context = context;
        this.questionList = questionList;
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public QuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.questions_list_item, parent, false);
        return new QuestionsViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.setData(questionList.get(position),holder,position,callBack);

    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }


}