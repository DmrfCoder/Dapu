package cn.xiaojii.dapu.Fragment.Template;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.xiaojii.dapu.Adapter.AnswerAdapter;
import cn.xiaojii.dapu.Factory.DataFactory.QuestionAndAnswerFactory;
import cn.xiaojii.dapu.Fragment.BaseFragment.BaseFragment;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.StartUtils;

@SuppressLint("ValidFragment")
public class QuestionnaireTemplateFragment extends BaseFragment {

    private String LeftText;
    private String FileName;
    private String UserName;

    private int[] UserAnswerArray;//保存用户问卷/自测的答案
    private int Score;


    @SuppressLint("ValidFragment")
    public QuestionnaireTemplateFragment(Context context, String leftText, String fileName) {
        this.context = context;
        LeftText =leftText;
        FileName = fileName;
        questionBeanList = QuestionAndAnswerFactory.GetNormalData(context, fileName);
        QuestionCount = questionBeanList.size();
        CurQuestionIndex = 1;
        UserAnswerArray = new int[QuestionCount];
    }


    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questionnaire, null);
        CurQuestionIndex = 1;
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

        PreviousButton = view.findViewById(R.id.id_bommom_bar_previous);
        NextButton = view.findViewById(R.id.id_bottom_bar_next);

        PreviousButton.setOnClickListener(this);
        NextButton.setOnClickListener(this);

        QuestionTextView = view.findViewById(R.id.id_questionnaire_question);
        QuestionTextView.setText("问题:" + questionBeanList.get(0).getQuestion());

        AnswerListView = view.findViewById(R.id.id_questionnaire_answer_listview);

        answerAdapter = new AnswerAdapter(getActivity(), questionBeanList.get(0));
        AnswerListView.setAdapter(answerAdapter);

        AnswerSelectedTextView = view.findViewById(R.id.id_questionnaire_answer_selected);

        AnswerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                AnswerSelectedTextView.setText(IndexString[position]);
                UserAnswerArray[CurQuestionIndex - 1] = position;

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
                }

                break;


        }
    }

}
