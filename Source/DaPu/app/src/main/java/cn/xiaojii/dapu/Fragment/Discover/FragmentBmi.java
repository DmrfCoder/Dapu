package cn.xiaojii.dapu.Fragment.Discover;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import cn.xiaojii.dapu.Fragment.BaseFragment.BaseFragment;
import cn.xiaojii.dapu.R;

public class FragmentBmi extends BaseFragment {

    private EditText BodyWeight;
    private EditText Height;

    private TextView ResultNumber;
    private TextView ResultLevel;

    private Button Calculate;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover_bmi, null);


        LeftButton = view.findViewById(R.id.id_top_left);
        BodyWeight = view.findViewById(R.id.id_body_weight);
        Height = view.findViewById(R.id.id_height);
        ResultNumber = view.findViewById(R.id.id_result_number);
        ResultLevel = view.findViewById(R.id.id_result_string);
        Calculate = view.findViewById(R.id.id_bmi_calculate);


        view.findViewById(R.id.id_top_center).setVisibility(View.GONE);
        view.findViewById(R.id.id_top_right).setVisibility(View.GONE);
        LeftButton.setVisibility(View.VISIBLE);


        LeftButton.setText("＜ 发现");


        BodyWeight.setKeyListener(keyListener);
        Height.setKeyListener(keyListener);

        LeftButton.setOnClickListener(this);
        Calculate.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_top_left:
                onBack();
                break;
            case R.id.id_bmi_calculate:

                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputMethodManager.isActive()) {
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
                            InputMethodManager.HIDE_NOT_ALWAYS);
                }


                String StrWeight = BodyWeight.getText().toString();
                String StrHeight = Height.getText().toString();

                if (StrHeight.equals("") || StrWeight.equals("")) {
                    Toast.makeText(getActivity(), "请填写正确的身高和体重!", Toast.LENGTH_SHORT).show();
                    return;
                }

                float FloatWeight = -1;
                float FloatHeight = -1;

                FloatWeight = Float.parseFloat(StrWeight);
                FloatHeight = Float.parseFloat(StrHeight);

                if (FloatHeight != -1 && FloatWeight != -1) {
                    FloatHeight = FloatHeight / 100;//将厘米换算成米

                    float BMI = FloatWeight / (FloatHeight * FloatHeight);
                    DecimalFormat fmt = new DecimalFormat("##0.00");

                    ResultNumber.setText(fmt.format(BMI));
                    if (BMI >= 18.5 && BMI <= 23.9) {
                        ResultLevel.setText("正常");
                    } else if (BMI < 18.5) {
                        ResultLevel.setText("偏瘦");
                    } else {
                        ResultLevel.setText("偏胖");
                    }

                }

                break;
        }
    }
}
