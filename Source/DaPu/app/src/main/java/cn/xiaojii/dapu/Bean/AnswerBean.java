package cn.xiaojii.dapu.Bean;

public class AnswerBean {
    private int ImageId;//答案对应的ImageId
    private String Answer;//答案
    private String Order;//答案对应的序号(A/B/C/D)

    public String getOrder() {
        return Order;
    }

    public int getImageId() {
        return ImageId;
    }

    public String getAnswer() {
        return Answer;
    }

    public AnswerBean(int imageId, String answer,String order) {
        ImageId = imageId;
        Answer = answer;
        this.Order=order;
    }
}
