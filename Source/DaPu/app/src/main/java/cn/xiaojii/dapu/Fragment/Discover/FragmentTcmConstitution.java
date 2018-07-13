package cn.xiaojii.dapu.Fragment.Discover;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.List;

import cn.xiaojii.dapu.Adapter.AnswerAdapter;
import cn.xiaojii.dapu.Bean.TcmJsonBean;
import cn.xiaojii.dapu.Bean.UserInformationBean;
import cn.xiaojii.dapu.Factory.DataFactory.QuestionAndAnswerFactory;
import cn.xiaojii.dapu.Fragment.BaseFragment.BaseFragment;
import cn.xiaojii.dapu.Interfaces.SubmitInterface;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.ParseTcmJsonUtil;


@SuppressLint("ValidFragment")
public class FragmentTcmConstitution extends BaseFragment implements SubmitInterface {


    private List<TcmJsonBean> tcmJsonBeans;

    @SuppressLint("ValidFragment")
    public FragmentTcmConstitution(Context context, UserInformationBean userInformationBean) {
        this.context = context;
        questionBeanList = QuestionAndAnswerFactory.GetNormalData(context, "PhysicalTest.json");
        QuestionCount = questionBeanList.size();
        CurQuestionIndex = 1;
        UserAnswerArray = new int[QuestionCount];
        this.userInformationBean = userInformationBean;
        ParseTcmJsonUtil parseTcmJsonUtil =new ParseTcmJsonUtil(getActivity());
        tcmJsonBeans= parseTcmJsonUtil.GetJsonData("PhysiqueChineseMedicineConditioning.json");

    }


    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover_tcm_constitution, null);
        CurQuestionIndex = 1;
        InitView(view);

        return view;
    }

    @SuppressLint("SetTextI18n")
    private void InitView(View view) {

        LeftButton = view.findViewById(R.id.id_top_left);
        CenterTextview = view.findViewById(R.id.id_top_center);
        RightButton = view.findViewById(R.id.id_top_right);


        LeftButton.setText("<中医体质辨识");
        LeftButton.setVisibility(View.VISIBLE);

        RightButton.setText("交卷");
        RightButton.setVisibility(View.VISIBLE);

        CenterTextview.setText("问卷(" + CurQuestionIndex + "/" + QuestionCount + ")");
        CenterTextview.setVisibility(View.VISIBLE);

        LeftButton.setOnClickListener(this);
        RightButton.setOnClickListener(this);

        PreviousButton = view.findViewById(R.id.id_bommom_bar_previous);
        NextButton = view.findViewById(R.id.id_bottom_bar_next);

        PreviousButton.setOnClickListener(this);
        NextButton.setOnClickListener(this);

        QuestionTextView = view.findViewById(R.id.id_tcm_constitution_question);
        QuestionTextView.setText("问题:" + questionBeanList.get(0).getQuestion());

        AnswerListView = view.findViewById(R.id.id_tcm_constitution_answer_listview);

        answerAdapter = new AnswerAdapter(getActivity(), questionBeanList.get(0));
        AnswerListView.setAdapter(answerAdapter);

        AnswerSelectedTextView = view.findViewById(R.id.id_tcm_constitution_answer_selected);
        AnswerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                UserAnswerArray[CurQuestionIndex - 1] = position;
                AnswerSelectedTextView.setText(IndexString[position]);

            }
        });


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_top_left:
                onBack();
                break;
            case R.id.id_top_right:
              //  Submit();
                break;
            case R.id.id_bommom_bar_previous:
                if (CurQuestionIndex > 1) {
                    CurQuestionIndex--;
                    UpdateView();
                }

                break;
            case R.id.id_bottom_bar_next:
                if (CurQuestionIndex < QuestionCount) {
                    CurQuestionIndex++;
                    UpdateView();
                } else {

                    Submit();
                }

                break;


        }
    }


    @Override
    public void Submit() {

        int QiXuScore = FourItemSumScore(2, 3, 4, 14);
        int YangXuScore = FourItemSumScore(11, 12, 13, 29);
        int YinXuScore = FourItemSumScore(10, 21, 26, 31);
        int TanShiScore = FourItemSumScore(9, 16, 28, 32);
        int ShiReScore = FourItemSumScore(23, 25, 27, 30);
        int XueYuScore = FourItemSumScore(19, 22, 24, 33);
        int QiYuScore = FourItemSumScore(5, 6, 7, 8);
        int TeBingScore = FourItemSumScore(15, 17, 18, 20);
        int PingHeScore = PingHeScore();

        String ZhiName[] = {"气虚质", "阳虚质", "阴虚质", "痰湿质", "湿热质", "血瘀质", "气郁质", "特禀质", "平和质"};
        int ZhiScore[] = {QiXuScore, YangXuScore, YinXuScore, TanShiScore, ShiReScore, XueYuScore, QiYuScore, TeBingScore, PingHeScore};

        int MaxScoreIndex = 0;
        for (int ZhiScoreIndex = 1; ZhiScoreIndex < ZhiScore.length - 1; ZhiScoreIndex++) {
            if (ZhiScore[ZhiScoreIndex] > ZhiScore[MaxScoreIndex]) {
                MaxScoreIndex = ZhiScoreIndex;
            }
        }

        if (ZhiScore[MaxScoreIndex] < 8 && PingHeScore >= 17) {
            //平和质
        } else if (ZhiScore[MaxScoreIndex] < 10 && PingHeScore >= 17) {
            //基本是平和质
        } else if (ZhiScore[MaxScoreIndex] >= 11) {
            String Nama = ZhiName[MaxScoreIndex];//是
        } else if (ZhiScore[MaxScoreIndex] >= 9 && ZhiScore[MaxScoreIndex] <= 10) {
            String Nama = ZhiName[MaxScoreIndex];//倾向是
        } else if (ZhiScore[MaxScoreIndex] <= 8) {
            //什么都不是
        }

        SaveData(userInformationBean, "demo");
    }


    private int FourItemSumScore(int a, int b, int c, int d) {
        return ItemScore(a) + ItemScore(b) + ItemScore(c) + ItemScore(d);
    }

    private int ItemScore(int a) {
        return TcmScoreStandard[UserAnswerArray[a - 1]];
    }

    private int PingHeScore() {
        return TcmScoreStandard[UserAnswerArray[1 - 1]] + TcmScoreStandard[4 - UserAnswerArray[2 - 1]]
                + TcmScoreStandard[4 - UserAnswerArray[4 - 1]] + TcmScoreStandard[4 - UserAnswerArray[5 - 1]]
                + TcmScoreStandard[4 - UserAnswerArray[13 - 1]];
    }
}
