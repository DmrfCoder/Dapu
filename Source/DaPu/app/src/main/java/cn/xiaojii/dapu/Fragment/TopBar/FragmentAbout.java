package cn.xiaojii.dapu.Fragment.TopBar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
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

import java.lang.reflect.Field;

import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.Fragment.BaseFragment.BaseFragment;
import cn.xiaojii.dapu.R;
import info.hoang8f.android.segmented.SegmentedGroup;

public class FragmentAbout extends BaseFragment implements View.OnClickListener {


    private Button LeftButton;
    private RadioButton KeYan;
    private RadioButton MenZhen;
    private SegmentedGroup segmentedGroup;
    private int CheckedId;


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

        CheckedId = R.id.id_keyan;

        segmentedGroup = view.findViewById(R.id.id_top_about_right);

        segmentedGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (CheckedId == R.id.id_keyan) {
                    KeYan.setChecked(true);
                    MenZhen.setChecked(false);
                } else {
                    KeYan.setChecked(false);
                    MenZhen.setChecked(true);
                }
            }
        });
        return view;
    }


    private void dialogEditText(final int code) {

        KeyListener listener = new NumberKeyListener() {

            /**
             * @return ：返回哪些希望可以被输入的字符,默认不允许输入
             */
            @Override
            protected char[] getAcceptedChars() {
                char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
                return chars;
//            return new char[0];
            }

            /**
             * 0：无键盘,键盘弹不出来
             * 1：英文键盘
             * 2：模拟键盘
             * 3：数字键盘
             *
             * @return
             */
            @Override
            public int getInputType() {
                return 3;
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = View
                .inflate(getActivity(), R.layout.alert_dialog, null);
        builder.setView(view);
        builder.setCancelable(true);

        final EditText input_edt = (EditText) view
                .findViewById(R.id.dialog_edit);//输入内容
        input_edt.setKeyListener(keyListener);
        Button btn_comfirm = (Button) view
                .findViewById(R.id.btn_comfirm);//确定按钮

        //取消或确定按钮监听事件处理
        final AlertDialog dialog = builder.create();
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


        btn_comfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = input_edt.getText().toString();
                if (pass.equals(GlogalBean.PassWord)) {
                    if (code == 0) {
                        CheckedId = R.id.id_keyan;
                        KeYan.setChecked(true);
                        MenZhen.setChecked(false);
                    } else {
                        CheckedId = R.id.id_menzhen;
                        KeYan.setChecked(false);
                        MenZhen.setChecked(true);
                    }

                } else {
                    if (code == 0) {
                        KeYan.setChecked(false);
                        MenZhen.setChecked(true);
                    } else {
                        KeYan.setChecked(true);
                        MenZhen.setChecked(false);
                    }

                    Toast.makeText(getActivity(), "密码错误!", Toast.LENGTH_SHORT).show();
                }

                dialog.dismiss();

            }
        });

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_about_top_left:
                onBack();
                break;
            case R.id.id_keyan:
                if (CheckedId == R.id.id_menzhen) {

                    dialogEditText(0);
                }
                break;
            case R.id.id_menzhen:
                if (CheckedId == R.id.id_keyan) {
                    dialogEditText(1);
                }
                break;

        }
    }
}
