package com.rensis.trivia.network;

import com.rensis.trivia.network.serializers.BaseResponse;
import com.rensis.trivia.network.serializers.response.QuestionsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {

    @GET("api.php")
    Call<QuestionsResponse> getQuestions(@Query("amount") Integer noOfQuestions);

}



