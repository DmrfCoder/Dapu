package cn.xiaojii.dapu.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cn.xiaojii.dapu.Bean.AnswerBean;
import cn.xiaojii.dapu.Bean.QuestionBean;
import cn.xiaojii.dapu.R;


public class AnswerAdapter extends BaseAdapter {
    public void setQuestionBean(QuestionBean questionBean) {
        this.questionBean = questionBean;
    }

    private Context context;
    private QuestionBean questionBean;


    public AnswerAdapter(Context context, QuestionBean questionBean) {
        this.context = context;
        this.questionBean = questionBean;
    }

    @Override
    public int getCount() {
        return questionBean.getAnswerBeans().size();
    }

    @Override
    public Object getItem(int position) {
        return questionBean.getAnswerBeans().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_answers_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        AnswerBean answer = questionBean.getAnswerBeans().get(position);
        holder.AnswerText.setText(answer.getAnswerIndex() + " " + answer.getStringAnswer());
        holder.TureOrFalseImageView.setBackgroundResource(answer.getImageId());
        holder.TureOrFalseImageView.setVisibility(View.GONE);
        return convertView;
    }

    static class ViewHolder {


        public TextView AnswerText;

        public ImageView TureOrFalseImageView;

        ViewHolder(View view) {
            this.AnswerText = view.findViewById(R.id.id_item_answers_listview_text);
            this.TureOrFalseImageView = view.findViewById(R.id.id_item_answers_listview_image);

        }
    }
}
