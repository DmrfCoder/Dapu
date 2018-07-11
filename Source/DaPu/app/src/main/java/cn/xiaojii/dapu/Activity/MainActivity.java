/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.xiaojii.dapu.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.xiaojii.dapu.Fragment.Discover.FragmentDiscover;
import cn.xiaojii.dapu.Fragment.Hypertension.FragmentHypertension;
import cn.xiaojii.dapu.Fragment.Diabetes.FragmentDiabetes;
import cn.xiaojii.dapu.Adapter.FragmentAdapter;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.StartUtils;
import cn.xiaojii.dapu.Widght.NoScrollViewPager;

public class MainActivity extends FragmentActivity implements
        TabHost.OnTabChangeListener, View.OnClickListener {

    private FragmentTabHost mTabHost;
    private LayoutInflater layoutInflater;
    private Class fragmentArray[] = {FragmentDiscover.class, FragmentHypertension.class, FragmentDiabetes.class};
    private int imageViewArray[] = {R.drawable.selector_tab_discover, R.drawable.selector_tab_hypertension, R.drawable.selector_tab_diabetes};
    private String textViewArray[] = {"发现", "高血压", "糖尿病"};
    private List<Fragment> fragmentList = new ArrayList<Fragment>();//三个tab对应的content fragment
    private NoScrollViewPager vp;
    private Button topLeftButton;
    private TextView topCenterTextview;
    private Button topRightButton;
    private int CurTabIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//初始化控件
        initPage();//初始化页面
    }


    //    控件初始化控件
    private void initView() {

        topLeftButton = findViewById(R.id.id_top_left);
        topRightButton = findViewById(R.id.id_top_right);
        topCenterTextview = findViewById(R.id.id_top_center);

        topLeftButton.setOnClickListener(this);
        topRightButton.setOnClickListener(this);

        vp = (NoScrollViewPager) findViewById(R.id.id_pager);

        /*实现OnPageChangeListener接口,目的是监听Tab选项卡的变化，然后通知ViewPager适配器切换界面*/
        /*简单来说,是为了让ViewPager滑动的时候能够带着底部菜单联动*/

        layoutInflater = LayoutInflater.from(this);//加载布局管理器

        /*实例化FragmentTabHost对象并进行绑定*/
        mTabHost = (FragmentTabHost) findViewById(R.id.id_tabhost);//绑定tahost
        mTabHost.setup(this, getSupportFragmentManager(), R.id.id_pager);//绑定viewpager

        /*实现setOnTabChangedListener接口,目的是为监听界面切换），然后实现TabHost里面图片文字的选中状态切换*/
        /*简单来说,是为了当点击下面菜单时,上面的ViewPager能滑动到对应的Fragment*/
        mTabHost.setOnTabChangedListener(this);

        int tabCount = textViewArray.length;

        /*新建Tabspec选项卡并设置Tab菜单栏的内容和绑定对应的Fragment*/
        for (int tabIndex = 0; tabIndex < tabCount; tabIndex++) {
            // 给每个Tab按钮设置标签、图标和文字
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(textViewArray[tabIndex])
                    .setIndicator(getTabItemView(tabIndex));
            // 将Tab按钮添加进Tab选项卡中，并绑定Fragment
            mTabHost.addTab(tabSpec, fragmentArray[tabIndex], null);
            mTabHost.setTag(tabIndex);
            mTabHost.getTabWidget().getChildAt(tabIndex)
                    .setBackgroundResource(R.drawable.selector_tab_background);//设置Tab被选中的时候颜色改变
        }
    }

    /*初始化Fragment*/
    private void initPage() {
        FragmentDiscover fragmentDiscover = new FragmentDiscover();
        FragmentHypertension fragmentHypertension = new FragmentHypertension();
        FragmentDiabetes fragmentDiabetes = new FragmentDiabetes();


        fragmentList.add(fragmentDiscover);
        fragmentList.add(fragmentHypertension);
        fragmentList.add(fragmentDiabetes);

        //绑定Fragment适配器
        vp.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        mTabHost.getTabWidget().setDividerDrawable(null);
    }

    private View getTabItemView(int tabIndex) {
        //将xml布局转换为view对象
        View view = layoutInflater.inflate(R.layout.tab_content, null);
        //利用view对象，找到布局中的组件,并设置内容，然后返回视图
        ImageView mImageView = (ImageView) view
                .findViewById(R.id.id_tab_icon);
        TextView mTextView = (TextView) view.findViewById(R.id.id_tab_name);
        mImageView.setBackgroundResource(imageViewArray[tabIndex]);
        mTextView.setText(textViewArray[tabIndex]);
        return view;
    }


    @Override
    public void onTabChanged(String tabId) {//Tab改变的时候调用


        int position = mTabHost.getCurrentTab();
        TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(position).findViewById(R.id.id_tab_name);

        tv.setTextColor(this.getResources().getColor(R.color.colorBlue));

        vp.setCurrentItem(position);//把选中的Tab的位置赋给适配器，让它控制页面切换
        CurTabIndex = position;
        UpdateTopView();
    }


    public void UpdateTopView() {//通过此方法更新顶部view


        switch (CurTabIndex) {
            case 0:
                UpdateTopViewFirst();
                break;
            case 1:
                UpdateTopViewSecond();
                break;
            case 2:
                UpdateTopViewThird();
                break;
        }

    }

    private void UpdateTopViewFirst() {
        topLeftButton.setText("资料");
        topCenterTextview.setText("发现");
        topRightButton.setText("关于");

    }

    private void UpdateTopViewSecond() {
        topLeftButton.setText("资料");
        topCenterTextview.setText("高血压");
        topRightButton.setText("关于");
    }

    private void UpdateTopViewThird() {
        topLeftButton.setText("资料");
        topCenterTextview.setText("糖尿病");
        topRightButton.setText("关于");
    }


    @Override
    public void onClick(View view) {
        StartUtils.startActivityByIdAndTabIndex(MainActivity.this, view.getId(), CurTabIndex);


    }
}

