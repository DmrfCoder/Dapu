package cn.xiaojii.dapu.Fragment.Template;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import cn.xiaojii.dapu.Adapter.AnswerAdapter;
import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.Bean.ServerJsonBean;
import cn.xiaojii.dapu.Bean.TcmJsonBean;
import cn.xiaojii.dapu.Bean.UserInformationBean;
import cn.xiaojii.dapu.Factory.DataFactory.QuestionAndAnswerFactory;
import cn.xiaojii.dapu.Fragment.BaseFragment.BaseFragment;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.ParseTcmJsonUtil;
import cn.xiaojii.dapu.Utils.StartUtil;

@SuppressLint("ValidFragment")
public class QuestionnaireTemplateFragment extends BaseFragment {

    private String LeftText;
    private String FileName;
    private String UserName;

    public String finaldata="";

    private int[] UserScoreArray;//保存用户问卷/自测的得分
    private List<Integer> UserAnswerList;//保存用户问卷/自测的答案
    private int Score;

    private int ChallageFlag = -1;

    private List<TcmJsonBean> tcmJsonBeans;

    @SuppressLint("ValidFragment")
    public QuestionnaireTemplateFragment(Context context, String leftText, String fileName, UserInformationBean userInformationBean) {
        this.context = context;
        LeftText = leftText;
        FileName = fileName;
        questionBeanList = QuestionAndAnswerFactory.GetNormalData(context, fileName);
        QuestionCount = questionBeanList.size();
        CurQuestionIndex = 1;

        UserAnswerList = new ArrayList<>();
        UserScoreArray = new int[questionBeanList.size()];

        Score = 0;
        this.userInformationBean = userInformationBean;
    }


    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questionnaire, null);
        CurQuestionIndex = 1;
        if (userInformationBean.getInformationType() == GlogalBean.InformationType.TcmConstitutionIdentification) {
            userInformationBean.setInformationType(GlogalBean.InformationType.TcmResult);
        }

        InitView(view);

        return view;
    }

    @SuppressLint("SetTextI18n")
    private void InitView(View view) {

        LeftButton = view.findViewById(R.id.id_top_left);
        CenterTextview = view.findViewById(R.id.id_top_center);
        RightButton = view.findViewById(R.id.id_top_right);


        LeftButton.setText(LeftText);
        LeftButton.setVisibility(View.VISIBLE);

        RightButton.setText("交卷");
        RightButton.setVisibility(View.VISIBLE);

        CenterTextview.setText("问卷(" + CurQuestionIndex + "/" + QuestionCount + ")");
        CenterTextview.setVisibility(View.VISIBLE);

        LeftButton.setOnClickListener(this);
        RightButton.setOnClickListener(this);

        PreviousLinarLayout = view.findViewById(R.id.id_bommom_bar_previous);
        NextLinearLayout = view.findViewById(R.id.id_bottom_bar_next);

        PreviousLinarLayout.setOnClickListener(this);
        NextLinearLayout.setOnClickListener(this);

        QuestionTextView = view.findViewById(R.id.id_questionnaire_question);
        QuestionTextView.setText("问题:" + questionBeanList.get(0).getQuestion());

        AnalysisTextView = view.findViewById(R.id.id_questionnaire_analysis);


        AnswerListView = view.findViewById(R.id.id_questionnaire_answer_listview);

        answerAdapter = new AnswerAdapter(getActivity(), questionBeanList.get(0));
        AnswerListView.setAdapter(answerAdapter);

        AnswerSelectedTextView = view.findViewById(R.id.id_questionnaire_answer_selected);

        AnswerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                if (userInformationBean.getInformationType() == GlogalBean.InformationType.WaitYouChallage) {

                    if (ChallageFlag == CurQuestionIndex) {
                        return;
                    }
                    ChallageFlag = CurQuestionIndex;

                    AnalysisTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
                    AnalysisTextView.scrollTo(0, 0);//点击next后自动回滚到顶部
                    AnalysisTextView.setHorizontalScrollBarEnabled(false);// 隐藏滚动条


                    int CorrentAnswerIndex = questionBeanList.get(CurQuestionIndex - 1).getCorrectAnswer();

                    if (CorrentAnswerIndex == position) {
                        answerAdapter.setCurrentItem(-1, position);

                        AnswerSelectedTextView.setTextColor(getActivity().getResources().getColor(R.color.colorGreen));
                        AnswerSelectedTextView.setText("正确");
                        AnalysisTextView.setTextColor(getActivity().getResources().getColor(R.color.colorGreen));
                    } else {
                        answerAdapter.setCurrentItem(position, CorrentAnswerIndex);

                        AnswerSelectedTextView.setTextColor(getActivity().getResources().getColor(R.color.colorRed));
                        AnswerSelectedTextView.setText("错误");
                        AnalysisTextView.setTextColor(getActivity().getResources().getColor(R.color.colorRed));
                    }
                    answerAdapter.notifyDataSetChanged();

                    String Analysis = questionBeanList.get(CurQuestionIndex - 1).getAnalysis();
                    AnalysisTextView.setText("解析:" + Analysis);

                } else {
                    AnswerSelectedTextView.setText(IndexString[position]);
                    answerAdapter.setmCurrentItemNormal(position);
                    answerAdapter.notifyDataSetChanged();

                }


                if ((CurQuestionIndex - 1) >= UserAnswerList.size()) {
                    UserAnswerList.add(position);
                } else if (CurQuestionIndex == UserAnswerList.size()) {
                    UserAnswerList.set(CurQuestionIndex - 1, position);
                }


                if (position < 5) {
                    Score -= UserScoreArray[CurQuestionIndex - 1];
                    UserScoreArray[CurQuestionIndex - 1] = QuestionnaireScoreStandard[position];
                    Score += UserScoreArray[CurQuestionIndex - 1];
                }


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

                Submit();


                break;
            case R.id.id_bommom_bar_previous:
                if (CurQuestionIndex > 1) {
                    //注意以下几个语句执行的顺序
                    CurQuestionIndex--;
                    UpdateView();
                    RestoreAnswerView();

                } else {
                    onBack();
                }

                break;
            case R.id.id_bottom_bar_next:
                if (CurQuestionIndex < UserAnswerList.size()) {
                    CurQuestionIndex++;
                    UpdateView();
                    RestoreAnswerView();
                } else if (CurQuestionIndex < QuestionCount) {
                    CurQuestionIndex++;
                    UpdateView();
                } else {
                    Submit();
                }

                break;


        }
    }


    private void RestoreAnswerView() {

        if (CurQuestionIndex - 1 >= UserAnswerList.size()) {
            return;
        }

        if (userInformationBean.getInformationType() == GlogalBean.InformationType.WaitYouChallage) {


            AnalysisTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
            AnalysisTextView.scrollTo(0, 0);//点击next后自动回滚到顶部
            AnalysisTextView.setHorizontalScrollBarEnabled(false);// 隐藏滚动条


            int CorrentAnswerIndex = questionBeanList.get(CurQuestionIndex - 1).getCorrectAnswer();

            if (CorrentAnswerIndex == UserAnswerList.get(CurQuestionIndex - 1)) {
                answerAdapter.setCurrentItem(-1, UserAnswerList.get(CurQuestionIndex - 1));

                AnswerSelectedTextView.setTextColor(getActivity().getResources().getColor(R.color.colorGreen));
                AnswerSelectedTextView.setText("正确");
                AnalysisTextView.setTextColor(getActivity().getResources().getColor(R.color.colorGreen));
            } else {
                answerAdapter.setCurrentItem(UserAnswerList.get(CurQuestionIndex - 1), CorrentAnswerIndex);

                AnswerSelectedTextView.setTextColor(getActivity().getResources().getColor(R.color.colorRed));
                AnswerSelectedTextView.setText("错误");
                AnalysisTextView.setTextColor(getActivity().getResources().getColor(R.color.colorRed));
            }
            answerAdapter.notifyDataSetChanged();

            AnalysisTextView.setVisibility(View.VISIBLE);
            String Analysis = questionBeanList.get(CurQuestionIndex - 1).getAnalysis();
            AnalysisTextView.setText("解析:" + Analysis);

        } else {
            AnswerSelectedTextView.setText(IndexString[UserAnswerList.get(CurQuestionIndex - 1)]);
            answerAdapter.setmCurrentItemNormal(UserAnswerList.get(CurQuestionIndex - 1));
            answerAdapter.notifyDataSetChanged();

        }

    }

    private void Submit() {
        userInformationBean.setIntUserScore(Score);
        userInformationBean.setUserAnswerList(UserAnswerList);
        userInformationBean.setIntCurIndex(CurQuestionIndex);
        userInformationBean.setIntSumCount(QuestionCount);


        if (userInformationBean.getInformationType() == GlogalBean.InformationType.TcmResult) {
            int QiXuScore = FourItemSumScore(2, 3, 4, 14);
            int YangXuScore = FourItemSumScore(11, 12, 13, 29);
            int YinXuScore = FourItemSumScore(10, 21, 26, 31);
            int TanShiScore = FourItemSumScore(9, 16, 28, 32);
            int ShiReScore = FourItemSumScore(23, 25, 27, 30);
            int XueYuScore = FourItemSumScore(19, 22, 24, 33);
            int QiYuScore = FourItemSumScore(5, 6, 7, 8);
            int TeBingScore = FourItemSumScore(15, 17, 18, 20);
            int PingHeScore = PingHeScore();


            ParseTcmJsonUtil parseTcmJsonUtil = new ParseTcmJsonUtil(getActivity());

            List<TcmJsonBean> tcmJsonBeanList = parseTcmJsonUtil.GetJsonData("PhysiqueChineseMedicineConditioning.json");

            List<TcmJsonBean> tcmJsonBeanList1 = new ArrayList<>();


            int ZhiScore[] = {QiXuScore, YangXuScore, YinXuScore, TanShiScore, ShiReScore, XueYuScore, QiYuScore, TeBingScore, PingHeScore};

            int MaxScoreIndex = 0;
            for (int ZhiScoreIndex = 1; ZhiScoreIndex < ZhiScore.length - 1; ZhiScoreIndex++) {
                if (ZhiScore[ZhiScoreIndex] > ZhiScore[MaxScoreIndex]) {
                    MaxScoreIndex = ZhiScoreIndex;
                }
            }


            if (ZhiScore[MaxScoreIndex] < 8 && PingHeScore >= 17) {
                tcmJsonBeanList1.add(tcmJsonBeanList.get(0));
            }

            if (QiXuScore >= 11) {
                tcmJsonBeanList1.add(tcmJsonBeanList.get(1));
            }
            if (YangXuScore >= 11) {
                tcmJsonBeanList1.add(tcmJsonBeanList.get(2));
            }
            if (YinXuScore >= 11) {
                tcmJsonBeanList1.add(tcmJsonBeanList.get(3));
            }

            if (TanShiScore >= 11) {
                tcmJsonBeanList1.add(tcmJsonBeanList.get(4));
            }
            if (ShiReScore >= 11) {
                tcmJsonBeanList1.add(tcmJsonBeanList.get(5));
            }
            if (XueYuScore >= 11) {
                tcmJsonBeanList1.add(tcmJsonBeanList.get(6));
            }

            if (QiYuScore >= 11) {
                tcmJsonBeanList1.add(tcmJsonBeanList.get(7));
            }

            if (TeBingScore >= 11) {
                tcmJsonBeanList1.add(tcmJsonBeanList.get(8));
            }

            String tcmResult = "\n 您好，您的体质：";

            for (TcmJsonBean t : tcmJsonBeanList1) {
                tcmResult = tcmResult + t.toString();
            }
            tcmResult = tcmResult + "\n\n";
            userInformationBean.setStrTcmResult(tcmResult);
            userInformationBean.setInformationType(GlogalBean.InformationType.TcmResult);

            SaveData(userInformationBean);
            StartUtil.startActivityByUserInfo(getActivity(), userInformationBean);
            return;

        }

        finaldata=SaveData(userInformationBean);
        StartUtil.startActivityForQuestionnaireResult(getActivity(), userInformationBean);
    }

    private int FourItemSumScore(int a, int b, int c, int d) {
        return ItemScore(a) + ItemScore(b) + ItemScore(c) + ItemScore(d);
    }

    private int ItemScore(int a) {

        if (a - 1 < UserAnswerList.size()) {
            return TcmScoreStandard[UserAnswerList.get(a - 1)];
        } else {
            return 0;
        }

    }

    private int ReverseItemScore(int a) {

        if (a - 1 < UserAnswerList.size()) {
            return TcmScoreStandard[4 - UserAnswerList.get(a - 1)];
        } else {
            return 0;
        }

    }

    private int PingHeScore() {
        return ItemScore(1) + ReverseItemScore(2) + ReverseItemScore(4) + ReverseItemScore(5) + ReverseItemScore(13);

    }

}
