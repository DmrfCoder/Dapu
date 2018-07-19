package cn.xiaojii.dapu.Fragment.TopBar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.Fragment.BaseFragment.BaseFragment;
import cn.xiaojii.dapu.R;
import info.hoang8f.android.segmented.SegmentedGroup;

public class FragmentAbout extends BaseFragment implements View.OnClickListener {


    private Button LeftButton;
    private RadioButton KeYan;
    private RadioButton MenZhen;
    private SegmentedGroup segmentedGroup;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_bar_about, null);
        LeftButton = view.findViewById(R.id.id_about_top_left);
        KeYan = view.findViewById(R.id.id_keyan);
        MenZhen = view.findViewById(R.id.id_menzhen);
        LeftButton.setText("＜发现");
        LeftButton.setOnClickListener(this);
        KeYan.setOnClickListener(this);
        MenZhen.setOnClickListener(this);
        segmentedGroup = view.findViewById(R.id.id_top_about_right);

        segmentedGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.id_keyan) {
                    radioGroup.check(R.id.id_menzhen);
                } else if (checkedId == R.id.id_menzhen) {
                    KeYan.setChecked(true);
                    //radioGroup.check(R.id.id_keyan);
                }

               dialogEditText();
            }
        });

        return view;
    }


    private void dialogEditText() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = View
                .inflate(getActivity(), R.layout.alert_dialog, null);
        builder.setView(view);
        builder.setCancelable(true);

        final EditText input_edt = (EditText) view
                .findViewById(R.id.dialog_edit);//输入内容

        Button btn_comfirm = (Button) view
                .findViewById(R.id.btn_comfirm);//确定按钮

        btn_comfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = input_edt.getText().toString();
                if (pass.equals(GlogalBean.PassWord)) {

                    KeYan.setChecked(!KeYan.isChecked());
                    MenZhen.setChecked(!MenZhen.isChecked());
                    return;
                } else {
                    KeYan.setChecked(KeYan.isChecked());
                    MenZhen.setChecked(MenZhen.isChecked());
                    Toast.makeText(getActivity(), "密码错误!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //取消或确定按钮监听事件处理
        AlertDialog dialog = builder.create();
        Window window = dialog.getWindow();
        //这一句消除白块
        window.setBackgroundDrawable(new BitmapDrawable());
        dialog.show();

        WindowManager m = getActivity().getWindowManager();
        Display d = m.getDefaultDisplay();  //为获取屏幕宽、高
        android.view.WindowManager.LayoutParams p = dialog.getWindow().getAttributes();  //获取对话框当前的参数值
        // p.height = (int) (d.getHeight() * 0.3);   //高度设置为屏幕的0.3
        p.width = (int) (d.getWidth() * 0.8);    //宽度设置为屏幕的0.5
        dialog.getWindow().setAttributes(p);     //设置生效

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_top_left:
                onBack();
                break;

        }
    }
}
