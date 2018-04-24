package com.mobile.schedule.ui.student;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.contrarywind.adapter.WheelAdapter;
import com.contrarywind.view.WheelView;
import com.mobile.schedule.R;
import com.mobile.schedule.base.ActionBarUICreator;
import com.mobile.schedule.base.BaseUI;
import com.mobile.schedule.ui.login.LoginUI;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CimZzz on 4/24/18.<br>
 * Description : <br>
 * 描述
 */
public class StudentUI extends BaseUI {


    @BindView(R.id.userName)
    TextView userName;
    @BindView(R.id.major)
    TextView major;
    @BindView(R.id.termText)
    TextView termText;
    @BindView(R.id.term)
    LinearLayout term;
    @BindView(R.id.checkSchedule)
    FrameLayout checkSchedule;
    @BindView(R.id.checkExam)
    FrameLayout checkExam;
    @BindView(R.id.checkPlan)
    FrameLayout checkPlan;

    @Override
    protected void onBaseUICreate(ActionBarUICreator creator) {
        creator.setLayoutID(R.layout.ui_home);
    }

    @Override
    protected void onViewInit(Bundle savedInstanceState) {
        super.onViewInit(savedInstanceState);
    }

    public void onTermClick(View view) {
        new TermPickerDialog(this, new TermPickerDialog.Callback() {
            @Override
            public void onSelected(int year, int termType) {
            }
        }).show();
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
