package com.mobile.schedule.ui.addschedule;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mobile.schedule.R;
import com.mobile.schedule.base.ActionBarUICreator;
import com.mobile.schedule.base.BaseUI;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CimZzz on 2018/4/24.<br>
 * Project Name : YIQIMMM<br>
 * Since : YIQIMMM_1.99<br>
 * Description:<br>
 */
public class AddScheduleUI extends BaseUI {
    @BindView(R.id.backBtn)
    ImageView backBtn;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.courseList)
    ListView courseList;
    @BindView(R.id.coursePlanList)
    ListView coursePlanList;

    @Override
    protected void onBaseUICreate(ActionBarUICreator creator) {
        creator.setActionBarID(R.layout.actionbar_title_back);
        creator.setLayoutID(R.layout.ui_addschedule);
    }

    @Override
    protected void onViewInit(Bundle savedInstanceState) {
        super.onViewInit(savedInstanceState);
        title.setText("添加/修改课程安排");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void onAddNewCourse(View view) {
    }

    public void onAddPlanClick(View view) {
    }
}
