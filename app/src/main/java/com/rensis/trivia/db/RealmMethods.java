package com.rensis.trivia.db;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.RealmResults;

//import com.dryvecars.helpmeholy.provider.utils.Logger;

public class RealmMethods {

    public static synchronized void save(final RealmObject object) {
        final Realm realm = RealmManager.getRealmInstance();
        realm.beginTransaction();
        realm.insertOrUpdate(object);
        realm.commitTransaction();
        realm.close();
    }
    public static synchronized void delete(final Class<?> model, String key, String value) {
        Realm realm = RealmManager.getRealmInstance();
        final RealmResults list = realm.where((Class<? extends RealmModel>) model).equalTo(key, value).findAll();
        if (list.size() > 0) {
            if (!realm.isInTransaction()) {
                realm.beginTransaction();
            }
            list.deleteAllFromRealm();
            realm.commitTransaction();
            realm.close();
        }
    }public static synchronized void delete(final Class<?> model, String key, int value) {
        Realm realm = RealmManager.getRealmInstance();
        final RealmResults list = realm.where((Class<? extends RealmModel>) model).equalTo(key, value).findAll();
        if (list.size() > 0) {
            if (!realm.isInTransaction()) {
                realm.beginTransaction();
            }
            list.deleteAllFromRealm();
            realm.commitTransaction();
            realm.close();
        }
    }
    public static synchronized void saveAll(final List<RealmObject> objects, final RealmTransactionListener callback) {
        final Realm realm = RealmManager.getRealmInstance();
        realm.executeTransactionAsync(realm1 -> realm1.insertOrUpdate(objects), () -> {
            if (callback != null)
                callback.onRealmTransactionSuccess();
            //Logger.log("Transaction Executed", objects.getClass().getName());
            realm.close();
        }, error -> {
            if (callback != null)
                callback.onRealmTransactionFailure(error);
           // Utils.printStackTrace(error);
            realm.close();
        });
    }

    public static synchronized void deleteAll(final Class<?> model) {
        Realm realm = RealmManager.getRealmInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete((Class<? extends RealmModel>) model);
            }
        });
        realm.close();
    }

    public static synchronized Integer getNextKeyFor(final Class<?> table) {
        Realm realm = RealmManager.getRealmInstance();
        Integer nextKey = 0;
        try {
            Number number = realm.where((Class<? extends RealmModel>) table).max("primaryId");
            if (number != null) {
                nextKey = number.intValue() + 1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //Logger.log(Constants.EXCEPTION, e);
        } finally {
            realm.close();
            return nextKey;
        }
    }
}
