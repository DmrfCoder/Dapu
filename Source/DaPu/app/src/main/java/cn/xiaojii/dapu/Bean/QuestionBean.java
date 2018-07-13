package cn.xiaojii.dapu.Bean;

import java.util.List;

public class QuestionBean {
    private String Question;
    private int CorrectAnswer;
    private String Analysis;

    public String getAnalysis() {
        return Analysis;
    }

    public void setAnalysis(String analysis) {
        Analysis = analysis;
    }

    public int getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        CorrectAnswer = correctAnswer;
    }

    private int QuestionIndex;
    private List<AnswerBean> answerBeans;

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public int getQuestionIndex() {
        return QuestionIndex;
    }

    public void setQuestionIndex(int questionIndex) {
        QuestionIndex = questionIndex;
    }

    public List<AnswerBean> getAnswerBeans() {
        return answerBeans;
    }

    public void setAnswerBeans(List<AnswerBean> answerBeans) {
        this.answerBeans = answerBeans;
    }
}
