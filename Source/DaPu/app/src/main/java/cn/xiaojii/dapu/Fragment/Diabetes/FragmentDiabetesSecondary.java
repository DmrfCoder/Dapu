package cn.xiaojii.dapu.Fragment.Diabetes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.Fragment.BaseFragment;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.StartUtils;

/**
 * Created by Carson_Ho on 16/5/23.
 */
@SuppressLint("ValidFragment")
public class FragmentDiabetesSecondary extends BaseFragment implements View.OnClickListener {


    public FragmentDiabetesSecondary(GlogalBean.Type type) {
        Type = type;
    }

    private GlogalBean.Type Type;//标记是当前Secondary的所属

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diabetes_secondary, null);


        LeftButton = view.findViewById(R.id.id_top_left);
        LeftButton.setText("<糖尿病");
        LeftButton.setVisibility(View.VISIBLE);


        CenterTextview = view.findViewById(R.id.id_top_center);



        RightButton = view.findViewById(R.id.id_top_right);

        if (Type== GlogalBean.Type.SelfTest){
            CenterTextview.setText("糖尿病自测");
            RightButton.setText("自测");
        }else {
            CenterTextview.setText("糖尿病问卷");
            RightButton.setText("问卷");
        }

        RightButton.setVisibility(View.VISIBLE);
        CenterTextview.setVisibility(View.VISIBLE);

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
                if (Type == GlogalBean.Type.SelfTest) {
                    StartUtils.startActivityByJsonFileName(getActivity(), "DiabetesTest");
                } else {
                    StartUtils.startActivityByJsonFileName(getActivity(), "DiabetesQuestionnaire");
                }

                break;
        }


    }
}
