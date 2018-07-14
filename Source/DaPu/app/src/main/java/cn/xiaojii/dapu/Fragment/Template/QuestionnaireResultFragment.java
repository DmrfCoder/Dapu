package cn.xiaojii.dapu.Fragment.Template;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.Fragment.BaseFragment.BaseFragment;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.StartUtils;

@SuppressLint("ValidFragment")
public class QuestionnaireResultFragment extends BaseFragment {

    private int Score;
    private String Name;


    @SuppressLint("ValidFragment")
    public QuestionnaireResultFragment(String name, int score, int QuestionCount, GlogalBean.InformationType Type) {
        Score = score;
        this.Name = name;
        this.QuestionCount = QuestionCount;
        this.Type = Type;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questionnaire_result, null);

        InitView(view);

        return view;
    }

    private void InitView(View view) {

        LeftButton = view.findViewById(R.id.id_top_left);
        CenterTextview = view.findViewById(R.id.id_top_right);

        view.findViewById(R.id.id_top_right).setVisibility(View.GONE);

        LeftButton.setText("<问卷(1/" + QuestionCount + ")");

        CenterTextview.setText("问卷结果");

        LeftButton.setVisibility(View.VISIBLE);
        CenterTextview.setVisibility(View.VISIBLE);

        ((TextView) view.findViewById(R.id.id_questionnaire_result_name)).setText(Name);
        ((TextView) view.findViewById(R.id.id_questionnaire_result_score)).setText(Score);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.id_top_left:

                if (Type == GlogalBean.InformationType.HypertensionSelfTest) {
                    StartUtils.startActivityByJsonFileName(getActivity(), "HypertensionTest");

                } else if (Type == GlogalBean.InformationType.HypertensionQuestionnaire) {
                    StartUtils.startActivityByJsonFileName(getActivity(), "HypertensionQuestionnaire");

                } else if (Type == GlogalBean.InformationType.DiabetesSelfTest) {

                    StartUtils.startActivityByJsonFileName(getActivity(), "DiabetesTest");

                } else if (Type == GlogalBean.InformationType.DiabetesQuestionnaire) {
                    StartUtils.startActivityByJsonFileName(getActivity(), "DiabetesQuestionnaire");

                }
                break;
        }

    }
}
