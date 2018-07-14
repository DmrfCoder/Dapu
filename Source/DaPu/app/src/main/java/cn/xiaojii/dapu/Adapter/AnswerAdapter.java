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

        mPreItem = this.mCurrentItem;
        mPreItem2 = this.mCurrentItem2;
        this.mCurrentItem = -1;
        this.mCurrentItem2 = -1;
    }

    private Context context;
    private int mCurrentItem = -1;
    private int mCurrentItem2 = -1;

    private int mPreItem = -1;
    private int mPreItem2 = -1;


    private boolean isClick = false;


    public QuestionBean getQuestionBean() {
        return questionBean;
    }

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


        //下面两个if顺序不能乱
        if (mPreItem == position || mPreItem2 == position) {

            holder.TureOrFalseImageView.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));

        }

        if (mCurrentItem == position) {

            holder.TureOrFalseImageView.setBackgroundResource(R.mipmap.ic_wrong);

        }

        if (mCurrentItem2 == position) {
            holder.TureOrFalseImageView.setBackgroundResource(R.mipmap.ic_correct);
        }


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

    public void setCurrentItem(int mCurrentItem, int mCurrentItem2) {
        mPreItem = this.mCurrentItem;
        mPreItem2 = this.mCurrentItem2;
        this.mCurrentItem = mCurrentItem;
        this.mCurrentItem2 = mCurrentItem2;

    }


}


