package com.rensis.trivia.Model;


import com.rensis.trivia.db.RealmManager;
import com.rensis.trivia.db.RealmMethods;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;

public class SolvedQuestions extends RealmObject {
    private RealmList<Answer> answers;

    public RealmList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(RealmList<Answer> answers) {
        this.answers = answers;
    }

    public void save() {
        RealmMethods.deleteAll(SolvedQuestions.class);
        Realm realm = RealmManager.getRealmInstance();
        realm.beginTransaction();
        realm.copyToRealm(this);
        realm.commitTransaction();
        realm.close();
    }


    public static SolvedQuestions init() {
        Realm realm = RealmManager.getRealmInstance();
        SolvedQuestions ans = null;
        if (realm.where(SolvedQuestions.class).count() > 0) {
            realm.beginTransaction();
            ans = realm.where(SolvedQuestions.class).findFirst();
            if (ans != null)
                ans = realm.copyFromRealm(ans);
            realm.commitTransaction();
        } else {
            ans = new SolvedQuestions();
        }
        realm.close();
        return ans;
    }

}