package com.rensis.trivia.network.serializers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.rensis.trivia.network.ResponseCode;

import java.io.Serializable;
import java.util.Set;

import retrofit2.Response;

public class BaseResponse implements Serializable {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("response_code")
    @Expose
    private Integer code;

    public BaseResponse() {
    }

    public BaseResponse(String message) {
        setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static boolean isSuccess(Response response) {
        try {
            return ResponseCode.isBetweenSuccessRange(((BaseResponse) response.body()).getCode());
        } catch (Exception e) {
            return false;
        }
    }


    public static boolean isUnAuthorized(Response response) {
        try {
            return response.code() == ResponseCode.FORBIDDEN
                    || response.code() == ResponseCode.UN_AUTHORIZED;
        } catch (Exception e) {
            return false;
        }
    }



}