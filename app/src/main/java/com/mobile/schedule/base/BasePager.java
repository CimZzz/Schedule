package com.mobile.schedule.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by CimZzz on 05/01/2018.<br>
 * Project Name : YIQIMMM<br>
 * Since : YIQIMMM_1.89<br>
 * Description:<br>
 */
public abstract class BasePager<T extends IPresenter> extends Fragment {
    private boolean isFirstVisible = false;
    private boolean isVisible = false;
    private boolean isResume = false;

    private boolean isFirstConstruct = true;
    private View rootView;

    protected T presenter;

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
        if(isFirstConstruct) {
            ButterKnife.bind(this,rootView);
            onViewCreated(savedInstanceState);
            isFirstConstruct = false;
        }
    }

    @Override
    public final void onResume() {
        super.onResume();
        if(isFirstVisible && isVisible && !isResume) {
            isResume = true;
            OnResume();
        }
    }

    @Override
    public final void onPause() {
        super.onPause();
        if(isFirstVisible && isVisible && isResume) {
            isResume = false;
            OnPause();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser)
            isFirstVisible = true;

        if(isVisible != isVisibleToUser) {
            if(isVisibleToUser && !isFirstConstruct) {
                isResume = true;
                OnResume();
            }
            else {
                isResume = false;
                OnPause();
            }

            isVisible = isVisibleToUser;
        }
    }

    public View getRootView() {
        return rootView;
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }

    protected abstract View generateRootView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    protected abstract void onViewCreated(@Nullable Bundle savedInstanceState);


    protected void OnResume() {

    }
    protected void OnPause() {

    }
}
