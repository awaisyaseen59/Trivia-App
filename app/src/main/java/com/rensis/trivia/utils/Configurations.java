package com.rensis.trivia.utils;

import com.rensis.trivia.R;
import com.rensis.trivia.app.MainApplication;

public class Configurations {

    public enum Environments {
        Development,
        Production,
        Local,
        Atif
    }

    public static final Environments environment = Environments.Development;

    public static final long DB_VERSION = 1;
    public static boolean isProduction() {
        boolean isProduction;
        try {isProduction = environment == Environments.Production;
        } catch (Exception e) {
            isProduction = false;
        }
        return isProduction;
    }
    public static boolean isDevelopment() {
        boolean isDevelopment;
        try {
            isDevelopment = environment == Environments.Development;
        } catch (Exception e) {
            isDevelopment = false;
        }
        return isDevelopment;
    }
    public static boolean isLocal() {
        boolean isLocal;
        try {
            isLocal = environment == Environments.Local;
        } catch (Exception e) {
            isLocal = false;
        }
        return isLocal;
    }

        public static String getBaseUrl() {
            if (environment == Environments.Development) {
                return MainApplication.getAppContext().getString(R.string.development);
            } else if (environment == Environments.Local){
                return MainApplication.getAppContext().getString(R.string.local);
            }  else {
                return MainApplication.getAppContext().getString(R.string.production);
            }
    }

    public static String getEnvName() {
        return environment.toString();
    }
}

