package com.rensis.trivia.app;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.StrictMode;

import com.rensis.trivia.activties.MainActivity;
import com.rensis.trivia.db.RealmManager;

import io.realm.Realm;

public class MainApplication extends Application {
    public static MainApplication INSTANCE;
    private Activity activity;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        Realm.init(this);

    }


    public void setCurrentActivity(Activity activity) {
        this.activity = activity;
    }

    public Activity getCurrentActivity() {
        return activity;
    }

    public static MainApplication getAppContext() {
        return INSTANCE;
    }

    public static void resetApplication() {
        RealmManager.getInstance().clearDB();
        AppSession.clearSharedPref();
        Intent intent = new Intent(MainApplication.getAppContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        MainApplication.getAppContext().startActivity(intent);
    }


}
