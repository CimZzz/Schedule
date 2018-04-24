package com.mobile.schedule.ui.addschedule;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import com.mobile.schedule.R;
import com.mobile.schedule.base.BaseDialog;

/**
 * Created by CimZzz on 2018/4/24.<br>
 * Project Name : YIQIMMM<br>
 * Since : YIQIMMM_1.99<br>
 * Description:<br>
 */
public class AddCourseDialog extends BaseDialog {

    public AddCourseDialog(@NonNull Context context) {
        super(context);

        setContentView(R.layout.dialog_add_course);
    }
}
