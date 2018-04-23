package com.mobile.schedule.base;

import android.content.Context;

public abstract class IModule {
    protected final Context context;
    public IModule(Context context) {
        this.context = context;
    }
}