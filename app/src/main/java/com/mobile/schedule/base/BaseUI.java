package com.mobile.schedule.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.mobile.schedule.environment.CustomApplication;
import com.mobile.schedule.environment.module.FileModule;
import com.mobile.schedule.environment.module.HttpModule;
import com.mobile.schedule.environment.module.Memento;
import com.mobile.schedule.environment.module.ThreadPoolModule;

import butterknife.ButterKnife;

/**
 * Created by CimZzz on 4/24/18.<br>
 * Description : <br>
 * 描述
 */
public abstract class BaseUI extends ActionBarUI {
    private SVProgressHUD statusDialog;

    public void showStatusDialog(String text){
        closeStatusDialog();

        statusDialog = new SVProgressHUD(this);
        statusDialog.showWithStatus(text);
    }

    public void closeStatusDialog() {
        if(statusDialog != null)
            statusDialog.dismissImmediately();

        statusDialog = null;
    }

    public ThreadPoolModule getThreadPoolModule() {
        return getCustomApplication().getThreadPoolModule();
    }

    public FileModule getFileModule() {
        return getCustomApplication().getFileModule();
    }

    public HttpModule getHttpModule() {
        return getCustomApplication().getHttpModule();
    }

    public Memento getMemento() {
        return getCustomApplication().getMemento();
    }

    public CustomApplication getCustomApplication() {
        return (CustomApplication) getApplication();
    }

    @CallSuper
    @Override
    protected void onViewInit(Bundle savedInstanceState) {
        ButterKnife.bind(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    public  boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = { 0, 0 };
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
