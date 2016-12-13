package com.example.espino.deportes.model;

import android.content.Context;

import com.example.espino.deportes.R;

import java.util.ArrayList;

/**
 * Created by espino on 12/12/16.
 */

public class SportsList {

    private static SportsList singleton;
    private static ArrayList<Sports> list;

    private SportsList(Context context){
        list = new ArrayList<>();
        list.add(new Sports(context.getResources().getString(R.string.athletism),
                Preferences.getInstance(context).getBoolean(context.getResources().getString(R.string.athletism))));
        list.add(new Sports(context.getResources().getString(R.string.basketball),
                Preferences.getInstance(context).getBoolean(context.getResources().getString(R.string.basketball))));
        list.add(new Sports(context.getResources().getString(R.string.darts),
                Preferences.getInstance(context).getBoolean(context.getResources().getString(R.string.darts))));
        list.add(new Sports(context.getResources().getString(R.string.footbal),
                Preferences.getInstance(context).getBoolean(context.getResources().getString(R.string.footbal))));
        list.add(new Sports(context.getResources().getString(R.string.hockey),
                Preferences.getInstance(context).getBoolean(context.getResources().getString(R.string.hockey))));
        list.add(new Sports(context.getResources().getString(R.string.ping_pong),
                Preferences.getInstance(context).getBoolean(context.getResources().getString(R.string.ping_pong))));
        list.add(new Sports(context.getResources().getString(R.string.rugby),
                Preferences.getInstance(context).getBoolean(context.getResources().getString(R.string.rugby))));
        list.add(new Sports(context.getResources().getString(R.string.snowboard),
                Preferences.getInstance(context).getBoolean(context.getResources().getString(R.string.snowboard))));
        list.add(new Sports(context.getResources().getString(R.string.swimming),
                Preferences.getInstance(context).getBoolean(context.getResources().getString(R.string.swimming))));
        list.add(new Sports(context.getResources().getString(R.string.volleyball),
                Preferences.getInstance(context).getBoolean(context.getResources().getString(R.string.volleyball))));
    }

    public static SportsList getInstance(Context context){
        if(singleton == null)
            singleton = new SportsList(context);

        return singleton;
    }

    public ArrayList<Sports> getList(){
        return list;
    }

}
