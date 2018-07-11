package cn.xiaojii.dapu.Factory;

import android.content.Context;
import android.support.v4.app.Fragment;

import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.Fragment.Diabetes.FragmentDiabetes;
import cn.xiaojii.dapu.Fragment.Diabetes.FragmentDiabetesSecondary;
import cn.xiaojii.dapu.Fragment.Discover.FragmentBmi;
import cn.xiaojii.dapu.Fragment.Discover.FragmentTcmConstitution;
import cn.xiaojii.dapu.Fragment.Discover.FragmentTcmConstitutionIdentificationSecondary;
import cn.xiaojii.dapu.Fragment.FragmentQuestionnaire;
import cn.xiaojii.dapu.Fragment.Hypertension.FragmentHypertension;
import cn.xiaojii.dapu.Fragment.Discover.FragmentDiscover;
import cn.xiaojii.dapu.Fragment.Discover.FragmentWaitYouChallage;
import cn.xiaojii.dapu.Fragment.Hypertension.FragmentHypertensionQuestionnaire;
import cn.xiaojii.dapu.Fragment.Hypertension.FragmentHypertensionSecondary;
import cn.xiaojii.dapu.Fragment.TopBar.FragmentAbout;
import cn.xiaojii.dapu.Fragment.TopBar.FragmentPdfReadList;
import cn.xiaojii.dapu.Fragment.TopBar.FragmentPdfReadPdf;
import cn.xiaojii.dapu.R;


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
                fragment = new FragmentTcmConstitutionIdentificationSecondary();
                break;

            case R.id.id_database_questionnaire:
                fragment = new FragmentDiabetesSecondary(GlogalBean.Type.Questionnaire);
                break;
            case R.id.id_database_self_test:
                fragment = new FragmentDiabetesSecondary(GlogalBean.Type.SelfTest);
                break;
            case R.id.id_hypertension_questionnaire:
                fragment = new FragmentHypertensionSecondary(GlogalBean.Type.Questionnaire);
                break;
            case R.id.id_hypertension_self_test:
                fragment = new FragmentHypertensionSecondary(GlogalBean.Type.SelfTest);
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
                fragment = new FragmentDiabetes();
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
                        fragment = new FragmentPdfReadList();
                        break;
                    case 2:
                        fragment = new FragmentPdfReadList();
                        break;
                }
                break;
            case R.id.id_top_center:
                break;
            case R.id.id_top_right:
                switch (CurTabIndex) {
                    case 0:
                        fragment = new FragmentAbout();
                        break;
                    case 1:
                        fragment = new FragmentAbout();
                        break;
                    case 2:
                        fragment = new FragmentAbout();
                        break;
                }
                break;

        }
        return fragment;
    }


    public static Fragment createByIdAndPdfFileName(String filename) {
        Fragment fragment = null;
        fragment = new FragmentPdfReadPdf(filename);
        return fragment;
    }

    public static Fragment createByFragmentName(String fragmentName, Context context) {
        Fragment fragment = null;


        switch (fragmentName) {
            case "FragmentTcmConstitution":
                fragment = new FragmentTcmConstitution(context);
                break;

            case "FragmentWaitYouChallage":
                fragment = new FragmentWaitYouChallage(context);
                break;
            case "FragmentHypertensionQuestionnaire":
                fragment = new FragmentHypertensionQuestionnaire(context);
                break;

        }
        return fragment;
    }

    public static Fragment createByJsonFileName(String jsonFileName, Context context) {
        Fragment fragment = null;


        switch (jsonFileName) {
            case "PhysicalTest":
                fragment = new FragmentQuestionnaire(context, "<中医体质辨识", "PhysicalTest.json");
                break;

            case "WaitYouChallage":
                fragment = new FragmentQuestionnaire(context, "<发现", "WaitYouChallage.json");
                break;
            case "HypertensionQuestionnaire":
                fragment = new FragmentQuestionnaire(context, "<高血压问卷", "HypertensionQuestionnaire.json");
                break;
            case "HypertensionTest":
                fragment = new FragmentQuestionnaire(context, "<高血压自测", "HypertensionTest.json");
                break;
            case "DiabetesQuestionnaire":
                fragment = new FragmentQuestionnaire(context, "<糖尿病问卷", "DiabetesQuestionnaire.json");
                break;
            case "DiabetesTest":
                fragment = new FragmentQuestionnaire(context, "<糖尿病自测", "DiabetesTest.json");
                break;

        }
        return fragment;

    }
}
