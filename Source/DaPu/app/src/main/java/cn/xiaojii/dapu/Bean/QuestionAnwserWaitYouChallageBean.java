package cn.xiaojii.dapu.Bean;

import java.util.List;

public class QuestionAnwserWaitYouChallageBean {
    private String Question;
    private int CorrectAnwserIndex;
    private List<AnswerBean> answerBeanList;
    private String Analysis;//解析

    public String getQuestion() {
        return Question;
    }

    public int getCorrectAnwserIndex() {
        return CorrectAnwserIndex;
    }


    public List<AnswerBean> getAnswerBeanList() {
        return answerBeanList;
    }

    public QuestionAnwserWaitYouChallageBean(String question, int correctAnwserIndex, List<AnswerBean> answerBeanList, String analysis) {

        Question = question;
        CorrectAnwserIndex = correctAnwserIndex;
        this.answerBeanList = answerBeanList;
        Analysis = analysis;
    }

    public String getAnalysis() {
        return Analysis;
    }


}
