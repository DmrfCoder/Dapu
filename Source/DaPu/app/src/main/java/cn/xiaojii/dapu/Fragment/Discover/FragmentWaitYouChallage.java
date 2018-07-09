package cn.xiaojii.dapu.Fragment.Discover;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.xiaojii.dapu.Fragment.BaseFragment;
import cn.xiaojii.dapu.R;

public class FragmentWaitYouChallage extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover_wait_you_challage, null);
        LeftButton = view.findViewById(R.id.id_top_left);
        CenterTextview = view.findViewById(R.id.id_top_center);
        view.findViewById(R.id.id_top_right).setVisibility(View.GONE);
        LeftButton.setText("<发现");
        LeftButton.setVisibility(View.VISIBLE);
        CenterTextview.setText("等你来挑战(1/5)");
        CenterTextview.setVisibility(View.VISIBLE);
        LeftButton.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_top_left:
                onBack();
                break;
            case R.id.id_bommom_bar_previous:
                break;
            case R.id.id_bottom_bar_next:
                break;
        }
    }
}
