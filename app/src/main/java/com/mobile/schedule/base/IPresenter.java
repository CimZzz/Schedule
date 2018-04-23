package com.mobile.schedule.base;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.CallSuper;

import java.io.Serializable;

/**
 * Created by CimZzz on ${DATE}.<br>
 * Project Name : YIQIMMM<br>
 * Since : YIQIMMM_1.88<br>
 * Description:<br>
 *
 */
public abstract class IPresenter<T extends IExtendedView,E extends IMethod> implements Serializable {
    protected final T view;
    protected final E method;
    public IPresenter(T view) {
        this(view,null);
    }
    public IPresenter(T view,E method) {
        this.view = view;
        this.method = method;
    }
    protected void initPresenter() {
        
    }
    protected void afterViewInitialization() {
    }
    public final void registerBroadcastReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        if(view != null)
            view.registerBroadcastReceiver(receiver,filter);
    }
    public final void unregisterBroadcastReceiver(BroadcastReceiver receiver) {
        if(view != null)
            view.unregisterBroadcastReceiver(receiver);
    }
    protected void onSaveInstanceState(Bundle outState) {
    }


    protected boolean onUIResult(int requestCode, int resultCode, Intent data) {
        return false;
    }

    protected void onPause() {

    }

    protected void onResume() {

    }

    @CallSuper
    protected void onDestroy() {
    }
}
