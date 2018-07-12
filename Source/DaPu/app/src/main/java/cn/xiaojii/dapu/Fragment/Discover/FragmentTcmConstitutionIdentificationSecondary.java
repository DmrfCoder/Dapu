package cn.xiaojii.dapu.Fragment.Discover;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

import cn.xiaojii.dapu.Activity.ClickButtonActivity;
import cn.xiaojii.dapu.Fragment.BaseFragment;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.StartUtils;

public class FragmentTcmConstitutionIdentificationSecondary extends BaseFragment implements View.OnClickListener {


    private EditText EtName;
    private EditText EtAge;
    private EditText EtIdNumber;

    private RadioButton RbMale;
    private RadioButton RbFeMale;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover_tcm_constitution_identification_secondary, null);

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
        RbMale = view.findViewById(R.id.id_tcm_segmentedgroup_sex_man);
        RbFeMale = view.findViewById(R.id.id_tcm_segmentedgroup_sex_man);

        LeftButton.setOnClickListener(this);
        RightButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_top_left:
                onBack();
                break;
            case R.id.id_top_right:
                StartUtils.startActivityByJsonFileName(getActivity(), "PhysicalTest");
                break;
        }
    }
}
