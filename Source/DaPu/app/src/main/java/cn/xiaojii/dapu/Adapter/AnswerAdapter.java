package cn.xiaojii.dapu.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import cn.xiaojii.dapu.Bean.AnswerBean;
import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.Bean.QuestionBean;
import cn.xiaojii.dapu.R;


public class AnswerAdapter extends BaseAdapter {
    public void setQuestionBean(QuestionBean questionBean) {
        this.questionBean = questionBean;

        this.mCurrentItem = -1;
        this.mCurrentItem2 = -1;
        this.mCurrentItemNormal = -1;

    }

    private Context context;
    private int mCurrentItem = -1;
    private int mCurrentItem2 = -1;
    private int mCurrentItemNormal = -1;




    public void setmCurrentItemNormal(int mCurrentItemNormal) {
        this.mCurrentItemNormal = mCurrentItemNormal;
    }


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

    @SuppressLint("SetTextI18n")
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



        if (mCurrentItemNormal == position) {
            holder.TureOrFalseTextView.setText(GlogalBean.CorrentNumber);
        } else if (mCurrentItem == position) {
            holder.TureOrFalseTextView.setTextColor(context.getResources().getColor(R.color.colorRed));

            holder.TureOrFalseTextView.setText(GlogalBean.WrongNumber);

        } else if (mCurrentItem2 == position) {
            holder.TureOrFalseTextView.setTextColor(context.getResources().getColor(R.color.colorGreenLight));
            holder.TureOrFalseTextView.setText(GlogalBean.CorrentNumber);
        }else {
            holder.TureOrFalseTextView.setText("");
        }


        return convertView;
    }

    static class ViewHolder {


        public TextView AnswerText;

        public TextView TureOrFalseTextView;

        ViewHolder(View view) {
            this.AnswerText = view.findViewById(R.id.id_item_answers_listview_text);
            this.TureOrFalseTextView = view.findViewById(R.id.id_item_answers_textview_trueorfalse);
            this.TureOrFalseTextView.setText("");

        }
    }

    public void setCurrentItem(int mCurrentItem, int mCurrentItem2) {
        this.mCurrentItem = mCurrentItem;
        this.mCurrentItem2 = mCurrentItem2;

    }


}


