package com.example.dima.goitandroidcheckpoint.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.compat.BuildConfig;

public class SharedPref {

    public static final String APP_PREFERENCES = BuildConfig.APPLICATION_ID;
    public static final String IS_USER_SIGN_IN = "is sign in";
    public static final String CURRENT_USER = "current user";

    private SharedPreferences mSharedPreferences;

    public SharedPref(Context context) {
        mSharedPreferences = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public boolean isUserSignIn() {
        return mSharedPreferences.getBoolean(IS_USER_SIGN_IN, false);
    }

    public void signIn(String userEmail) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(IS_USER_SIGN_IN, true);
        editor.putString(CURRENT_USER, userEmail);
        editor.apply();
    }

    public void signOut() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(IS_USER_SIGN_IN, false);
        editor.putString(CURRENT_USER, "");
        editor.apply();
    }

    public String getCurrentUser() {
        return mSharedPreferences.getString(CURRENT_USER, "");
    }

    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }
}
