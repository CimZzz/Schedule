package com.mobile.schedule.ui.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mobile.schedule.R;
import com.mobile.schedule.base.ActionBarUICreator;
import com.mobile.schedule.base.BaseUI;
import com.mobile.schedule.ui.login.LoginUI;

/**
 * Created by CimZzz on 4/24/18.<br>
 * Description : <br>
 * 描述
 */
public class StudentUI extends BaseUI {

    @Override
    protected void onBaseUICreate(ActionBarUICreator creator) {
        creator.setLayoutID(R.layout.ui_home);
    }

    @Override
    protected void onViewInit(Bundle savedInstanceState) {
        super.onViewInit(savedInstanceState);
    }

    public void onTermClick(View view) {
    }

    public void onCheckSchedule(View view) {
    }

    public void onCheckExam(View view) {
    }

    public void onCheckPlan(View view) {
    }

    public void onLogoutClick(View view) {
        startActivity(new Intent(this, LoginUI.class));
        finish();
    }
}
