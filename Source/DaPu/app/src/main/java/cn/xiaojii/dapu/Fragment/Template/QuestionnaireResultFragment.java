package cn.xiaojii.dapu.Fragment.Template;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.xiaojii.dapu.Bean.UserInformationBean;
import cn.xiaojii.dapu.Fragment.BaseFragment.BaseFragment;
import cn.xiaojii.dapu.R;

@SuppressLint("ValidFragment")
public class QuestionnaireResultFragment extends BaseFragment {




    @SuppressLint("ValidFragment")
    public QuestionnaireResultFragment(UserInformationBean userInformationBean) {

        this.QuestionCount = userInformationBean.getUserAnswerArray().length;
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

        LeftButton.setText("<问卷(1/" + QuestionCount + ")");

        CenterTextview.setText("问卷结果");

        LeftButton.setVisibility(View.VISIBLE);
        CenterTextview.setVisibility(View.VISIBLE);

        LeftButton.setOnClickListener(this);

        ((TextView) view.findViewById(R.id.id_questionnaire_result_name)).setText(userInformationBean.getStrName());
        ((TextView) view.findViewById(R.id.id_questionnaire_result_score)).setText(String.valueOf(userInformationBean.getUserScore()));

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.id_top_left:
                getActivity().onBackPressed();
                break;
        }

    }
}
