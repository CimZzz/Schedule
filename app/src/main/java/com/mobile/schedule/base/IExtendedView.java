package com.mobile.schedule.base;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;

import com.mobile.schedule.environment.CustomApplication;

/**
 * Created by CimZzz on ${DATE}.<br>
 * Project Name : YIQIMMM<br>
 * Since : YIQIMMM_1.88<br>
 * Description:<br>
 *
 */
public interface IExtendedView extends IView {
    CustomApplication getCustomApplication();
    Intent getIntent();
    void sendToast(String toast);
    void registerBroadcastReceiver(BroadcastReceiver receiver, IntentFilter intentFilter);
    void unregisterBroadcastReceiver(BroadcastReceiver receiver);
}
