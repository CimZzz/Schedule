package com.mobile.schedule.base;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.schedule.environment.CustomApplication;

import butterknife.ButterKnife;

//import com.yiqimmm.apps.android.refactor.utils.ToastUtils;

/**
 * Created by CimZzz on ${DATE}.<br>
 * Project Name : YIQIMMM<br>
 * Since : YIQIMMM_1.88<br>
 * Description:<br>
 *
 */
public abstract class BaseFragment<T extends IPresenter> extends Fragment {
    private boolean isFirstConstruct = true;
    private View rootView;

    protected T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView == null)
            rootView = generateRootView(inflater, container, savedInstanceState);
        return rootView;
    }

    @Override
    public final void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (isFirstConstruct) {
            ButterKnife.bind(this, rootView);
            presenter = getPresenter(savedInstanceState);
            onViewCreated(savedInstanceState);
            isFirstConstruct = false;
            if(presenter != null)
                presenter.afterViewInitialization();
        }
    }


    public Intent getIntent() {
        Intent intent = new Intent();
        intent.putExtras(getArguments());
        return intent;
    }


    protected abstract View generateRootView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);
    protected abstract void onViewCreated(@Nullable Bundle savedInstanceState);
    protected abstract T getPresenter(Bundle savedInstanceState);

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
        Context context = getContext();
        if(context == null)
            return;
        Intent intent = new Intent(context,baseUICls);
        if(bundle != null)
            intent.putExtras(bundle);
        if (requestCode != null)
            startActivityForResult(intent,requestCode);
        else startActivity(intent);
    }


    public final CustomApplication getCustomApplication() {
        Activity activity = getActivity();
        return activity != null ? (CustomApplication) activity.getApplication() : null;
    }

//    public final OnlineModule getOnlineModule() {return getCustomApplication().getOnlineModule();}
    public final void sendToast(String toast) {
        Context context = getContext();
//        if(context != null)
//            ToastUtils.sendToast(context,toast);
    }
    public final void registerBroadcastReceiver(BroadcastReceiver receiver, IntentFilter intentFilter) {

        Context context = getContext();
        if(context != null)
            context.registerReceiver(receiver,intentFilter);
    }
    public final void unregisterBroadcastReceiver(BroadcastReceiver receiver) {
        Context context = getContext();
        if(context != null)
            context.unregisterReceiver(receiver);
    }

    @Override
    @CallSuper
    public final void onResume() {
        super.onResume();
        if(presenter != null)
            presenter.onResume();
    }
    @Override
    @CallSuper
    public final void onPause() {
        super.onPause();
        if(presenter != null)
            presenter.onPause();
    }
    @Override
    @CallSuper
    public final void onDestroy() {
        super.onDestroy();
        if(presenter != null)
            presenter.onDestroy();
    }

    @Override
    @CallSuper
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(presenter != null)
            if(presenter.onUIResult(requestCode, resultCode, data))
                return;
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    @CallSuper
    public final void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(presenter != null)
            presenter.onSaveInstanceState(outState);
    }
}
