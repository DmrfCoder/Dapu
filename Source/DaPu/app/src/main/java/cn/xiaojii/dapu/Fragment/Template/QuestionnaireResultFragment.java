package cn.xiaojii.dapu.Fragment.Template;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.Bean.UserInformationBean;
import cn.xiaojii.dapu.Fragment.BaseFragment.BaseFragment;
import cn.xiaojii.dapu.R;

@SuppressLint("ValidFragment")
public class QuestionnaireResultFragment extends BaseFragment {


    @SuppressLint("ValidFragment")
    public QuestionnaireResultFragment(UserInformationBean userInformationBean) {

        this.userInformationBean = userInformationBean;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questionnaire_result, null);

        InitView(view);

        return view;
    }

    private void InitView(View view) {

        LeftButton = view.findViewById(R.id.id_top_left);
        CenterTextview = view.findViewById(R.id.id_top_center);

        view.findViewById(R.id.id_top_right).setVisibility(View.GONE);

        LeftButton.setText("＜问卷(" + userInformationBean.getIntCurIndex() + "/" + userInformationBean.getIntSumCount() + ")");

        CenterTextview.setText("问卷结果");

        LeftButton.setVisibility(View.VISIBLE);
        CenterTextview.setVisibility(View.VISIBLE);

        LeftButton.setOnClickListener(this);

        ((TextView) view.findViewById(R.id.id_questionnaire_result_name)).setText(userInformationBean.getStrName());
        ((TextView) view.findViewById(R.id.id_questionnaire_result_score)).setText(String.valueOf(userInformationBean.getIntUserScore()));

        if (userInformationBean.getInformationType() == GlogalBean.InformationType.WaitYouChallage) {
            ((TextView) view.findViewById(R.id.id_questionnaire_result_title)).setText("挑战结果");
        } else if (userInformationBean.getInformationType() == GlogalBean.InformationType.DiabetesQuestionnaire || userInformationBean.getInformationType() == GlogalBean.InformationType.DiabetesSelfTest) {
            ((TextView) view.findViewById(R.id.id_questionnaire_result_title)).setText("糖尿病调查结果");
        }else
        if (userInformationBean.getInformationType() == GlogalBean.InformationType.HypertensionQuestionnaire || userInformationBean.getInformationType() == GlogalBean.InformationType.HypertensionSelfTest) {
            ((TextView) view.findViewById(R.id.id_questionnaire_result_title)).setText("高血压调查结果");
        }else if (userInformationBean.getInformationType()== GlogalBean.InformationType.TcmConstitutionIdentification){
            ((TextView) view.findViewById(R.id.id_questionnaire_result_title)).setText("体质测试结果");
        }


    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.id_top_left:
                Objects.requireNonNull(getActivity()).onBackPressed();//销毁当前Fragment避免陷入Fragment跳转循环
                break;
        }

    }
}
