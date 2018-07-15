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
import cn.xiaojii.dapu.Utils.StartUtil;

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
        LeftButton.setText("＜ 发现");
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

        EtAge.setKeyListener(keyListener);
        EtIdNumber.setKeyListener(keyListener);


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

        if (!GlogalBean.DEBUG) {
            //检测输入是否都不为空
            if (name.equals("") || str_age.equals("") || id.equals("")) {//有未输入的内容,提示用户输入
                WarningInput();
                return;
            }

            try {
                userInformationBean.setIntAge(str_age);
            } catch (Exception e) {
                WarningAge();
                return;
            }


            if (id.length() != 18) {
                WarningIdNumber();
                return;
            }

        }


        userInformationBean.setStrIdNumber(id);
        userInformationBean.setStrName(name);


        StartUtil.startActivityByUserInfo(getActivity(), userInformationBean);
    }
}
