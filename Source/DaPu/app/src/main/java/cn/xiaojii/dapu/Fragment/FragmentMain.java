package cn.xiaojii.dapu.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import cn.xiaojii.dapu.R;

/**
 * Created by Carson_Ho on 16/5/23.
 */
public class FragmentMain extends Fragment {
    private Button Bmi;
    private Button PhysicaIdentification;
    private Button WaitingForChallenge;
    private FragmentActivity fragmentActivity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fragmentActivity=getActivity();
        InitListener();

    }

    private void InitListener() {
        Bmi=fragmentActivity.findViewById(R.id.id_bmi);
        PhysicaIdentification=fragmentActivity.findViewById(R.id.id_physical_identification);
        WaitingForChallenge=fragmentActivity.findViewById(R.id.id_waiting_for_challenge);

        Bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_LONG).show();
            }
        });

        PhysicaIdentification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        WaitingForChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}

