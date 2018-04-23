package com.mobile.schedule.environment.module;

import android.content.Context;


import com.mobile.schedule.base.BaseRequest;
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
    public void enqueue(BaseRequest baseRequest) {
        httpClient.newCall(baseRequest.generateRequest()).enqueue(baseRequest);
    }
    public void enqueue(Request request, Callback callback) {
        httpClient.newCall(request).enqueue(callback);
    }

    public Response execute(Request request) throws IOException {
        return httpClient.newCall(request).execute();
    }
}