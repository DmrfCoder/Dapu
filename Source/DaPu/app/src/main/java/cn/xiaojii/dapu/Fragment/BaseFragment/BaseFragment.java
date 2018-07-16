package cn.xiaojii.dapu.Fragment.BaseFragment;

import android.app.Instrumentation;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.xiaojii.dapu.Adapter.AnswerAdapter;
import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.Bean.QuestionBean;
import cn.xiaojii.dapu.Bean.ServerJsonBean;
import cn.xiaojii.dapu.Bean.UserInformationBean;
import cn.xiaojii.dapu.Interfaces.SecondaryPageInterface;
import cn.xiaojii.dapu.Serializer.UserInformationBeanSerializer;
import cn.xiaojii.dapu.Utils.OkHttpUtil;
import cn.xiaojii.dapu.Utils.WriteStringToFileUtil;

public class BaseFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, SecondaryPageInterface {
    public Context context;
    public Button LeftButton;
    public TextView CenterTextview;
    public Button RightButton;
    public ListView AnswerListView;
    public LinearLayout PreviousLinarLayout;
    public LinearLayout NextLinearLayout;
    public TextView QuestionTextView;
    public TextView AnswerSelectedTextView;
    public TextView AnalysisTextView;

    public List<QuestionBean> questionBeanList;

    public int CurQuestionIndex;
    public int QuestionCount;

    public AnswerAdapter answerAdapter;

    public String[] IndexString = {"A", "B", "C", "D", "E", "F"};

    public UserInformationBean userInformationBean;


    //限制EditText默认弹出数字键盘&&只能输入0~9以及X
    public KeyListener keyListener = new NumberKeyListener() {
        @NonNull
        @Override
        protected char[] getAcceptedChars() {

            char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'X'};
            return chars;
            //return new char[0];
        }

        /**
         * 0：无键盘,键盘弹不出来
         * 1：英文键盘
         * 2：模拟键盘
         * 3：数字键盘
         */
        @Override
        public int getInputType() {
            return 3;
        }
    };


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

    public int[] QuestionnaireScoreStandard = {0, 2, 4, 6, 8};
    public int[] TcmScoreStandard = {1, 2, 3, 4, 5};

    public GlogalBean.InformationType Type;//标记是当前Secondary的所属


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
        try {
            AnalysisTextView.setVisibility(View.GONE);
        } catch (NullPointerException e) {

        }


        AnswerSelectedTextView.setText("");
        CenterTextview.setText("问卷(" + CurQuestionIndex + "/" + QuestionCount + ")");
        QuestionTextView.setText("问题:" + questionBeanList.get(CurQuestionIndex - 1).getQuestion());
        answerAdapter.setQuestionBean(questionBeanList.get(CurQuestionIndex - 1));
        answerAdapter.notifyDataSetChanged();
    }

    //用来保存用户信息(userInformationBean)
    public void SaveData(UserInformationBean userInformationBean) {


        UserInformationBeanSerializer userInformationBeanSerializer = new UserInformationBeanSerializer();

        Type IntListType = new TypeToken<UserInformationBean>() {
        }.getType();

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(IntListType, userInformationBeanSerializer);

        Gson gson = builder.create();

        String datacontent = gson.toJson(userInformationBean);
        datacontent = removeUTFCharacters(datacontent).toString();


        final String filename;
        Calendar c = Calendar.getInstance();
        filename = c.get(Calendar.YEAR) + "_" + (c.get(Calendar.MONTH) + 1) + "_" + c.get(Calendar.DAY_OF_MONTH)
                + "_" + c.get(Calendar.HOUR_OF_DAY) + "_" + c.get(Calendar.MINUTE) + "_" + c.get(Calendar.SECOND) + "_" + userInformationBean.getStrName() + "_" + userInformationBean.getInformationType().ordinal();

        final String finalDatacontent = datacontent;
        if (userInformationBean.getInformationType() != GlogalBean.InformationType.WaitYouChallage) {
            OkHttpUtil.SendDataToServer(filename, finalDatacontent);
        }


        WriteStringToFileUtil writeStringToFileUtil = new WriteStringToFileUtil(getActivity());
        writeStringToFileUtil.WriteStringToFile(datacontent, filename);

    }


    public static StringBuffer removeUTFCharacters(String data) {
        Pattern p = Pattern.compile("\\\\u(\\p{XDigit}{4})");
        Matcher m = p.matcher(data);
        StringBuffer buf = new StringBuffer(data.length());
        while (m.find()) {
            String ch = String.valueOf((char) Integer.parseInt(m.group(1), 16));
            m.appendReplacement(buf, Matcher.quoteReplacement(ch));
        }
        m.appendTail(buf);
        return buf;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }

    @Override
    public void Determine() {

    }


    public void WarningInput() {
        Toast.makeText(getActivity(), "请填写完整的个人信息!", Toast.LENGTH_SHORT).show();
    }

    public void WarningIdNumber() {
        Toast.makeText(getActivity(), "请填写正确的身份证号!", Toast.LENGTH_SHORT).show();
    }

    public void WarningAge() {
        Toast.makeText(getActivity(), "请填写正确的年龄!", Toast.LENGTH_SHORT).show();
    }

    public void WarningFuYao() {
        Toast.makeText(getActivity(), "请填写正确的服药数量!", Toast.LENGTH_SHORT).show();
    }

    public void WarningXueTang() {
        Toast.makeText(getActivity(), "请填写正确的血糖值!", Toast.LENGTH_SHORT).show();
    }

    public void WarningYiDao() {
        Toast.makeText(getActivity(), "请填写正确的胰岛素总量!", Toast.LENGTH_SHORT).show();
    }


}
