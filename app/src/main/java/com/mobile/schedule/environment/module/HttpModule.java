package com.mobile.schedule.environment.module;

import android.content.Context;


import com.mobile.schedule.base.IModule;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpModule extends IModule {
    private OkHttpClient httpClient;

    public HttpModule(Context context) {
        super(context);
        httpClient = new OkHttpClient.Builder().build();
    }

    public OkHttpClient getHttpClient() {
        return httpClient;
    }
}