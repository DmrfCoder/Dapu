package cn.xiaojii.dapu.Fragment.Discover;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.xiaojii.dapu.Bean.TcmJsonBean;
import cn.xiaojii.dapu.Bean.UserInformationBean;
import cn.xiaojii.dapu.Fragment.BaseFragment.BaseFragment;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.ParseTcmJsonUtil;

@SuppressLint("ValidFragment")
public class TcmResultFragment extends BaseFragment {


    private int ZhiIndex;


    @SuppressLint("ValidFragment")
    public TcmResultFragment(UserInformationBean userInformationBean) {
        this.ZhiIndex = ZhiIndex;
        this.userInformationBean = userInformationBean;


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tcm_result, null);
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

        ((TextView) view.findViewById(R.id.id_tcm_result_name)).setText(userInformationBean.getStrName());


        ((TextView) view.findViewById(R.id.id_tcm_result_string)).setMovementMethod(ScrollingMovementMethod.getInstance());
        ((TextView) view.findViewById(R.id.id_tcm_result_string)).setText(userInformationBean.getStrTcmResult());
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
