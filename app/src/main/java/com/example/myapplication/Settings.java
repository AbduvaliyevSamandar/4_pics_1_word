package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;

public class Settings {

    private Context context;
    private final SharedPreferences preferences;

    private static Settings settings;

    public static Settings getSettings(Context context){
        if(settings==null){
            settings=new Settings(context);
        }
        return settings;
    }
    private Settings(Context context){
        this.context=context;
        preferences=context.getSharedPreferences("settings",Context.MODE_PRIVATE);
    }


    public void setCoin(int coin){
        preferences.edit().putInt("coin",coin).apply();
    }

    public int getCoin(){
        return preferences.getInt("coin",GameData.INITIAL_COIN);
    }

    public void setcurrentgame(int currentgame){
        preferences.edit().putInt("current",currentgame).apply();
    }

    public int getcurrentgame(){
        return preferences.getInt("current",0);
    }
}
