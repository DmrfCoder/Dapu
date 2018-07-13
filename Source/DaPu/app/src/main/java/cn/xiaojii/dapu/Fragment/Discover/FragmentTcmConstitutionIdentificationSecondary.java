package cn.xiaojii.dapu.Fragment.Discover;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.Bean.UserInformationBean;
import cn.xiaojii.dapu.Fragment.BaseFragment.BaseFragment;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.StartUtils;

public class FragmentTcmConstitutionIdentificationSecondary extends BaseFragment {





    public FragmentTcmConstitutionIdentificationSecondary() {
        userInformationBean = new UserInformationBean();
        userInformationBean.setInformationType(GlogalBean.InformationType.TcmConstitutionIdentification);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover_tcm_constitution_identification_secondary, null);

        InitView(view);

        return view;
    }

    private void InitView(View view) {
        LeftButton = view.findViewById(R.id.id_top_left);
        LeftButton.setText("<发现");
        LeftButton.setVisibility(View.VISIBLE);


        CenterTextview = view.findViewById(R.id.id_top_center);
        CenterTextview.setText("中医体质辨识");
        CenterTextview.setVisibility(View.VISIBLE);

        RightButton = view.findViewById(R.id.id_top_right);
        RightButton.setText("测试");
        RightButton.setVisibility(View.VISIBLE);

        EtName = view.findViewById(R.id.id_tcm_name);
        EtAge = view.findViewById(R.id.id_tcm_age);
        EtIdNumber = view.findViewById(R.id.id_tcm_id_number);
        RgSex = view.findViewById(R.id.id_tcm_segmentedgroup_sex);


        RgSex.setOnCheckedChangeListener(this);

        LeftButton.setOnClickListener(this);
        RightButton.setOnClickListener(this);
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
            case R.id.id_tcm_segmentedgroup_sex_male:
                userInformationBean.setSex(GlogalBean.Sex.Male);
                break;
            case R.id.id_tcm_segmentedgroup_sex_female:
                userInformationBean.setSex(GlogalBean.Sex.Female);
                break;

        }
    }

    @Override
    public void Determine() {
        String name = EtName.getText().toString();
        String str_age = EtAge.getText().toString();
        String id = EtIdNumber.getText().toString();

//        //检测输入是否都不为空
//        if (name == "" || str_age == "" || id == "") {//有未输入的内容,提示用户输入
//            return;
//        }
//
//
//        //检测输入的年龄格式是否正确
//        int int_age;
//        try {
//            int_age = Integer.parseInt(str_age);
//        } catch (NumberFormatException e) {
//            return;
//        }
//
//        userInformationBean.setIntAge(int_age);
        userInformationBean.setStrIdNumber(id);
        userInformationBean.setStrName(name);


        StartUtils.startActivityByUserInfo(getActivity(),userInformationBean);
    }
}
