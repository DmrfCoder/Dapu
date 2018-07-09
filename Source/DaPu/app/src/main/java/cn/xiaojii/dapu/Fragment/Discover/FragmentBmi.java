package cn.xiaojii.dapu.Fragment.Discover;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.xiaojii.dapu.Fragment.BaseFragment;
import cn.xiaojii.dapu.R;

public class FragmentBmi extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover_bmi, null);


        LeftButton = view.findViewById(R.id.id_top_left);
        view.findViewById(R.id.id_top_center).setVisibility(View.GONE);
        view.findViewById(R.id.id_top_right).setVisibility(View.GONE);
        LeftButton.setText("<发现");
        LeftButton.setOnClickListener(this);


        return view;
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
