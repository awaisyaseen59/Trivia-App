package com.rensis.trivia.app;


public class BaseClass {
    public String string(int id) {
        return MainApplication.getAppContext().getString(id);
    }
}
