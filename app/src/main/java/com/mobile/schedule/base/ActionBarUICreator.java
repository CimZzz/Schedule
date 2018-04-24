package com.mobile.schedule.base;

/**
 * Created by CimZzz on 16/6/26.<br>
 * Description:<br>
 */
@SuppressWarnings("unused")
public class ActionBarUICreator {
    /**
     * 布局ID
     */
    private Integer layoutID;

    /**
     * ActionBar布局ID
     */
    private Integer actionBarID;

    /**
     * 是否显示工具栏
     */
    private boolean hasToolBar;



    ActionBarUICreator()
    {
        hasToolBar = true;
    }


    /*检验Creater是否合法*/
    boolean validate()
    {
        return (layoutID != null);
    }


    /*Getter & Setter*/

    Integer getLayoutID() {
        return layoutID;
    }

    public ActionBarUICreator setLayoutID(Integer layoutID) {
        this.layoutID = layoutID;

        return this;
    }


    Integer getActionBarID() {
        return actionBarID;
    }

    public ActionBarUICreator setActionBarID(Integer actionBarID) {
        this.actionBarID = actionBarID;

        return this;
    }

    public void setHasToolBar(boolean hasToolBar) {
        this.hasToolBar = hasToolBar;
    }

    boolean hasToolBar() {
        return hasToolBar;
    }
}