package com.rensis.trivia.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;


import com.rensis.trivia.R;
import com.rensis.trivia.app.MainApplication;

import java.math.BigDecimal;



public class Utils {
    public static void forceHideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
    }

    public static boolean isCause(
            Class<? extends Throwable> expected,
            Throwable exc) {
        return expected.isInstance(exc) || (
                exc != null && isCause(expected, exc.getCause())
        );
    }

    public static BigDecimal setDecimalPlaces(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, BigDecimal.ROUND_UP);
        return bd;
    }



    public static Loading getLoading(Activity activity) {
        return Loading.make(activity)
                .setCancelable(false)
                .setMessage(Utils.getString(R.string.pleaseWait))
                .show();
    }

    public static String getString(int id) {
        return MainApplication.getAppContext().getResources().getString(id);
    }

    public static Loading getLoading(Activity activity, String mesage) {
        return Loading.make(activity)
                .setCancelable(false)
                .setMessage(mesage)
                .show();
    }

    public static float convertDpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }



}
