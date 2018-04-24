package com.mobile.schedule.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.mobile.schedule.R;

/**
 * Created by CimZzz on 2018/4/24.<br>
 * Project Name : YIQIMMM<br>
 * Since : YIQIMMM_1.99<br>
 * Description:<br>
 */
public class BaseDialog extends Dialog {
    public BaseDialog(@NonNull Context context) {
        super(context, R.style.DialogStyle);
    }

    @Override
    public void show() {
        super.show();
        Window window = getWindow();
        WindowManager windowManager = window.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams params = window.getAttributes();
        Point outSize = new Point();
        display.getSize(outSize);
        params.width = outSize.x;
        params.height = outSize.y;
        params.horizontalMargin = 0;
        params.verticalMargin = 0;
        window.setAttributes(params);
    }

}
