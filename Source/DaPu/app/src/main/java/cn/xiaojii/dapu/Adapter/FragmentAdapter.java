package cn.xiaojii.dapu.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import cn.xiaojii.dapu.Factory.FragmentFactory;

/**
 * Created by Carson_Ho on 16/5/23.
 */
public class FragmentAdapter extends FragmentStatePagerAdapter{



    public FragmentAdapter(FragmentManager fm ) {
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0) {
        return FragmentFactory.createForMain(arg0);
    }//根据Item的位置返回对应位置的Fragment，绑定item和Fragment

    @Override
    public int getCount() {
        return 3;
    }//设置Item的数量

}


