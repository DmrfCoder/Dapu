package cn.xiaojii.dapu.Bean;

import java.util.List;

public class QuestionInPdfBean {
    private List<String> AnswerCandidate;
    private String Chapter;
    private String Index;
    private String Question;
    private String Answer;
    private String AnswerHint;

    public List<String> getAnswerCandidate() {
        return AnswerCandidate;
    }

    public String getChapter() {
        return Chapter;
    }

    public String getIndex() {
        return Index;
    }

    public String getQuestion() {
        return Question;
    }

    public String getAnswer() {
        return Answer;
    }

    public String getAnswerHint() {
        return AnswerHint;
    }
}
