package com.mobile.schedule.ui.login;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mobile.schedule.R;
import com.mobile.schedule.base.ActionBarUICreator;
import com.mobile.schedule.base.BaseUI;
import com.mobile.schedule.ui.student.StudentUI;

/**
 * Created by CimZzz on 2018/4/23.<br>
 * Description:<br>
 */
public class LoginUI extends BaseUI {

    @Override
    protected void onBaseUICreate(ActionBarUICreator creator) {
        creator.setLayoutID(R.layout.ui_login);
    }

    @Override
    protected void onViewInit(Bundle savedInstanceState) {
        super.onViewInit(savedInstanceState);
    }

    public void onLoginClick(View view) {
        startActivity(new Intent(this, StudentUI.class));
        finish();
    }
}
