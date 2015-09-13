package com.gymkhana.iitbeats.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by bijoy on 7/23/15.
 */
public class LocalData {
    public static final String SHARED_PREFERENCES = "IITBEATS";

    //Load the data from the shared preferences
    public static String load(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SHARED_PREFERENCES, Activity.MODE_PRIVATE);
        String strValue = sp.getString(key, "");
        return strValue;
    }

    //Saves the data into the shared preferences
    public static void save(Context context,
                            String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(SHARED_PREFERENCES, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static final String getUsername(Context context) {
        return load(context, Tags.USERNAME);
    }

    public static final String getPassword(Context context) {
        return load(context, Tags.PASSWORD);
    }

    public static final boolean getBoolean(Context context, String key, boolean defaultBoolean) {
        String state = load(context, key);
        if (state.contentEquals(Tags.TRUE))
            return true;
        if (state.contentEquals(Tags.FALSE))
            return false;
        return defaultBoolean;
    }

    public static final class Tags {
        public static final String USERNAME = "USERNAME";
        public static final String PASSWORD = "PASSWORD";
        public static final String TRUE = "TRUE";
        public static final String FALSE = "FALSE";
    }

}
