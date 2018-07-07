package cn.xiaojii.dapu.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Carson_Ho on 16/5/23.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter{

    List<Fragment> fragmentList;


    public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }//写构造方法，方便赋值调用

    @Override
    public Fragment getItem(int arg0) {
        return fragmentList.get(arg0);
    }//根据Item的位置返回对应位置的Fragment，绑定item和Fragment

    @Override
    public int getCount() {
        return fragmentList.size();
    }//设置Item的数量

}


