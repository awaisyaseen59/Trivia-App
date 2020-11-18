package com.rensis.trivia.network;

import com.google.gson.stream.MalformedJsonException;
import com.rensis.trivia.R;
import com.rensis.trivia.app.BaseClass;
import com.rensis.trivia.app.MainApplication;
import com.rensis.trivia.network.serializers.BaseResponse;
import com.rensis.trivia.utils.Configurations;
import com.rensis.trivia.utils.Loading;
import com.rensis.trivia.utils.Utils;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NetworkCall extends BaseClass {


    private Object taggedObject;
    private OnNetworkResponse callback;
    private Call request;
    private Loading loading;

    private NetworkCall() {
    }

    public NetworkCall setCallback(OnNetworkResponse callback) {
        this.callback = callback;
        return this;
    }

    public NetworkCall enque(Call call) {
        this.request = call;
        return this;
    }

    public NetworkCall setTag(Object tag) {
        this.taggedObject = tag;
        return this;
    }
    public NetworkCall autoLoadigCancel(Loading loading) {
        this.loading = loading;
        return this;
    }

    public NetworkCall execute() {
        request.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                cancelLoading();
                if (BaseResponse.isSuccess(response)) {
                    callback.onSuccess(call, response, taggedObject);
                } else if (BaseResponse.isUnAuthorized(response)) {
                    MainApplication.resetApplication();
                    //Notify.alertDialog(MainApplication.getAppContext().getCurrentActivity(), Network.parseErrorResponse(response).getMessage());
                }  else if (response.body() == null || !BaseResponse.isSuccess(response)) {
                    try {
                        callback.onFailure(call, Network.parseErrorResponse(response), taggedObject);

                    } catch (Exception e) {
                        callback.onFailure(call, new BaseResponse(Configurations.isProduction() ? string(R.string.exceptionInErrorResponse) : string(R.string.invalid_data)), taggedObject);
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                cancelLoading();
                BaseResponse response;
                if (t != null) {
                    if (Utils.isCause(SocketTimeoutException.class, t)) {
                        response = new BaseResponse(string(R.string.timeout));
                    } else if (Utils.isCause(ConnectException.class, t)) {
                        response = new BaseResponse(string(R.string.connectException));
                    } else if (Utils.isCause(MalformedJsonException.class, t)) {
                        response = new BaseResponse(string(R.string.invalid_data));
                    } else if (t instanceof SSLHandshakeException || t instanceof SSLException) {
                        response = new BaseResponse(string(R.string.ssl));
                    } else if (t instanceof IOException) {
                        response = new BaseResponse(string(R.string.no_internet));
                    } else {
                        response = new BaseResponse(Configurations.isDevelopment() ? t.getMessage() : string(R.string.text_somethingwentwrong));
                        //  response = new BaseResponse(t.getMessage());
                    }
                    callback.onFailure(call, response, taggedObject);
                } else

                    {
                    response = new BaseResponse(string(R.string.text_somethingwentwrong));
                    callback.onFailure(call, response, taggedObject);  }
            }
        });
        return this;
    }

    public void cancelLoading() {
        if (loading != null && loading.isVisible())
            loading.cancel();
    }



    public static synchronized NetworkCall make() {
        return new NetworkCall();
    }
}
