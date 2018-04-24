package com.mobile.schedule.ui.student;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.contrarywind.adapter.WheelAdapter;
import com.contrarywind.view.WheelView;
import com.mobile.schedule.R;
import com.mobile.schedule.base.BaseDialog;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CimZzz on 2018/4/24.<br>
 * Project Name : YIQIMMM<br>
 * Since : YIQIMMM_1.99<br>
 * Description:<br>
 */
public class TermPickerDialog extends BaseDialog {
    @BindView(R.id.cancelBtn)
    TextView cancelBtn;
    @BindView(R.id.confirmBtn)
    TextView confirmBtn;
    @BindView(R.id.yearSelector)
    WheelView yearSelector;
    @BindView(R.id.termSelector)
    WheelView termSelector;

    private Integer[] yearArr;
    private String[] termArr = new String[] {
            "上学期", "下学期"
    };

    private final Callback callback;

    public TermPickerDialog(@NonNull Context context, final Callback callback) {
        super(context);
        this.callback = callback;

        setContentView(R.layout.dialog_term);
        ButterKnife.bind(this);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR) + 5;
        yearArr = new Integer[10];
        for(int i = 0 ; i < 10 ; i ++,year --)
            yearArr[i] = year;

        yearSelector.setCyclic(false);
        yearSelector.setAdapter(new WheelAdapter() {
            @Override
            public int getItemsCount() {
                return yearArr.length;
            }

            @Override
            public Object getItem(int index) {
                return yearArr[index];
            }

            @Override
            public int indexOf(Object o) {
                for(int i = 0 ; i < yearArr.length ; i ++)
                    if(yearArr[i].equals(o))
                        return i;
                return -1;
            }
        });

        termSelector.setCyclic(false);
        termSelector.setAdapter(new WheelAdapter() {
            @Override
            public int getItemsCount() {
                return termArr.length;
            }

            @Override
            public Object getItem(int index) {
                return termArr[index];
            }

            @Override
            public int indexOf(Object o) {
                for(int i = 0 ; i < termArr.length ; i ++)
                    if(termArr[i].equals(o))
                        return i;
                return -1;
            }
        });



        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onSelected(yearArr[yearSelector.getCurrentItem()],termSelector.getCurrentItem());
                dismiss();
            }
        });
    }

    public interface Callback {
        void onSelected(int year, int termType);
    }
}
