package cn.xiaojii.dapu.Fragment.Template;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import cn.xiaojii.dapu.Activity.SkipActivity;
import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.Bean.UserInformationBean;
import cn.xiaojii.dapu.BuildConfig;
import cn.xiaojii.dapu.R;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class QuestionnaireTemplateFragmentTest {

    private SkipActivity skipActivity;
    private QuestionnaireTemplateFragment questionnaireTemplateFragment;
    public Button RightButton;
    private UserInformationBean userInformationBean;


    @Before
    public void setUp() {
        //输出日志
        ShadowLog.stream = System.out;
        skipActivity = Robolectric.setupActivity(SkipActivity.class);
        userInformationBean = new UserInformationBean();

        userInformationBean.setStrName("张三");
        userInformationBean.setSex(GlogalBean.Sex.Male);
        userInformationBean.setIntAge(23);
        userInformationBean.setStrIdNumber("411722197303191234");
        userInformationBean.setEducationalLevel(GlogalBean.EducationalLevel.SecondarySchool);
        userInformationBean.setIllTime(GlogalBean.IllTime.LessFive);
        userInformationBean.setWorkStatus(GlogalBean.WorkStatus.Retirement);
        userInformationBean.setTypeOfMedication(GlogalBean.TypeOfMedication.One);
    }

    private void InitDiabetesUserinfo() {
        userInformationBean.setIntNumberOfTablets(1);
        userInformationBean.setIntFastingBloodSugar(2);
        userInformationBean.setIntTotalAmountOfInsulinAday(1);
        userInformationBean.setInsulinTherapy(GlogalBean.InsulinTherapy.TRUE);
    }


    private void InitHypertensionUserinfo() {
        userInformationBean.setJiangYaYaoCiShu(GlogalBean.JiangYaYaoCiShu.One);
        userInformationBean.setPayWay(GlogalBean.PayWay.QuanGongFei);
    }



    @Test
    public void testQuestionnaireTemplateFragmentDiabetesWenjuan() {

        InitDiabetesUserinfo();

        userInformationBean.setInformationType(GlogalBean.InformationType.DiabetesQuestionnaire);

        questionnaireTemplateFragment = new QuestionnaireTemplateFragment(skipActivity, "back", "PhysicalTest.json", userInformationBean);
        //此api可以主动添加Fragment到Activity中，因此会触发Fragment的onCreateView()
        SupportFragmentTestUtil.startFragment(questionnaireTemplateFragment);
        assertNotNull(questionnaireTemplateFragment.getView());

        View view = questionnaireTemplateFragment.getView();

        RightButton = view.findViewById(R.id.id_top_right);


        RightButton.performClick();

        System.out.print(questionnaireTemplateFragment.finaldata);
       // assertEquals("", questionnaireTemplateFragment.finaldata);


    }



    @Test
    public void testQuestionnaireTemplateFragmentDiabetesCeshi() {

        InitDiabetesUserinfo();

        userInformationBean.setInformationType(GlogalBean.InformationType.DiabetesSelfTest);

        questionnaireTemplateFragment = new QuestionnaireTemplateFragment(skipActivity, "back", "PhysicalTest.json", userInformationBean);
        //此api可以主动添加Fragment到Activity中，因此会触发Fragment的onCreateView()
        SupportFragmentTestUtil.startFragment(questionnaireTemplateFragment);
        assertNotNull(questionnaireTemplateFragment.getView());

        View view = questionnaireTemplateFragment.getView();

        RightButton = view.findViewById(R.id.id_top_right);


        RightButton.performClick();

        System.out.print(questionnaireTemplateFragment.finaldata);
        // assertEquals("", questionnaireTemplateFragment.finaldata);


    }

    @Test
    public void testQuestionnaireTemplateFragmentHypertensionWenjuan() {

        InitHypertensionUserinfo();

        userInformationBean.setInformationType(GlogalBean.InformationType.HypertensionQuestionnaire);

        questionnaireTemplateFragment = new QuestionnaireTemplateFragment(skipActivity, "back", "PhysicalTest.json", userInformationBean);
        //此api可以主动添加Fragment到Activity中，因此会触发Fragment的onCreateView()
        SupportFragmentTestUtil.startFragment(questionnaireTemplateFragment);
        assertNotNull(questionnaireTemplateFragment.getView());

        View view = questionnaireTemplateFragment.getView();

        RightButton = view.findViewById(R.id.id_top_right);


        RightButton.performClick();

        System.out.print(questionnaireTemplateFragment.finaldata);
        // assertEquals("", questionnaireTemplateFragment.finaldata);


    }


    @Test
    public void testQuestionnaireTemplateFragmentHypertensionCeshi(){

        InitHypertensionUserinfo();

        userInformationBean.setInformationType(GlogalBean.InformationType.HypertensionSelfTest);

        questionnaireTemplateFragment = new QuestionnaireTemplateFragment(skipActivity, "back", "PhysicalTest.json", userInformationBean);
        //此api可以主动添加Fragment到Activity中，因此会触发Fragment的onCreateView()
        SupportFragmentTestUtil.startFragment(questionnaireTemplateFragment);
        assertNotNull(questionnaireTemplateFragment.getView());

        View view = questionnaireTemplateFragment.getView();

        RightButton = view.findViewById(R.id.id_top_right);


        RightButton.performClick();

        System.out.print(questionnaireTemplateFragment.finaldata);
        // assertEquals("", questionnaireTemplateFragment.finaldata);


    }

}