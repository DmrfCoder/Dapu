package cn.xiaojii.dapu.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;

import cn.xiaojii.dapu.Factory.FragmentFactory;
import cn.xiaojii.dapu.R;


/**
 * 所有能点击的按钮全部跳转到这个页面
 * Created by zs on 2015/11/3.
 */
public class SkipActivity extends FragmentActivity implements View.OnClickListener {

    FragmentManager fm;
    public Intent intent;
    public FragmentTransaction ft;

    public FrameLayout FlClickButton;
    public int ResId;
    public String id;
    public String PdfFileName;
    public int CurTabIndex;
    public int Code;

    public String FragmentName;

    public String JsonFileName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip);
        // 获取传递过来的资源id值

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        intent = getIntent();

        Code = intent.getIntExtra("code", 0);
        if (Code != 0) {
            ResId = intent.getIntExtra("ResId", 0);
            switch (Code) {
                case 1:
                    if (ResId==R.id.id_waiting_for_challenge){
                        ft.replace(R.id.fl_click_button, FragmentFactory.createByFragmentName("FragmentWaitYouChallage",SkipActivity.this));
                    }else {
                        ft.replace(R.id.fl_click_button, FragmentFactory.createById(ResId));
                    }

                    break;


                case 2:
                    CurTabIndex = intent.getIntExtra("tabIndex", 0);
                    ft.replace(R.id.fl_click_button, FragmentFactory.createByIdAndTabIndex(ResId, CurTabIndex));
                    break;

                case 3:
                    PdfFileName = intent.getStringExtra("pdf_file_name");
                    ft.replace(R.id.fl_click_button, FragmentFactory.createByIdAndPdfFileName(PdfFileName));
                    break;
                case 4:
                    FragmentName = intent.getStringExtra("fragmentName");
                    ft.replace(R.id.fl_click_button, FragmentFactory.createByFragmentName(FragmentName,SkipActivity.this));

                    break;
                case 5:
                    JsonFileName = intent.getStringExtra("jsonFileName");
                    ft.replace(R.id.fl_click_button, FragmentFactory.createByJsonFileName(JsonFileName,SkipActivity.this));

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
