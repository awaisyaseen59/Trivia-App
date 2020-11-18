package com.rensis.trivia.db;


import com.rensis.trivia.R;
import com.rensis.trivia.app.MainApplication;
import com.rensis.trivia.utils.Configurations;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmManager {

    private static RealmManager ourInstance = null;
    private RealmConfiguration realmConfig;

    public synchronized static RealmManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new RealmManager();
            Realm.setDefaultConfiguration(ourInstance.getConfig());
        }
        return ourInstance;
    }

    private RealmManager() {
    }

    public static Realm getRealmInstance() {
        return getInstance().newRealmInstance();
    }

    public Realm newRealmInstance() {
        return Realm.getDefaultInstance();
    }

    public RealmConfiguration getConfig() {
        if (realmConfig == null)
            realmConfig = new RealmConfiguration.Builder()
                    .name(MainApplication.getAppContext().getString(R.string.app_name) + ".realm")
                    .schemaVersion(Configurations.DB_VERSION)
                    .deleteRealmIfMigrationNeeded()
                    .build();
        return realmConfig;
    }

    public void clearDB() {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            realm.deleteAll();
            realm.commitTransaction();
        } catch (Exception e) {

        } finally {
            realm.close();
        }

    }
}
