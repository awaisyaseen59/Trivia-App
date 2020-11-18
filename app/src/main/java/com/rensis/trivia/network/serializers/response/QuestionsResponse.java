package com.rensis.trivia.network.serializers.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.rensis.trivia.network.serializers.BaseResponse;

import java.util.List;

public class QuestionsResponse extends BaseResponse {
    @SerializedName("results")
    @Expose
    private List<Question> questions = null;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
