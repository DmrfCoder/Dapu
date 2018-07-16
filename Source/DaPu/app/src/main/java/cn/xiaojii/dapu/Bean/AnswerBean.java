package cn.xiaojii.dapu.Bean;

public class AnswerBean {
    private String CorrentOrWrong;//答案对应的ImageId
    private String StringAnswer;//答案
    private String AnswerIndex;//答案对应的序号(A/B/C/D)
    private String[] IndexString = {"A", "B", "C", "D","E","F"};

    public String getAnswerIndex() {
        return AnswerIndex;
    }

    public void setCorrentOrWrong(String correntOrWrong) {
        CorrentOrWrong = correntOrWrong;
    }

    public void setStringAnswer(String stringAnswer) {
        StringAnswer = stringAnswer;
    }

    public void setAnswerIndex(String answerIndex) {
        AnswerIndex = answerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        AnswerIndex = IndexString[answerIndex];
    }



    public void setIndexString(String[] indexString) {
        IndexString = indexString;
    }

    public String getCorrentOrWrong() {
        return CorrentOrWrong;
    }

    public String getStringAnswer() {
        return StringAnswer;
    }

    public AnswerBean() {
    }

    public AnswerBean(String correntOrWrong, String stringAnswer, int answerIndex) {
        CorrentOrWrong = correntOrWrong;
        StringAnswer = stringAnswer;
        this.AnswerIndex = IndexString[answerIndex];
    }
}
