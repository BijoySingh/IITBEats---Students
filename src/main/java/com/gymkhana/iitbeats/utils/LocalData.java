package com.gymkhana.iitbeats.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by bijoy on 7/23/15.
 */
public class LocalData {
    public static final String SHARED_PREFERENCES = "IITBEATS";

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCES, Activity.MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getPreferencesEditor(Context context) {
        return getSharedPreferences(context).edit();
    }

    //Load the data from the shared preferences
    public static String load(Context context, String key) {
        return getSharedPreferences(context).getString(key, "");
    }

    //Load the data from the shared preferences
    public static String load(Context context, String key, String base) {
        return getSharedPreferences(context).getString(key, base);
    }

    //Load the data from the shared preferences
    public static Integer load(Context context, String key, Integer base) {
        return getSharedPreferences(context).getInt(key, base);
    }

    //Saves the data into the shared preferences
    public static void save(Context context, String key, String value) {
        getPreferencesEditor(context).putString(key, value).commit();
    }

    //Saves the data into the shared preferences
    public static void save(Context context, String key, Integer value) {
        getPreferencesEditor(context).putInt(key, value).commit();
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
        public static final String ACTIVE_SHOP_ID = "ACTIVE_SHOP_ID";

    }

}
