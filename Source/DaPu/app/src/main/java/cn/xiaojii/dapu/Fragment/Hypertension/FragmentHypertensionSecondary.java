package cn.xiaojii.dapu.Fragment.Hypertension;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;


import cn.xiaojii.dapu.Fragment.BaseFragment;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.StartUtils;

/**
 * Created by Carson_Ho on 16/5/23.
 */
public class FragmentHypertensionSecondary extends BaseFragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hypertension_secondary, null);



        LeftButton = view.findViewById(R.id.id_top_left);
        LeftButton.setText("<高血压");
        LeftButton.setVisibility(View.VISIBLE);


        CenterTextview = view.findViewById(R.id.id_top_center);
        CenterTextview.setText("高血压问卷");
        CenterTextview.setVisibility(View.VISIBLE);

        RightButton = view.findViewById(R.id.id_top_right);
        RightButton.setText("问卷");
        RightButton.setVisibility(View.VISIBLE);

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
                StartUtils.startActivityByFragment(getActivity(), "");
                break;
        }


    }
}
