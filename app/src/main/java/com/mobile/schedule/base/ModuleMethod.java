package com.mobile.schedule.base;

import com.yiqimmm.apps.android.refactor.environment.CustomApplication;
import com.yiqimmm.apps.android.refactor.environment.module.DBModule;
import com.yiqimmm.apps.android.refactor.environment.module.DataModule;
import com.yiqimmm.apps.android.refactor.environment.module.HttpModule;
import com.yiqimmm.apps.android.refactor.environment.module.Memento;
import com.yiqimmm.apps.android.refactor.environment.module.ThreadPoolModule;

import org.greenrobot.eventbus.EventBus;

public abstract class ModuleMethod {
    protected final CustomApplication customApplication;
    protected final Memento memento;
    protected final HttpModule httpModule;
    protected final ThreadPoolModule threadPoolModule;
    protected final DataModule dataModule;
    protected final DBModule dbModule;
    protected final EventBus defaultEventBus;
    protected EventBus privateEventBus;

    protected ModuleMethod(CustomApplication customApplication) {
        this.customApplication = customApplication;
        this.memento = customApplication.getMemento();
        this.httpModule = customApplication.getHttpModule();
        this.threadPoolModule = customApplication.getThreadPoolModule();
        this.dataModule = customApplication.getDataModule();
        this.dbModule = customApplication.getDbModule();

        this.defaultEventBus = EventBus.getDefault();
    }

    public void setPrivateEventBus(EventBus privateEventBus) {
        this.privateEventBus = privateEventBus;
    }
}