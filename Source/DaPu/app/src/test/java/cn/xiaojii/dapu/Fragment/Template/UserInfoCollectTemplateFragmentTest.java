package cn.xiaojii.dapu.Fragment.Template;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import cn.xiaojii.dapu.Activity.SkipActivity;
import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.BuildConfig;
import cn.xiaojii.dapu.R;

import static org.junit.Assert.*;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class UserInfoCollectTemplateFragmentTest {

    private SkipActivity skipActivity;
    private UserInfoCollectTemplateFragment userInfoCollectTemplateFragment;
    public Button RightButton;


    @Before
    public void setUp() {
        //输出日志
        ShadowLog.stream = System.out;
        skipActivity = Robolectric.setupActivity(SkipActivity.class);

    }

    @Test
    public void testUserInfoCollectTemplateFragment() {
        userInfoCollectTemplateFragment = new UserInfoCollectTemplateFragment(GlogalBean.InformationType.DiabetesQuestionnaire);
        //此api可以主动添加Fragment到Activity中，因此会触发Fragment的onCreateView()
        SupportFragmentTestUtil.startFragment(userInfoCollectTemplateFragment);
        assertNotNull(userInfoCollectTemplateFragment.getView());

        View view= userInfoCollectTemplateFragment.getView();

        RightButton =view.findViewById(R.id.id_top_right);

        EditText name=view.findViewById(R.id.id_userinfo_name);
        name.setText("张三");

        EditText age=view.findViewById(R.id.id_userinfo_age);
        age.setText("23");

        EditText idnumber=view.findViewById(R.id.id_userinfo_id_number);
        idnumber.setText("411722197303191234");

        RadioButton educationlevel=view.findViewById(R.id.id_userinfo_educational_level_1);
        educationlevel.setChecked(true);





        name.setText("22");





        //RightButton.performClick();
        assertEquals("22", userInfoCollectTemplateFragment.getTest());


    }


}