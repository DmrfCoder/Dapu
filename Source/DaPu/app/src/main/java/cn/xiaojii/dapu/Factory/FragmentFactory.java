package cn.xiaojii.dapu.Factory;

import android.support.v4.app.Fragment;

import cn.xiaojii.dapu.Fragment.Database.FragmentDatabase;
import cn.xiaojii.dapu.Fragment.Database.FragmentDatabaseSecondary;
import cn.xiaojii.dapu.Fragment.Discover.FragmentBmi;
import cn.xiaojii.dapu.Fragment.Discover.FragmentTcmConstitutionIdentification;
import cn.xiaojii.dapu.Fragment.Hypertension.FragmentHypertension;
import cn.xiaojii.dapu.Fragment.Discover.FragmentDiscover;
import cn.xiaojii.dapu.Fragment.Discover.FragmentWaitYouChallage;
import cn.xiaojii.dapu.Fragment.Hypertension.FragmentHypertensionSecondary;
import cn.xiaojii.dapu.Fragment.TopBar.FragmentPdfReadList;
import cn.xiaojii.dapu.Fragment.TopBar.FragmentPdfReadPdf;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.StartUtils;


/**
 * fragment的工厂类
 * zs on 2015/11/3.
 */
public class FragmentFactory {

    /**
     * 根据资源id返回不同的fragment
     */
    public static Fragment createById(int resId) {
        Fragment fragment = null;
        switch (resId) {
            case R.id.id_bmi:
                fragment = new FragmentBmi();
                break;
            case R.id.id_physical_identification:
                fragment = new FragmentTcmConstitutionIdentification();
                break;
            case R.id.id_waiting_for_challenge:
                fragment = new FragmentWaitYouChallage();
                break;
            case R.id.id_database_questionnaire:
                fragment = new FragmentDatabaseSecondary();
                break;
            case R.id.id_database_self_test:
                fragment = new FragmentDatabaseSecondary();
                break;
            case R.id.id_hypertension_questionnaire:
                fragment = new FragmentHypertensionSecondary();
                break;
            case R.id.id_hypertension_self_test:
                fragment = new FragmentHypertensionSecondary();
                break;

        }
        return fragment;
    }

    /**
     * main
     *
     * @param position
     * @return
     */
    public static Fragment createForMain(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:// 发现
                fragment = new FragmentDiscover();
                break;
            case 1:// 高血压
                fragment = new FragmentHypertension();
                break;
            case 2:// 糖尿病
                fragment = new FragmentDatabase();
                break;
        }
        return fragment;
    }


    public static Fragment createByIdAndTabIndex(int resId, int CurTabIndex) {
        Fragment fragment = null;
        switch (resId) {
            case R.id.id_top_left:
                switch (CurTabIndex) {
                    case 0:
                        fragment = new FragmentPdfReadList();
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case R.id.id_top_center:
                break;
            case R.id.id_top_right:
                break;

        }
        return fragment;
    }


    public static Fragment createByIdAndPdfFileName(String filename) {
        Fragment fragment = null;
        fragment = new FragmentPdfReadPdf(filename);
        return fragment;
    }
}
