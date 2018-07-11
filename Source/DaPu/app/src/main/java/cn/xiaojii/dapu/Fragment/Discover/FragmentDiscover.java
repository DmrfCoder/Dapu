package cn.xiaojii.dapu.Fragment.Discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.xiaojii.dapu.Activity.MainActivity;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.StartUtils;

/**
 * Created by Carson_Ho on 16/5/23.
 */
public class FragmentDiscover extends Fragment implements View.OnClickListener {
    private Button Bmi;
    private Button PhysicaIdentification;
    private Button WaitingForChallenge;
    private FragmentManager manager;
    private FragmentTransaction ft;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        manager = getFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, null);

        Bmi = view.findViewById(R.id.id_bmi);
        PhysicaIdentification = view.findViewById(R.id.id_physical_identification);
        WaitingForChallenge = view.findViewById(R.id.id_waiting_for_challenge);
        Bmi.setOnClickListener(this);
        PhysicaIdentification.setOnClickListener(this);
        WaitingForChallenge.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.id_waiting_for_challenge) {
            StartUtils.startActivityByJsonFileName(getActivity(), "WaitYouChallage");
        } else {
            StartUtils.startActivityById(getActivity(), view.getId());
        }
    }
}

