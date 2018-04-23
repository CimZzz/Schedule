package com.mobile.schedule.base;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.CallSuper;

import com.yiqimmm.apps.android.refactor.environment.CustomApplication;
import com.yiqimmm.apps.android.refactor.utils.ToastUtils;

import butterknife.ButterKnife;

//import com.yiqimmm.apps.android.refactor.utils.ToastUtils;

/**
 * Created by CimZzz on ${DATE}.<br>
 * Project Name : YIQIMMM<br>
 * Since : YIQIMMM_1.88<br>
 * Description:<br>
 *
 */
public abstract class BaseUI<T extends IPresenter> extends ActionBarUI {
    private FunctionGroup<T> functionGroup;
    protected T presenter;
    private boolean isFirstCreate;
    @Override
    protected final void onViewInit(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        presenter = getPresenter(savedInstanceState);
        if(presenter != null)
            presenter.initPresenter();
        onViewInitialization(savedInstanceState);

        isFirstCreate = true;
        if(functionGroup != null)
            functionGroup.onInit(presenter);

        if(presenter != null)
            presenter.afterViewInitialization();
    }
    protected abstract T getPresenter(Bundle savedInstanceState);
    protected abstract void onViewInitialization(Bundle savedInstanceState);
    protected final void openFunctionGroup() {
        functionGroup = new FunctionGroup<T>();
    }
    protected final void addFunctionModule(IFunction<T> module) {
        if(functionGroup != null)
            functionGroup.addModule(module,presenter);
    }
    protected void onFirstShowView() {}
    protected void onFocusShowView() {}


    public final void changeUI(Class<? extends Activity> baseUICls) {
        changeUI(baseUICls,null,null);
    }
    public final void changeUI(Class<? extends Activity> baseUICls, Bundle bundle) {
        changeUI(baseUICls,bundle,null);
    }
    public final void changeUI(Class<? extends Activity> baseUICls, Integer requestCode) {
        changeUI(baseUICls,null,requestCode);
    }
    public final void changeUI(Class<? extends Activity> baseUICls, Bundle bundle, Integer requestCode) {
        Intent intent = new Intent(this,baseUICls);
        if(bundle != null)
            intent.putExtras(bundle);
        if (requestCode != null)
            startActivityForResult(intent,requestCode);
        else startActivity(intent);
    }


    public final CustomApplication getCustomApplication() {
        return (CustomApplication) getApplication();
    }

//    public final OnlineModule getOnlineModule() {return getCustomApplication().getOnlineModule();}
    public final void sendToast(String toast) {
        ToastUtils.sendToast(getApplicationContext(),toast);
    }
    public final void registerBroadcastReceiver(BroadcastReceiver receiver, IntentFilter intentFilter) {
        registerReceiver(receiver,intentFilter);
    }
    public final void unregisterBroadcastReceiver(BroadcastReceiver receiver) {
        unregisterReceiver(receiver);
    }
    @Override
    @CallSuper
    public final void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus) {
            if(isFirstCreate) {
                isFirstCreate = false;
                onFirstShowView();
            }
            onFocusShowView();
        }
    }
    @Override
    @CallSuper
    protected void onResume() {
        super.onResume();
        if(functionGroup != null)
            functionGroup.onResume();
        if(presenter != null)
            presenter.onResume();
    }
    @Override
    @CallSuper
    protected void onPause() {
        super.onPause();
        if(functionGroup != null)
            functionGroup.onPause();
        if(presenter != null)
            presenter.onPause();
    }
    @Override
    @CallSuper
    protected void onDestroy() {
        super.onDestroy();
        if(functionGroup != null)
            functionGroup.onDestroy();
        if(presenter != null)
            presenter.onDestroy();
    }

    @Override
    @CallSuper
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(presenter != null)
            if(presenter.onUIResult(requestCode, resultCode, data))
                return;
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    @CallSuper
    protected final void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(presenter != null)
            presenter.onSaveInstanceState(outState);
    }
}
