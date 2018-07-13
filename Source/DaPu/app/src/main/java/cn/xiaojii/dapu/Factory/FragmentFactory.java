package cn.xiaojii.dapu.Factory;

import android.content.Context;
import android.support.v4.app.Fragment;

import cn.xiaojii.dapu.Activity.SkipActivity;
import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.Bean.UserInformationBean;
import cn.xiaojii.dapu.Fragment.Diabetes.FragmentDiabetes;
import cn.xiaojii.dapu.Fragment.Discover.FragmentBmi;
import cn.xiaojii.dapu.Fragment.Discover.FragmentTcmConstitutionIdentificationSecondary;
import cn.xiaojii.dapu.Fragment.Discover.TcmResultFragment;
import cn.xiaojii.dapu.Fragment.Template.QuestionnaireResultFragment;
import cn.xiaojii.dapu.Fragment.Template.QuestionnaireTemplateFragment;
import cn.xiaojii.dapu.Fragment.Template.UserInfoCollectTemplateFragment;
import cn.xiaojii.dapu.Fragment.Hypertension.FragmentHypertension;
import cn.xiaojii.dapu.Fragment.Discover.FragmentDiscover;
import cn.xiaojii.dapu.Fragment.Discover.FragmentWaitYouChallage;
import cn.xiaojii.dapu.Fragment.TopBar.FragmentAbout;
import cn.xiaojii.dapu.Fragment.TopBar.FragmentPdfReadList;
import cn.xiaojii.dapu.Fragment.TopBar.FragmentPdfReadPdf;
import cn.xiaojii.dapu.R;

import static cn.xiaojii.dapu.Bean.GlogalBean.InformationType.TcmConstitutionIdentification;


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

            case R.id.id_diabetes_questionnaire:
                fragment = new UserInfoCollectTemplateFragment(GlogalBean.InformationType.DiabetesQuestionnaire);
                break;
            case R.id.id_diabetes_self_test:
                fragment = new UserInfoCollectTemplateFragment(GlogalBean.InformationType.DiabetesSelfTest);
                break;
            case R.id.id_hypertension_questionnaire:
                fragment = new UserInfoCollectTemplateFragment(GlogalBean.InformationType.HypertensionQuestionnaire);
                break;
            case R.id.id_hypertension_self_test:
                fragment = new UserInfoCollectTemplateFragment(GlogalBean.InformationType.HypertensionSelfTest);
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
                //fragment = new FragmentTcmConstitution(context);
                break;

            case "FragmentWaitYouChallage":
                fragment = new FragmentWaitYouChallage(context);
                break;


        }
        return fragment;
    }

    public static Fragment createByUserInfoType(Context context, UserInformationBean userInformationBean) {
        Fragment fragment = null;


        switch (userInformationBean.getInformationType()) {
            case TcmConstitutionIdentification:
                fragment = new QuestionnaireTemplateFragment(context, "<中医体质辨识", "PhysicalTest.json", userInformationBean);
                break;

            case WaitYouChallage:
                fragment = new QuestionnaireTemplateFragment(context, "<发现", "WaitYouChallage.json", userInformationBean);
                break;
            case HypertensionQuestionnaire:
                fragment = new QuestionnaireTemplateFragment(context, "<高血压问卷", "HypertensionQuestionnaire.json", userInformationBean);
                break;
            case HypertensionSelfTest:
                fragment = new QuestionnaireTemplateFragment(context, "<高血压自测", "HypertensionTest.json", userInformationBean);
                break;
            case DiabetesQuestionnaire:
                fragment = new QuestionnaireTemplateFragment(context, "<糖尿病问卷", "DiabetesQuestionnaire.json", userInformationBean);
                break;
            case DiabetesSelfTest:
                fragment = new QuestionnaireTemplateFragment(context, "<糖尿病自测", "DiabetesTest.json", userInformationBean);
                break;

        }
        return fragment;

    }

    public static Fragment createForQuestionnaireResult(UserInformationBean userInformationBean2) {
        return new QuestionnaireResultFragment(userInformationBean2);
    }

    public static Fragment createForTcmResult(UserInformationBean userInformationBean3, int finalZhiIndex) {
        return new TcmResultFragment(userInformationBean3, finalZhiIndex);
    }
}
