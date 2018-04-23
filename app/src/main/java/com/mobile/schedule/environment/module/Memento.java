package com.mobile.schedule.environment.module;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;


import com.mobile.schedule.base.IModule;

import java.util.Set;

public class Memento extends IModule {
    private static final String SP_NAME = "Schedule";


    public Memento(Context context) {
        super(context);
    }

    @SuppressLint("Assert")
    public void cacheObjArray(@NonNull String[] mask, @NonNull Object[] objects) {
        SharedPreferences preferences = getSharedPreferences();

        assert mask.length == objects.length;
        int length = mask.length;
        SharedPreferences.Editor editor = preferences.edit();
        for(int i = 0 ; i < length ; i ++)
            cacheObj(editor,mask[i],objects[i]);
        editor.apply();
    }
    public Memento cacheObj(String mask, Object object) {
        SharedPreferences preferences = getSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        cacheObj(editor,mask,object);
        editor.apply();
        return this;
    }
    private void cacheObj(SharedPreferences.Editor editor, String mask, Object object) {
        if(object instanceof String)
            editor.putString(mask, (String) object);
        else if(object instanceof Integer)
            editor.putInt(mask, (Integer) object);
        else if(object instanceof Float)
            editor.putFloat(mask, (Float) object);
        else if(object instanceof Boolean)
            editor.putBoolean(mask, (Boolean) object);
        else if(object instanceof Long)
            editor.putLong(mask, (Long) object);
        else if(object instanceof Set)
            editor.putStringSet(mask, (Set<String>) object);
    }
    public Memento clearObjArray(@NonNull String[] mask) {
        SharedPreferences preferences = getSharedPreferences();

        int length = mask.length;
        SharedPreferences.Editor editor = preferences.edit();
        for(int i = 0 ; i < length ; i ++)
            clearObject(editor,mask[i]);
        editor.apply();
        return this;
    }
    public Memento clearObject(String mask) {
        SharedPreferences preferences = getSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        clearObject(editor,mask);
        editor.apply();
        return this;
    }

    private void clearObject(SharedPreferences.Editor editor, String mask) {
        editor.remove(mask);
    }

    public Memento clearAll(String name) {
        SharedPreferences preferences = getSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
        return this;
    }

    public int getInt(String mask, int defaultValue) {
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getInt(mask,defaultValue);
    }
    public String getString(String mask, String defaultValue) {
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getString(mask,defaultValue);
    }
    public boolean getBoolean(String mask, boolean defaultValue) {
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getBoolean(mask,defaultValue);
    }
    public Long getLong(String mask, long defaultValue) {
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getLong(mask,defaultValue);
    }
    public Float getFloat(String mask, float defaultValue) {
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getFloat(mask,defaultValue);
    }

    public Set<String> getStringSet(String mask, Set<String> defaultValue) {
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getStringSet(mask,defaultValue);
    }
    




    private SharedPreferences getSharedPreferences() {
        return context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }
}