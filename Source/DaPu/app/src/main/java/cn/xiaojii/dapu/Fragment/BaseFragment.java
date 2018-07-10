package cn.xiaojii.dapu.Fragment;

import android.app.Instrumentation;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class BaseFragment extends Fragment implements View.OnClickListener {

    public Button LeftButton;
    public TextView CenterTextview;
    public Button RightButton;
    public ListView AnswerListView;
    public Button PreviousButton;
    public Button NextButton;
    public TextView QuestionTextView;




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

    public void UpdateView(int cur,int sum){
        CenterTextview.setText("问卷(" + cur + "/" + sum + ")");

    }
}
