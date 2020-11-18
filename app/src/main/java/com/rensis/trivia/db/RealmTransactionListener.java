package com.rensis.trivia.db;

public interface RealmTransactionListener {
    void onRealmTransactionSuccess();
    void onRealmTransactionFailure(Throwable error);
}