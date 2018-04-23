package com.mobile.schedule.environment;

import android.app.Application;
import android.content.Context;

import com.mobile.schedule.environment.module.FileModule;
import com.mobile.schedule.environment.module.HttpModule;
import com.mobile.schedule.environment.module.Memento;
import com.mobile.schedule.environment.module.ThreadPoolModule;

public class CustomApplication extends Application {
    private Memento memento;
    private FileModule fileModule;
    private HttpModule httpModule;
    private ThreadPoolModule threadPoolModule;

    @Override
    public void onCreate() {
        super.onCreate();

        Context context = getApplicationContext();
        /*初始化*/
        memento = new Memento(context);
        fileModule = new FileModule(context);
        httpModule = new HttpModule(context);
        threadPoolModule = new ThreadPoolModule(context);

    }

    public Memento getMemento() {
        return memento;
    }

    public FileModule getFileModule() {
        return fileModule;
    }

    public HttpModule getHttpModule() {
        return httpModule;
    }

    public ThreadPoolModule getThreadPoolModule() {
        return threadPoolModule;
    }

}