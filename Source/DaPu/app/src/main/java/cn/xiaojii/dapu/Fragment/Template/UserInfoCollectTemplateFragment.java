package cn.xiaojii.dapu.Fragment.Template;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.Bean.UserInformationBean;
import cn.xiaojii.dapu.Fragment.BaseFragment.BaseFragment;
import cn.xiaojii.dapu.Interfaces.SecondaryPageInterface;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.StartUtils;

/**
 * Created by Carson_Ho on 16/5/23.
 */
@SuppressLint("ValidFragment")
public class UserInfoCollectTemplateFragment extends BaseFragment implements SecondaryPageInterface {


    public UserInfoCollectTemplateFragment(GlogalBean.InformationType type) {
        Type = type;
    }

    private GlogalBean.InformationType Type;//标记是当前Secondary的所属

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_userinfo, null);


        InitView(view);
        InitData(view);

        return view;
    }

    private void InitData(View view) {
        userInformationBean = new UserInformationBean();
        if (Type == GlogalBean.InformationType.HypertensionSelfTest) {
            userInformationBean.setInformationType(GlogalBean.InformationType.HypertensionSelfTest);

            LeftButton.setText("<高血压");
            CenterTextview.setText("高血压自测");
            RightButton.setText("自测");

            ((TextView) view.findViewById(R.id.id_userinfo_tx_ill_time)).setText("高血压病程");
            ((TextView) view.findViewById(R.id.id_userinfo_tx_drugs)).setText("服降压药种类");
            ((TextView) view.findViewById(R.id.id_userinfo_tx_drug_number)).setText("服降压药总粒数");


        } else if (Type == GlogalBean.InformationType.HypertensionQuestionnaire) {
            userInformationBean.setInformationType(GlogalBean.InformationType.HypertensionQuestionnaire);

            LeftButton.setText("<高血压");
            CenterTextview.setText("高血压问卷");
            RightButton.setText("问卷");

            ((TextView) view.findViewById(R.id.id_userinfo_tx_ill_time)).setText("高血压病程");
            ((TextView) view.findViewById(R.id.id_userinfo_tx_drugs)).setText("服降压药种类");
            ((TextView) view.findViewById(R.id.id_userinfo_tx_drug_number)).setText("服降压药总粒数");

        } else if (Type == GlogalBean.InformationType.DiabetesSelfTest) {
            userInformationBean.setInformationType(GlogalBean.InformationType.DiabetesSelfTest);

            LeftButton.setText("<糖尿病");
            CenterTextview.setText("糖尿病自测");
            RightButton.setText("自测");

            ((TextView) view.findViewById(R.id.id_userinfo_tx_ill_time)).setText("糖尿病病程");
            ((TextView) view.findViewById(R.id.id_userinfo_tx_drugs)).setText("服降糖药种类");
            ((TextView) view.findViewById(R.id.id_userinfo_tx_drug_number)).setText("服降糖药总粒数");

        } else if (Type == GlogalBean.InformationType.DiabetesQuestionnaire) {
            userInformationBean.setInformationType(GlogalBean.InformationType.DiabetesQuestionnaire);
            LeftButton.setText("<糖尿病");
            CenterTextview.setText("糖尿病问卷");
            RightButton.setText("问卷");

            ((TextView) view.findViewById(R.id.id_userinfo_tx_ill_time)).setText("糖尿病病程");
            ((TextView) view.findViewById(R.id.id_userinfo_tx_drugs)).setText("服降糖药种类");
            ((TextView) view.findViewById(R.id.id_userinfo_tx_drug_number)).setText("服降糖药总粒数");
        }

    }


    private void InitView(View view) {
        LeftButton = view.findViewById(R.id.id_top_left);


        CenterTextview = view.findViewById(R.id.id_top_center);


        RightButton = view.findViewById(R.id.id_top_right);

        InitData(view);

        LeftButton.setVisibility(View.VISIBLE);
        RightButton.setVisibility(View.VISIBLE);
        CenterTextview.setVisibility(View.VISIBLE);

        LeftButton.setOnClickListener(this);
        RightButton.setOnClickListener(this);

        InitUserInfoView(view);

    }

    private void InitUserInfoView(View view) {
        EtName = view.findViewById(R.id.id_userinfo_name);
        EtAge = view.findViewById(R.id.id_userinfo_age);
        EtIdNumber = view.findViewById(R.id.id_userinfo_id_number);

        RgSex = view.findViewById(R.id.id_userinfo_sex);
        RgEducationLevel = view.findViewById(R.id.id_userinfo_educational_level);
        RgIllTime = view.findViewById(R.id.id_userinfo_ill_time);
        RgUseInsulin = view.findViewById(R.id.id_userinfo_insulin);
        RgWorkStatus = view.findViewById(R.id.id_userinfo_work_status);
        RgTypeOfMedication = view.findViewById(R.id.id_userinfo_drugs);

        EtTotalAmountOfInsulinAday = view.findViewById(R.id.id_userinfo_total_amount_of_insulin_a_day);
        EtNumberOfTablets = view.findViewById(R.id.id_userinfo_drug_number);
        EtFastingBloodSugar = view.findViewById(R.id.id_userinfo_fasting_blood_sugar);

        RgSex.setOnCheckedChangeListener(this);
        RgEducationLevel.setOnCheckedChangeListener(this);
        RgIllTime.setOnCheckedChangeListener(this);
        RgUseInsulin.setOnCheckedChangeListener(this);
        RgWorkStatus.setOnCheckedChangeListener(this);
        RgTypeOfMedication.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_top_left:
                onBack();
                break;
            case R.id.id_top_right:
                Determine();

                break;
        }


    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.id_userinfo_sex_male:
                userInformationBean.setSex(GlogalBean.Sex.Male);
                break;

            case R.id.id_userinfo_sex_female:
                userInformationBean.setSex(GlogalBean.Sex.Female);
                break;


            case R.id.id_userinfo_educational_level_0:
                userInformationBean.setEducationalLevel(GlogalBean.EducationalLevel.ElementarySchoolAndBelow);
                break;

            case R.id.id_userinfo_educational_level_1:
                userInformationBean.setEducationalLevel(GlogalBean.EducationalLevel.SecondarySchool);
                break;

            case R.id.id_userinfo_educational_level_2:
                userInformationBean.setEducationalLevel(GlogalBean.EducationalLevel.CollegeOrAbove);
                break;

            case R.id.id_userinfo_ill_time_0:
                userInformationBean.setIllTime(GlogalBean.IllTime.LessFive);
                break;

            case R.id.id_userinfo_ill_time_1:
                userInformationBean.setIllTime(GlogalBean.IllTime.FiveToTen);
                break;

            case R.id.id_userinfo_ill_time_2:
                userInformationBean.setIllTime(GlogalBean.IllTime.MoreThanTen);
                break;

            case R.id.id_userinfo_insulin_true:
                userInformationBean.setInsulinTherapy(GlogalBean.InsulinTherapy.TRUE);
                break;

            case R.id.id_userinfo_insulin_false:
                userInformationBean.setInsulinTherapy(GlogalBean.InsulinTherapy.FALSE);
                break;

            case R.id.id_userinfo_work_status_0:
                userInformationBean.setWorkStatus(GlogalBean.WorkStatus.Retirement);
                break;

            case R.id.id_userinfo_work_status_1:
                userInformationBean.setWorkStatus(GlogalBean.WorkStatus.Work);
                break;

            case R.id.id_userinfo_work_status_2:
                userInformationBean.setWorkStatus(GlogalBean.WorkStatus.NoWork);
                break;

            case R.id.id_userinfo_drugs_0:
                userInformationBean.setTypeOfMedication(GlogalBean.TypeOfMedication.One);
                break;

            case R.id.id_userinfo_drugs_1:
                userInformationBean.setTypeOfMedication(GlogalBean.TypeOfMedication.Two);
                break;

            case R.id.id_userinfo_drugs_2:
                userInformationBean.setTypeOfMedication(GlogalBean.TypeOfMedication.MoreThanThree);
                break;
        }

    }

    @Override
    public void Determine() {

        String name = EtName.getText().toString();
        String str_age = EtAge.getText().toString();
        String idnumber = EtIdNumber.getText().toString();

        String str_numberoftablets = EtNumberOfTablets.getText().toString();
        String str_fastingbloodsugar = EtFastingBloodSugar.getText().toString();
        String str_totalamountofinsulinaday = EtTotalAmountOfInsulinAday.getText().toString();

        if (name == "" || str_age == "" || idnumber == "" || str_numberoftablets == "" || str_fastingbloodsugar == "" || str_totalamountofinsulinaday == "") {
            return;

        }

        int int_age;
        try {
            int_age = Integer.parseInt(str_age);
        } catch (NumberFormatException e) {
            return;
        }
        userInformationBean.setIntAge(int_age);

        int int_numberoftablets;
        try {
            int_numberoftablets = Integer.parseInt(str_numberoftablets);
        } catch (NumberFormatException e) {
            return;
        }

        userInformationBean.setNumberOfTablets(int_numberoftablets);

        int int_fastingbloodsugar;
        try {
            int_fastingbloodsugar = Integer.parseInt(str_fastingbloodsugar);
        } catch (NumberFormatException e) {
            return;
        }

        userInformationBean.setFastingBloodSugar(int_fastingbloodsugar);

        int int_totalamountofinsulinaday;
        try {
            int_totalamountofinsulinaday = Integer.parseInt(str_totalamountofinsulinaday);
        } catch (NumberFormatException e) {
            return;
        }
        userInformationBean.setTotalAmountOfInsulinAday(int_totalamountofinsulinaday);


        SaveUserInfoData();


        if (Type == GlogalBean.InformationType.HypertensionSelfTest) {
            StartUtils.startActivityByJsonFileName(getActivity(), "HypertensionTest");

        } else if (Type == GlogalBean.InformationType.HypertensionQuestionnaire) {
            StartUtils.startActivityByJsonFileName(getActivity(), "HypertensionQuestionnaire");

        } else if (Type == GlogalBean.InformationType.DiabetesSelfTest) {

            StartUtils.startActivityByJsonFileName(getActivity(), "DiabetesTest");

        } else if (Type == GlogalBean.InformationType.DiabetesQuestionnaire) {
            StartUtils.startActivityByJsonFileName(getActivity(), "DiabetesQuestionnaire");

        }
    }
}
