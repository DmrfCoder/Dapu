package cn.xiaojii.dapu.Fragment.Discover;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import cn.xiaojii.dapu.Fragment.BaseFragment;
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


        LeftButton.setText("<发现");


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
                String StrWeight = BodyWeight.getText().toString();
                String StrHeight = Height.getText().toString();

                float FloatWeight = -1;
                float FloatHeight = -1;

                FloatWeight = Float.parseFloat(StrWeight);
                FloatHeight = Float.parseFloat(StrHeight);

                if (FloatHeight != -1 && FloatWeight != -1) {
                    FloatHeight = FloatHeight / 100;//将厘米换算成米

                    float BMI = FloatWeight / (FloatHeight * FloatHeight);
                    DecimalFormat fmt = new DecimalFormat("##0.00");

                    ResultNumber.setText(fmt.format(BMI));
                    if (BMI >= 18 && BMI <= 25) {
                        ResultLevel.setText("正常");
                    } else if (BMI < 18) {
                        ResultLevel.setText("偏瘦");
                    } else {
                        ResultLevel.setText("偏胖");
                    }

                }

                break;
        }
    }
}
