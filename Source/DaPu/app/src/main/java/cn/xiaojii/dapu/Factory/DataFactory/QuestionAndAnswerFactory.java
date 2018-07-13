package cn.xiaojii.dapu.Factory.DataFactory;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import cn.xiaojii.dapu.Bean.AnswerBean;
import cn.xiaojii.dapu.Bean.QuestionBean;
import cn.xiaojii.dapu.Bean.QuestionInJsonBean;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.ParseQuestionnaireJsonUtils;

public class QuestionAndAnswerFactory {

    private static List<QuestionInJsonBean> questionInJsonBeanList;
    private List<QuestionBean> questionBeanList;
    private static int[] ImageId = {R.mipmap.ic_correct, R.mipmap.ic_wrong};
    private static String[] StrAnswerCode = {"A", "B", "C", "D"};

    public static List<QuestionInJsonBean> GetDataFromJSONFile(Context context, String filename) {
        ParseQuestionnaireJsonUtils parseQuestionnaireJsonUtils = new ParseQuestionnaireJsonUtils(context);
        questionInJsonBeanList = parseQuestionnaireJsonUtils.GetJsonData(filename);
        return questionInJsonBeanList;
    }

    public static List<QuestionBean> GetNormalData(Context context, String filename) {

        List<QuestionBean> questionBeanList;


        List<QuestionInJsonBean> questionInJsonBeanList = QuestionAndAnswerFactory.GetDataFromJSONFile(context, filename);

        questionBeanList = new ArrayList<>();

        for (QuestionInJsonBean q : questionInJsonBeanList) {


            QuestionBean questionBean = new QuestionBean();
            questionBean.setQuestion(q.getQuestion());
            questionBean.setQuestionIndex(Integer.parseInt(q.getIndex()));

            List<AnswerBean> answerBeans = new ArrayList<>();
            for (int answerindex = 0; answerindex < q.getAnswerCandidate().size(); answerindex++) {
                AnswerBean answerBean = new AnswerBean();
                answerBean.setStringAnswer(q.getAnswerCandidate().get(answerindex));
                answerBean.setAnswerIndex(answerindex);
                if (answerindex < 4) {
                    questionBean.setCorrectAnswer(answerindex);
                    if (StrAnswerCode[answerindex].equals(q.getAnswer())) {
                        answerBean.setImageId(ImageId[0]);
                    } else {
                        answerBean.setImageId(ImageId[1]);
                    }
                }


                answerBeans.add(answerBean);

            }
            questionBean.setAnalysis(q.getAnswerHint());

            questionBean.setAnswerBeans(answerBeans);

            questionBeanList.add(questionBean);
        }

        return questionBeanList;
    }


}
