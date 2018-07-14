package cn.xiaojii.dapu.Bean;

public class AnswerBean {
    private int ImageId;//答案对应的ImageId
    private String StringAnswer;//答案
    private String AnswerIndex;//答案对应的序号(A/B/C/D)
    private String[] IndexString = {"A", "B", "C", "D","E","F"};

    public String getAnswerIndex() {
        return AnswerIndex;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
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

    public int getImageId() {
        return ImageId;
    }

    public String getStringAnswer() {
        return StringAnswer;
    }

    public AnswerBean() {
    }

    public AnswerBean(int imageId, String stringAnswer, int answerIndex) {
        ImageId = imageId;
        StringAnswer = stringAnswer;
        this.AnswerIndex = IndexString[answerIndex];
    }
}
