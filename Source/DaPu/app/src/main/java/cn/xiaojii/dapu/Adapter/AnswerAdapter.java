package cn.xiaojii.dapu.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cn.xiaojii.dapu.Bean.AnswerBean;
import cn.xiaojii.dapu.R;


public class AnswerAdapter extends ArrayAdapter<AnswerBean> {

    private int ResourceId;

    public AnswerAdapter(@NonNull Context context, int ResourceId) {
        super(context, ResourceId);
        this.ResourceId = ResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        AnswerBean answerBean = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(ResourceId, null);
        TextView AnswerTextview = (TextView) view.findViewById(R.id.id_item_listview_answer_text);
        AnswerTextview.setText(answerBean.getAnswer());
        return view;

    }
}
