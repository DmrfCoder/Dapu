package cn.xiaojii.dapu.Fragment.TopBar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import cn.xiaojii.dapu.Fragment.BaseFragment.BaseFragment;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.StartUtils;

public class FragmentPdfReadList extends BaseFragment implements View.OnClickListener {
    private ListView listView;
    private String[] FileNameListShow = {"中国高血压防治指南(2010年修订版)", "高血压合理用药指南", "2014 年中国高血压患者教育指南(简明版)", "中国高血压基层管理指南(2014 年修订版)"};
    private String[] FileNameList = {"0.pdf", "1.pdf", "2.pdf", "3.pdf"};

    private Button Discover;
    private TextView Title;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_bar_pdf_read_list, null);


        Title = view.findViewById(R.id.id_top_center);
        Title.setText("资料");
        Title.setVisibility(View.VISIBLE);
        view.findViewById(R.id.id_top_right).setVisibility(View.GONE);
        Discover = view.findViewById(R.id.id_top_left);
        Discover.setText("<发现");
        Discover.setVisibility(View.VISIBLE);
        Discover.setOnClickListener(this);


        listView = view.findViewById(R.id.id_pdf_read_listview);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, FileNameListShow);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                StartUtils.startActivityToPdf(getContext(), FileNameList[position]);
            }
        });

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