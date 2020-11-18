package com.rensis.trivia.utils;

import android.Manifest;

import java.util.Arrays;
import java.util.List;


public class Constants {
    public static final String IS_LOGGED_IN = "is_logged_in";
    public static String[] REQUIRED_PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.CALL_PHONE
    };
    public static List<String> permList= Arrays.asList(REQUIRED_PERMISSIONS);

    public class ACTIONS{
        public static final String UPLOAD_IMAGE = "uploadImage";
    }


}