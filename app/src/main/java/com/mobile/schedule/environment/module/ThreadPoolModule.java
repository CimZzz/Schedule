package com.mobile.schedule.environment.module;

import android.content.Context;

import com.mobile.schedule.base.IModule;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by CimZzz on 28/12/2017.<br>
 * Project Name : YIQIMMM<br>
 * Since : YIQIMMM_1.88<br>
 * Description:<br>
 */
public class ThreadPoolModule extends IModule {
    private ExecutorService threadPool;

    public ThreadPoolModule(Context context) {
        super(context);

        threadPool = Executors.newCachedThreadPool();
    }

    public void exec(Runnable runnable) {
        threadPool.execute(runnable);
    }

    public void shutdown() {
        threadPool.shutdownNow();
    }
}
