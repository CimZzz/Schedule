package com.mobile.schedule.base;

import java.util.ArrayList;

public class FunctionGroup<T extends IPresenter> {
    private static final byte STATE_INIT = 0;
    private static final byte STATE_INITED = 1;
    private static final byte STATE_RUN = 2;
    private static final byte STATE_STOP = 3;
    private static final byte STATE_DESTROY = 4;
    private final ArrayList<IFunction<T>> modules;
    private byte state;
    public FunctionGroup() {
        modules = new ArrayList<>();
        state = STATE_INIT;
    }
    public void addModule(IFunction<T> module,T t) {
        if(state == STATE_DESTROY)
            return;
        if(state != STATE_INIT)
            module.onInit(t);
        if (state == STATE_RUN)
            module.onResume();
        modules.add(module);
    }
    void onInit(T t) {
        state = STATE_INITED;
        int length = modules.size();
        for (int i = 0; i < length ; i ++)
            modules.get(i).onInit(t);
    }
    public void onResume() {
        int length = modules.size();
        for (int i = 0; i < length ; i ++)
            modules.get(i).onResume();
        state = STATE_RUN;
    }
    public void onPause() {
        state = STATE_STOP;
        int length = modules.size();
        for (int i = 0; i < length ; i ++)
            modules.get(i).onPause();
    }
    public void onDestroy() {
        state = STATE_DESTROY;
        for(IFunction module : modules)
            module.onDestroy();
    }
}