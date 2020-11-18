package com.rensis.trivia.network;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rensis.trivia.R;
import com.rensis.trivia.app.AppSession;
import com.rensis.trivia.app.MainApplication;
import com.rensis.trivia.network.serializers.BaseResponse;
import com.rensis.trivia.utils.Configurations;
import com.rensis.trivia.utils.Constants;
import com.rensis.trivia.utils.Logger;
import com.rensis.trivia.utils.Utils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private Retrofit networkClient = null;
    private static Network object;
    private ApiServices services;

    private Network() {
        Gson gson = new GsonBuilder().create();
        Context context = MainApplication.getAppContext();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.retryOnConnectionFailure(true);
        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        httpClient.writeTimeout(30, TimeUnit.SECONDS);
        httpClient.addInterceptor(getLoggingIntercept());
        httpClient.addInterceptor(chain -> {
            PackageInfo pInfo = null;
            try {
                pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            String version = pInfo.versionName;
            String token = "";
            if (token != null) {
                Request request = chain.request().newBuilder().addHeader("Authorization", "Bearer " + token)
                        .build();
                if (Configurations.isDevelopment()) {
                    Logger.log("Authorization: Bearer " + token);
                }
                return chain.proceed(request);
            } else {
                Request request = chain.request().newBuilder()
                        .build();
                return chain.proceed(request);
            }
        });

        networkClient = new Retrofit.Builder()
                .baseUrl(Configurations.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();
        services = networkClient.create(ApiServices.class);

    }

    public synchronized static Network getInstance() {
        if (object == null) {
            object = new Network();
        }
        return object;
    }

    public static void clearInstance() {
        object = null;
    }

    public static ApiServices apis() {
        return Network.getInstance().getApiServices();
    }

    public static String getBaseUrl() {
        return getNetworkClient().baseUrl().toString();
    }

    public ApiServices getApiServices() {
        return object.services;
    }


    private static Retrofit getNetworkClient() {
        if (object == null)
            getInstance();
        return getInstance().networkClient;
    }

    private TrustManager[] getWrappedTrustManagers(TrustManager[] trustManagers) {
        final X509TrustManager originalTrustManager = (X509TrustManager) trustManagers[0];
        return new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return originalTrustManager.getAcceptedIssuers();
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        try {
                            originalTrustManager.checkClientTrusted(certs, authType);
                        } catch (CertificateException ignored) {
                        }
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        try {
                            originalTrustManager.checkServerTrusted(certs, authType);
                        } catch (CertificateException ignored) {
                        }
                    }
                }
        };
    }

    public static BaseResponse parseErrorResponse(Response response) {
        BaseResponse errorResponse = null;
        try {
            if (ResponseCode.isBetweenSuccessRange(response.code())) {
                return (BaseResponse) response.body();
            } else {
                Converter<ResponseBody, BaseResponse> errorConverter =
                        getInstance().getNetworkClient().responseBodyConverter(BaseResponse.class, new Annotation[0]);
                errorResponse = errorConverter.convert(response.errorBody());
                errorResponse.setCode(response.code());
                if (errorResponse.getMessage() == null
                        || errorResponse.getMessage().equalsIgnoreCase("")) {
                    errorResponse.setMessage("Unable to communicate with " + Utils.getString(R.string.app_name) + " server, please try again.");
                }
                return errorResponse;
            }
        } catch (Exception e) {
            Logger.log(Logger.EXCEPTION, e);
            errorResponse = new BaseResponse();
            errorResponse.setCode(response.code());
            String errorString;
            try {
                errorString = response.errorBody().string();
            } catch (Exception ex) {
                errorString = Utils.getString(R.string.exceptionInErrorResponse);
            }
            if (errorString == null || errorString.trim().equalsIgnoreCase("")) {
                errorString = "Unable to communicate with " + Utils.getString(R.string.app_name) + " server, try again.";
            }
            errorResponse.setMessage(errorString);
            return errorResponse;
        }
    }

    public Interceptor getLoggingIntercept() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(message -> {
            if (Configurations.isProduction() && AppSession.getBoolean(Constants.IS_LOGGED_IN)) {
                Logger.log("OkHttp", message);
//                Log.e("OKHTTP::"," "+message);
            } else {
                Logger.log("okHttp", message);
//                Log.e("OKHTTP::"," 2 ="+message);
            }
        });
        return logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    public class BasicAuthInterceptor implements Interceptor {
        private String credentials;

        public BasicAuthInterceptor(String user, String password) {
            this.credentials = Credentials.basic(user, password);
        }

        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request authenticatedRequest = request.newBuilder()
                    .header("Authorization", credentials).build();
            return chain.proceed(authenticatedRequest);
        }
    }
}
