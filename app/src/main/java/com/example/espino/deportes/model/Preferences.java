package com.example.espino.deportes.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by espino on 12/12/16.
 */

public class Preferences {

    public static Preferences instance;
    public static SharedPreferences preferences;

    private Preferences(Context context){
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static Preferences getInstance(Context context){
        if(instance == null)
            instance = new Preferences(context);

        return instance;
    }

    private SharedPreferences.Editor getEditor(){
        return preferences.edit();
    }

    public boolean putBoolean(String key, boolean value){
        return getEditor().putBoolean(key, value).commit();
    }

    public boolean getBoolean(String key){
        return preferences.getBoolean(key, false);
    }
}
