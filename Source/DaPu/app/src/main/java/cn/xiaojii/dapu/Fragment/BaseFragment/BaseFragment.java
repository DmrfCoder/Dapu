package cn.xiaojii.dapu.Fragment.BaseFragment;

import android.app.Instrumentation;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import cn.xiaojii.dapu.Adapter.AnswerAdapter;
import cn.xiaojii.dapu.Bean.QuestionBean;
import cn.xiaojii.dapu.Bean.UserInformationBean;
import cn.xiaojii.dapu.Interfaces.SecondaryPageInterface;

public class BaseFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, SecondaryPageInterface {
    public Context context;
    public Button LeftButton;
    public TextView CenterTextview;
    public Button RightButton;
    public ListView AnswerListView;
    public Button PreviousButton;
    public Button NextButton;
    public TextView QuestionTextView;
    public TextView AnswerSelectedTextView;
    public List<QuestionBean> questionBeanList;

    public int CurQuestionIndex;
    public int QuestionCount;

    public AnswerAdapter answerAdapter;

    public String[] IndexString = {"A", "B", "C", "D", "E", "F"};

    public UserInformationBean userInformationBean;


    public EditText EtName;
    public RadioGroup RgSex;
    public EditText EtAge;
    public EditText EtIdNumber;
    public RadioGroup RgEducationLevel;
    public RadioGroup RgIllTime;
    public RadioGroup RgUseInsulin;
    public RadioGroup RgWorkStatus;
    public RadioGroup RgTypeOfMedication;
    public EditText EtNumberOfTablets;
    public EditText EtFastingBloodSugar;
    public EditText EtTotalAmountOfInsulinAday;




    public void onBack() {
        new Thread() {
            public void run() {
                try {
                    Instrumentation inst = new Instrumentation();
                    inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                } catch (Exception e) {
                    Log.e("Exception when onBack", e.toString());
                }
            }
        }.start();

    }


    @Override
    public void onClick(View view) {

    }

    public void UpdateView() {
        AnswerSelectedTextView.setText("");
        CenterTextview.setText("问卷(" + CurQuestionIndex + "/" + QuestionCount + ")");
        QuestionTextView.setText("问题:" + questionBeanList.get(CurQuestionIndex - 1).getQuestion());
        answerAdapter.setQuestionBean(questionBeanList.get(CurQuestionIndex - 1));
        answerAdapter.notifyDataSetChanged();
    }

    //用来保存用户信息(userInformationBean)
    public void SaveUserInfoData() {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }

    @Override
    public void Determine() {

    }
}
