package cn.xiaojii.dapu.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;

import cn.xiaojii.dapu.Factory.FragmentFactory;
import cn.xiaojii.dapu.Fragment.TopBar.FragmentPdfReadPdf;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.StartUtils;


/**
 * 所有能点击的按钮全部跳转到这个页面
 * Created by zs on 2015/11/3.
 */
public class ClickButtonActivity extends FragmentActivity implements View.OnClickListener {

    FragmentManager fm;
    public Intent intent;
    public FragmentTransaction ft;

    public FrameLayout flClickButton;
    public int resId;
    public String id;
    public String pdfFileName;
    public int CurTabIndex;
    public int Code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_button);
        // 获取传递过来的资源id值

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        intent = getIntent();

        Code = intent.getIntExtra("code", 0);
        if (Code != 0) {
            resId = intent.getIntExtra("resId", 0);
            switch (Code) {
                case 1:
                    ft.replace(R.id.fl_click_button, FragmentFactory.createById(resId));
                    break;


                case 2:
                    CurTabIndex = intent.getIntExtra("tabIndex", 0);
                    ft.replace(R.id.fl_click_button, FragmentFactory.createByIdAndTabIndex(resId,CurTabIndex));
                    break;
                case 3:
                    pdfFileName = intent.getStringExtra("pdf_file_name");
                    ft.replace(R.id.fl_click_button, FragmentFactory.createByIdAndPdfFileName(pdfFileName));
                    break;
            }
        }

        ft.commit();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_top_left:
                break;
            case R.id.center:
                break;
            case R.id.id_top_right:
                break;
        }
    }
}
