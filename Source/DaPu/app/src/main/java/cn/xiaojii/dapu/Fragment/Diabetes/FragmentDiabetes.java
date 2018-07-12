package cn.xiaojii.dapu.Fragment.Diabetes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.StartUtils;

/**
 * Created by Carson_Ho on 16/5/23.
 */
public class FragmentDiabetes extends Fragment implements View.OnClickListener {
    private Button DatabaseQuestionnaire;
    private Button DatabaseSelfTest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diabetes, null);

        DatabaseQuestionnaire = view.findViewById(R.id.id_diabetes_questionnaire);
        DatabaseSelfTest = view.findViewById(R.id.id_diabetes_self_test);
        DatabaseQuestionnaire.setOnClickListener(this);
        DatabaseSelfTest.setOnClickListener(this);
        return view;
    }


    private void InitListener() {

        DatabaseQuestionnaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        DatabaseSelfTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public void onClick(View view) {

        StartUtils.startActivityById(getActivity(), view.getId());
    }
}
