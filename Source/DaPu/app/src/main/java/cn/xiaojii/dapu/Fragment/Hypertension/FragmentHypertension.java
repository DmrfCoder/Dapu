package cn.xiaojii.dapu.Fragment.Hypertension;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.StartUtil;

/**
 * Created by Carson_Ho on 16/5/23.
 */
public class FragmentHypertension extends Fragment implements View.OnClickListener {
    private Button HypertensionQuestionnaire;
    private Button HypertensioSelfTest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hypertension, null);
        HypertensionQuestionnaire = view.findViewById(R.id.id_hypertension_questionnaire);
        HypertensioSelfTest = view.findViewById(R.id.id_hypertension_self_test);
        HypertensionQuestionnaire.setOnClickListener(this);
        HypertensioSelfTest.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        StartUtil.startActivityById(getActivity(), view.getId());
    }
}
